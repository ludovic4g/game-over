package utente.control;

import java.io.IOException;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.Carrello;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")

public class AddToCartServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Carrello carrello;
		VideogiocoBean v = new VideogiocoBean();
		VideogiocoDAO vdao= new VideogiocoDAO();
		
		carrello= (Carrello) request.getSession().getAttribute("carrello");
		if(carrello==null) {
			carrello = new Carrello();
			request.getSession().setAttribute("car"
					+ " rello", carrello);
		}
		
		try {
		String m = request.getParameter("id");
		int id= Integer.parseInt(m);
		String action = request.getParameter("action");
		if(action.equals("lista")) {
			v=vdao.doRetriveByKey(id);
			carrello.addGame(v, 1);
			request.getSession().setAttribute("carrello",carrello);
			response.sendRedirect("shopgame.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrello carrello;
		VideogiocoBean v = new VideogiocoBean();
		VideogiocoDAO vdao =  new VideogiocoDAO();
		
		carrello = (Carrello) request.getSession().getAttribute("carrello");
		if(carrello==null) {
			carrello = new Carrello();
			request.getSession().setAttribute("carrello", carrello);
		}
		try {
			String m= request.getParameter("id");
			int id = Integer.parseInt(m);
			String m2 = request.getParameter("quantita");
			int quantita = Integer.parseInt(m2);
			String action = request.getParameter("action");
			String plat = request.getParameter("piattaforma");
			
			if(action.equals("details")) {
				v = vdao.doRetriveByKey(id);
				carrello.addGame(v, quantita);
				request.getSession().setAttribute("carrello", carrello);
				response.sendRedirect("shopgame.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
