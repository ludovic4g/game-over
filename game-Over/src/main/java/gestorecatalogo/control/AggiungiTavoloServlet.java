package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.TavoloDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiTavoloServlet
 */
@WebServlet(name = "AggiungiTavoloServlet", value = "/AggiungiTavoloServlet")
public class AggiungiTavoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String tipo = request.getParameter("tipo");
		String ora = request.getParameter("ora");
		
		TavoloBean tavolo = new TavoloBean();
		TavoloDAO tdao= new TavoloDAO();
		
		tavolo.setDisp(true);


		tavolo.setOra(ora);
		if(tipo.equals("Carte")) tavolo.setPrezzoPosto(3.00);
		else tavolo.setPrezzoPosto(5.00);
		tavolo.setTipo(tipo);
		tdao.doSave(tavolo);
		response.sendRedirect("catalogo.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
