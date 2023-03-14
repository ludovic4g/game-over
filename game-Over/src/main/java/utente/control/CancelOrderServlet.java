package utente.control;

import java.io.IOException;

import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CancelOrdineServlet", value = "/CancelOrdineServlet")
public class CancelOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		OrdineDAO odao = new OrdineDAO();
		OrdineBean ordine = odao.doRetriveByKey(id);
		
		ordine.setStato("Annullato");
		response.sendRedirect("orders.jsp");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}


}
