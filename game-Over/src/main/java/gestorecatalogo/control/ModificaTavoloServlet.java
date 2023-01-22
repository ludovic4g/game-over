package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.TavoloDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaTavoloServlet
 */
@WebServlet(name = "ModificaTavoloServlet", value = "/ModificaTavoloServlet")
public class ModificaTavoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String action = request.getParameter("action");
		String p = request.getParameter("posti");
		String pp = request.getParameter("prezzo");
		String ora = request.getParameter("ora");
		String tipo = request.getParameter("tipo");
		String d = request.getParameter("disp");
		String img = request.getParameter("img");
		TavoloDAO tdao = new TavoloDAO();
		boolean disp=true;
		
		if(action.equals("nposti")) {
			int posti = Integer.parseInt(p);
			tdao.ModifyNumeroPosti(id, posti);
			response.sendRedirect("catalogo.jsp");
		}
		
		if(action.equals("prezzoposto")) {
			double prezzo = Double.parseDouble(pp);
			tdao.ModifyPrezzoPosto(id, prezzo);
			response.sendRedirect("catalogo.jsp");			
		}
		
		if(action.equals("ora")) {
			tdao.ModifyOra(id, ora);
			response.sendRedirect("catalogo.jsp");	
		}
		if(action.equals("tipo")) {
			tdao.ModifyTipo(id, tipo);
			response.sendRedirect("catalogo.jsp");	
		}
		if(action.equals("disp")) {
			if(d.equals("false")) disp=false;
			tdao.ModifyDisponibilita(id, disp);
			response.sendRedirect("catalogo.jsp");
		}
		if(action.equals("img")) {
			tdao.ModifyImg(id, img);
			response.sendRedirect("catalogo.jsp");	
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
