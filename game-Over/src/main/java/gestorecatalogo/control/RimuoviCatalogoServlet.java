package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloDAO;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RimuoviCatalogoServlet
 */
@WebServlet(name = "RimuoviCatalogoServlet", value = "/RimuoviServlet")
public class RimuoviCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String i = request.getParameter("id");
		int id=Integer.parseInt(i);
		String action = request.getParameter("action");
		VideogiocoDAO vdao = new VideogiocoDAO();
		PostazioneDAO pdao = new PostazioneDAO();
		TavoloDAO tdao = new TavoloDAO();
		if(action.equals("gioco")) {
			vdao.doDelete(id);
			response.sendRedirect("rimuoviprodotto.jsp");
		}
		if(action.equals("post")) {
			pdao.doDelete(id);
			response.sendRedirect("rimuoviprodotto.jsp");
		}
		if(action.equals("tav")) {
			tdao.doDelete(id);
			response.sendRedirect("rimuoviprodotto.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
