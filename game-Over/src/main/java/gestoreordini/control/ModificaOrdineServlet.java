package gestoreordini.control;

import java.io.IOException;

import gestoreordini.model.OrdineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaOrdineServlet
 */
@WebServlet(name = "ModificaOrdineServlet", value = "/ModificaOrdineServlet")
public class ModificaOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String stato = request.getParameter("stato");
		
		OrdineDAO odao = new OrdineDAO();
		odao.doUpdate(id, stato);
		response.sendRedirect("orderlist.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
