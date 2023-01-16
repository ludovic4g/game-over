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

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet(name = "RemoveFromCartServlet", value = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Carrello carrello = null;
		carrello = (Carrello) request.getSession().getAttribute("carrello");
		
		ArrayList<VideogiocoBean> games = carrello.getGames();
		
		String i = request.getParameter("id");
		int id=0;
		if(i!=null) id=Integer.parseInt(i);
		
		if(action.equals("game")) {
			for(VideogiocoBean v: games) {
				if(id==v.getId()) {
					carrello.removeGame(v);
					break;
				}
			}
			response.sendRedirect("cart.jsp");
		}
		
		else if(action.equals("clear")) {
			carrello.clear();
			response.sendRedirect("cart.jsp");
		}
		
	}


}
