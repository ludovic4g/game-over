package utente.control;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

/**
 * Servlet implementation class RecoveryPasswordServlet
 */
@WebServlet(name = "RecoveryPasswordServlet", value = "/RecoveryPasswordServlet")

public class RecoveryPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String mail = request.getParameter("mail");
		String risposta = request.getParameter("risposta");
		String action = request.getParameter("action");
		String pass1= request.getParameter("pass1");
		String pass2= request.getParameter("pass2");
		UtenteBean utente = new UtenteBean();
		UtenteDAO udao = new UtenteDAO();
		String u =null;
		
		if(action.equals("first")) {
			utente=udao.doRetrieveByMail(mail);
			if(utente!=null) {
				if(risposta.equals(udao.doRetrieveRisposta(utente.getUsername()))) {
					request.getSession().setAttribute("utente", utente);
					response.sendRedirect("recovery_psw_field.jsp");
				}
			}
		}
		
		if(action.equals("field")) {
			u = request.getParameter("id");
					if(pass1.equals(pass2)) {
				udao.ModifyPassword(u, pass1);
				response.sendRedirect("login.jsp");
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
