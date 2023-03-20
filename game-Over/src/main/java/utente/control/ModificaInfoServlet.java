package utente.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.HaBean;
import utente.model.HaDAO;
import utente.model.IndirizzoBean;
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
		ArrayList<IndirizzoBean> indirizzi = (ArrayList<IndirizzoBean>) request.getSession().getAttribute("indirizzi");
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
		String ind= request.getParameter("num");
		String det= request.getParameter("det");
		UtenteDAO udao = new UtenteDAO();
		UtenteBean utente = new UtenteBean();
		IndirizzoDAO idao = new IndirizzoDAO();
		HaDAO hdao = new HaDAO();
		HaBean ha = null;
		PrintWriter out = response.getWriter();
		int i=0;
		boolean nm=false;
		boolean cn=false;
		boolean m1=false;
		boolean m2=false;
		boolean p1=false;
		boolean p2=false;
		boolean p3=false;
		boolean n1=false;
		boolean v=false;
		boolean pr=false;
		boolean cp=false;
		boolean ct=false;
		
		if(action.equals("nome")) {
			if(!utente.isValid(nome)) {
				nm=true;
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
				out.print("Nome non valido.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
			out.print("Modifica del profilo avvenuta correttamente.");
			udao.ModifyNome(id, nome);	
			response.sendRedirect("settings.jsp");
			}
		}
		
		if(action.equals("cognome")) {
			if(!utente.isValid(cognome)) {
				cn=true;
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
				out.print("Cognome non valido.");
				response.sendRedirect("settings.jsp");
				return;
			}else {
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
			udao.ModifyCognome(id, cognome);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		}
		if(action.equals("mail")) {
			if(!(mail.contains("@")&& mail.contains("."))) {
				m1=true;
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
				out.print("Mail non valida.");
				response.sendRedirect("settings.jsp");
				return;
			}else if(udao.doRetrieveByMail(mail).getEmail()!=null) {
				m2=true;
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
					out.print("Mail già esistente.");
					response.sendRedirect("settings.jsp");
					return;
				
			}else {
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("cn", cn);
				request.getSession().setAttribute("m1", m1);
				request.getSession().setAttribute("m2", m2);
				udao.ModifyMail(id, mail);
				out.print("Modifica del profilo avvenuta correttamente.");
				response.sendRedirect("settings.jsp");
				}
			}
		
		if(action.equals("ddn")) {
			request.getSession().setAttribute("nm", nm);
			request.getSession().setAttribute("cn", cn);
			request.getSession().setAttribute("m1", m1);
			request.getSession().setAttribute("m2", m2);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	        Date ddn = f.parse(data);
			udao.ModifyDDn(id, ddn);
			response.sendRedirect("settings.jsp");
		}
		
		if(action.equals("gender")) {
			request.getSession().setAttribute("nm", nm);
			request.getSession().setAttribute("cn", cn);
			request.getSession().setAttribute("m1", m1);
			request.getSession().setAttribute("m2", m2);
			udao.ModifyGender(id, gender);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		
		if(action.equals("risposta")) {
			request.getSession().setAttribute("nm", nm);
			request.getSession().setAttribute("cn", cn);
			request.getSession().setAttribute("m1", m1);
			request.getSession().setAttribute("m2", m2);
			udao.ModifyRisposta(id, risposta);
			out.print("Modifica del profilo avvenuta correttamente.");
			response.sendRedirect("settings.jsp");
			}
		
		if(action.equals("indirizzo")) {
			if(nomeind==null || !utente.isValid(nomeind)) {
				n1=true;
				request.getSession().setAttribute("n1", n1);
				request.getSession().setAttribute("v", v);
				request.getSession().setAttribute("pr", pr);
				request.getSession().setAttribute("cp", cp);
				request.getSession().setAttribute("ct", ct);
				out.print("Nome non valido.");
				if(det.equals("dashboard")) {
					
				response.sendRedirect("settings_address.jsp");	
				return;
				}else if(det.equals("checkout")){
					
					response.sendRedirect("checkout_address.jsp");	
					return;
				}
			}else {
		    if(utente.existLetterSp(via)) {
		    	v=true;
		    	request.getSession().setAttribute("n1", n1);
				request.getSession().setAttribute("v", v);
				request.getSession().setAttribute("pr", pr);
				request.getSession().setAttribute("cp", cp);
				request.getSession().setAttribute("ct", ct);
		    	out.print("Indirizzo non valido.");
		    	if(det.equals("dashboard")) {
		    		
		    	response.sendRedirect("settings_address.jsp");
				return;
		    	}else if(det.equals("checkout")){
		    		
		    		response.sendRedirect("checkout_address.jsp");	
					return;
		    	}
		    }else {
		    if(utente.existLetter(c) || utente.existLetterSp(c)) {
		    	cp=true;
		    request.getSession().setAttribute("n1", n1);
			request.getSession().setAttribute("v", v);
			request.getSession().setAttribute("pr", pr);
			request.getSession().setAttribute("cp", cp);
			request.getSession().setAttribute("ct", ct);
		    	out.print("CAP non valido.");
		    	if(det.equals("dashboard")) {
		    		
		    	response.sendRedirect("settings_address.jsp");
		    	return;
		    	}else if(det.equals("checkout")){
		    		
		    		response.sendRedirect("checkout_address.jsp");	
					return;
		    	}
		    }else {
		    	if(citta==null || citta.equals("") || !utente.isValid(citta)) {
		    		ct=true;
		    		request.getSession().setAttribute("n1", n1);
					request.getSession().setAttribute("v", v);
					request.getSession().setAttribute("pr", pr);
					request.getSession().setAttribute("cp", cp);
					request.getSession().setAttribute("ct", ct);
		    		out.print("Citta' non valida.");
		    		if(det.equals("dashboard")) {
		    			
		    		response.sendRedirect("settings_address.jsp");
		    		return;
		    		}else if(det.equals("checkout")){
		    			
		    			response.sendRedirect("checkout_address.jsp");	
						return;
		    		}
		    	}else {
		    		if(provincia==null || provincia.equals("") || provincia.length()!=2) {
		    			pr=true;
		    			request.getSession().setAttribute("n1", n1);
						request.getSession().setAttribute("v", v);
						request.getSession().setAttribute("pr", pr);
						request.getSession().setAttribute("cp", cp);
						request.getSession().setAttribute("ct", ct);
		    			out.print("Provincia non valida.");
		    			if(det.equals("dashboard")) {
		    
		    			response.sendRedirect("settings_address.jsp");
		    			return;
		    			}else if(det.equals("checkout")){
		    				response.sendRedirect("checkout_address.jsp");	
							return;
		    			}
		    		}else {
		    			if(det.equals("dashboard")) {
		    				request.getSession().setAttribute("n1", n1);
		    				request.getSession().setAttribute("v", v);
		    				request.getSession().setAttribute("pr", pr);
		    				request.getSession().setAttribute("cp", cp);
		    				request.getSession().setAttribute("ct", ct);
		    			ha = hdao.doRetrieveByUsername(id).get(Integer.parseInt(ind)-1);
						int addid = ha.getIdIndirizzo();
						int cap= Integer.parseInt(c);
						out.print("Modifica dell'indirizzo avvenuta correttamente.");
						idao.doUpdate(addid,nomeind , via, cap, citta, provincia);							
						response.sendRedirect("dashboard_user.jsp");	
		    			}else if(det.equals("checkout")){
		    				request.getSession().setAttribute("n1", n1);
		    				request.getSession().setAttribute("v", v);
		    				request.getSession().setAttribute("pr", pr);
		    				request.getSession().setAttribute("cp", cp);
		    				request.getSession().setAttribute("ct", ct);
		    				ha = hdao.doRetrieveByUsername(id).get(Integer.parseInt(ind)-1);
							int addid = ha.getIdIndirizzo();
							int cap= Integer.parseInt(c);
							out.print("Modifica dell'indirizzo avvenuta correttamente.");
							idao.doUpdate(addid,nomeind , via, cap, citta, provincia);							
							response.sendRedirect("checkout_address.jsp");	
		    			}
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
					request.getSession().setAttribute("p1", p1);
					request.getSession().setAttribute("p2", p2);
					request.getSession().setAttribute("p3", p3);
					udao.ModifyPassword(id, new1);
					out.print("Modifica della password avvenuta correttamente.");
					response.sendRedirect("settings_psw.jsp");
				}else {
					p3=true;
					request.getSession().setAttribute("p1", p1);
					request.getSession().setAttribute("p2", p2);
					request.getSession().setAttribute("p3", p3);
					out.print("Password non coincidono.");
					response.sendRedirect("settings_psw.jsp");
					return;
				}
				}else {
					p2=true;
					request.getSession().setAttribute("p1", p1);
					request.getSession().setAttribute("p2", p2);
					request.getSession().setAttribute("p3", p3);
					out.print("Password non valida.");
					response.sendRedirect("settings_psw.jsp");
				}
			}else {
				p1=true;
				request.getSession().setAttribute("p1", p1);
				request.getSession().setAttribute("p2", p2);
				request.getSession().setAttribute("p3", p3);
				out.print("Password attuale errata.");
				response.sendRedirect("settings_psw.jsp");
				return;
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
