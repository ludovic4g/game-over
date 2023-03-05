package utente.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.HaBean;
import utente.model.HaDAO;
import utente.model.IndirizzoDAO;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

/**
 * Servlet implementation class ModificaInfoServlet
 */
@WebServlet(name = "ModificaInfoServlet", value = "/ModificaInfoServlet")
public class ModificaInfoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String nome = request.getParameter("nome");
		String nomeind = request.getParameter("nomeind");
		String cognome = request.getParameter("cognome");
		String mail = request.getParameter("mail");
		String data = request.getParameter("ddn"); //parse
		String gender = request.getParameter("gender");
		String domanda = request.getParameter("domanda");
		String risposta = request.getParameter("risposta");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		String c = request.getParameter("cap"); //parse
		String via = request.getParameter("via");
		String old = request.getParameter("old");
		String new1 = request.getParameter("new1");
		String new2= request.getParameter("new2");
		UtenteDAO udao = new UtenteDAO();
		UtenteBean utente = new UtenteBean();
		IndirizzoDAO idao = new IndirizzoDAO();
		HaDAO hdao = new HaDAO();
		HaBean ha = null;
		/*Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\\\\\[\\\\\\\\]~-]", Pattern.CASE_INSENSITIVE);
	    Matcher m = p.matcher(via);
	    Boolean bb = m.find();*/
		PrintWriter out = response.getWriter();
		
		if(action.equals("nome")) {
			if(!utente.isValid(nome)) {
				out.print("Nome non valido.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
			out.print("Modifica del profilo avvenuta correttamente.");
			udao.ModifyNome(id, nome);	
			response.sendRedirect("settings.jsp");
			}
		}
		
		if(action.equals("cognome")) {
			if(!utente.isValid(cognome)) {
				out.print("Cognome non valido.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
			udao.ModifyCognome(id, cognome);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		}
		if(action.equals("mail")) {
			if(!(mail.contains("@")&& mail.contains("."))) {
				out.print("Mail non valida.");
				response.sendRedirect("settings.jsp");
				return;
			}else { 
				ArrayList<UtenteBean> mails = udao.doRetrieveAll();
				int i=0;;
				for(UtenteBean b : mails) {
					if(b.getEmail().equals(mail)) i++;
					break;
				}
				if(i>0) {
					out.print("Mail gi� esistente.");
					response.sendRedirect("settings.jsp");
					return;
			}else {
				udao.ModifyMail(id, mail);
				out.print("Modifica del profilo avvenuta correttamente.");
				response.sendRedirect("settings.jsp");
				}
			}
		}
		if(action.equals("ddn")) {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	        Date ddn = f.parse(data);
			udao.ModifyDDn(id, ddn);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("gender")) {
			if(gender=="" || gender==null) {
				out.print("Genere non valido.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
			udao.ModifyGender(id, gender);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		}
		
		if(action.equals("risposta")) {
			if(risposta=="" || risposta==null) {
				out.print("Risposta non valida.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
			udao.ModifyRisposta(id, risposta);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		}
		if(action.equals("indirizzo")) {
			if(nome==null || !utente.isValid(nome)) {
				out.print("Nome non valido.");
				return;
			}else {
		    if(utente.existLetterSp(via)) {
		    	out.print("Indirizzo non valido.");
				return;
		    }else {
		    if(utente.existLetter(c) || utente.existLetterSp(c)) {
		    	out.print("CAP non valido.");
		    	return;
		    }else {
		    	if(citta==null || citta.equals("")) {
		    		out.print("Citta' non valida.");
		    		return;
		    	}else {
		    		if(provincia==null || provincia.equals("") || provincia.length()!=2) {
		    			out.print("Provincia non valida.");
		    			return;
		    		}else {
		    			ha = hdao.doRetrieveByUsername(id);
						int addid = ha.getIdIndirizzo();
						int cap= Integer.parseInt(c);
						out.print("Modifica dell'indirizzo avvenuta correttamente.");
						idao.doUpdate(addid,nomeind , via, cap, citta, provincia);							
						response.sendRedirect("settings.jsp");	
		    		}
		    	}
		    }
		    }
		}
		}

		if(action.equals("password")) {
			if(old.equals(udao.doRetrieveByKey(id).getPassword())){
				if(utente.passControl(new1)) {
					
				if(new1.equals(new2)) {
					udao.ModifyPassword(id, new1);
					out.print("Modifica della password avvenuta correttamente.");
					response.sendRedirect("settings.jsp");
				}else {
					out.print("Password non coincidono.");
					response.sendRedirect("settings.jsp");
					return;
				}
				}else {
					out.print("Password non valida.");
					response.sendRedirect("settings.jsp");
				}
			}else {
				out.print("Password attuale errata.");
				response.sendRedirect("settings.jsp");
				return;
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
