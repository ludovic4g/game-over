package utente.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.IndirizzoDAO;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String id = request.getParameter("id");
		String add = request.getParameter("add");
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
		IndirizzoDAO idao = new IndirizzoDAO();
		
		if(action.equals("nome")) {
			udao.ModifyNome(id, nome);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("cognome")) {
			udao.ModifyCognome(id, cognome);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("mail")) {
			udao.ModifyMail(id, mail);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("ddn")) {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	        Date ddn = f.parse(data);
			udao.ModifyDDn(id, ddn);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("gender")) {
			udao.ModifyGender(id, gender);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("domanda")) {
			udao.ModifyDomanda(id, domanda);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("risposta")) {
			udao.ModifyRisposta(id, risposta);
			response.sendRedirect("settings.jsp");
		}
		if(action.equals("indirizzo")) {
			if(add!=null && c!=null) {
			int addid = Integer.parseInt(add);
			int cap= Integer.parseInt(c);
			idao.doUpdate(addid,nomeind , via, cap, citta, provincia);
			response.sendRedirect("settings.jsp");
			}
		}
		if(action.equals("password")) {
			if(old.equals(udao.doRetrievePassword(id))){
				if(new1.equals(new2)) {
					udao.ModifyPassword(id, new1);
					response.sendRedirect("settings.jsp");
				}
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
