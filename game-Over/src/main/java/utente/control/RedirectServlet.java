package utente.control;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.UtenteBean;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		if(auth==null) response.sendRedirect("login.jsp");
		response.sendRedirect("checkout_final.jsp");
	}



}
