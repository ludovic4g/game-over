package utente.control;

import java.io.IOException;
import java.io.PrintWriter;

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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String mail = request.getParameter("mail");
		String risposta = request.getParameter("risposta");
		String action = request.getParameter("action");
		String pass1= request.getParameter("pass1");
		String pass2= request.getParameter("pass2");
		UtenteBean utente = new UtenteBean();
		UtenteDAO udao = new UtenteDAO();
		String u =null;
		PrintWriter out = response.getWriter();
		boolean m =false;
		boolean rs=false;
		boolean p1=false;
		boolean p2=false;
		
		if(action.equals("first")) {
			utente=udao.doRetrieveByMail(mail);
			if(utente.getEmail()==null) {
				out.print("Mail non esistente.");
				m=true;
				request.getSession().setAttribute("m", m);
				request.getSession().setAttribute("rs", rs);
				response.sendRedirect("recovery_psw_first.jsp");
				return;
			}else {
			if(utente!=null) {
				if(!risposta.equals(udao.doRetrieveRisposta(utente.getUsername()))) {
					rs=true;
					out.print("Risposta non corrispondente.");
					request.getSession().setAttribute("m", m);
					request.getSession().setAttribute("rs", rs);
					response.sendRedirect("recovery_psw_first.jsp");
					return;
				}else {
					out.print("Identificazione avvenuta correttamente.");
					request.getSession().setAttribute("m", m);
					request.getSession().setAttribute("rs", rs);
					request.getSession().setAttribute("utente", utente);
					response.sendRedirect("recovery_psw_field.jsp");
				}
			}
		}
		}
		
		if(action.equals("field")) {
			u = request.getParameter("id");
			if(utente.passControl(pass1)) {
					if(utente.passConferma(pass1,pass2)) {
						out.print("Recupero della password avvenuto correttamente.");
						udao.ModifyPassword(u, pass1);
						response.sendRedirect("login.jsp");
			}else {
				out.print("Password non coincidono.");
				p1=true;
				request.getSession().setAttribute("p1", p1);
				request.getSession().setAttribute("p2", p2);
				response.sendRedirect("recovery_psw_field.jsp");
				return;
			}
		}else {
			out.print("Password non valida.");
			p2=true;
			request.getSession().setAttribute("p1", p1);
			request.getSession().setAttribute("p2", p2);
			response.sendRedirect("recovery_psw_field.jsp");
			return;
		}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
