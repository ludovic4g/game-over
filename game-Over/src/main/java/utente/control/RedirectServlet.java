package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.VideogiocoBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.Carrello;
import utente.model.UtenteBean;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		
		boolean ctrl=false;
		if(carrello==null || carrello.isEmpty()) {
			ctrl=true;
			request.getSession().setAttribute("ctrl", ctrl);
			response.sendRedirect("cart.jsp");
			return;
		}
		if(auth==null) response.sendRedirect("login.jsp");
		else {
			ArrayList<VideogiocoBean> games = carrello.getGames();
			for(VideogiocoBean b: games) {
				if(b.getMagazzino()==0) {
					carrello.removeGame(b);
					response.sendRedirect("cart.jsp");
				}
			}
			response.sendRedirect("checkout_address.jsp");
		}
	}



}
