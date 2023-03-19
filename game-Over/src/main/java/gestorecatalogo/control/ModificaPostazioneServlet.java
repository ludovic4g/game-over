package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.PostazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaPostazioneServlet
 */
@WebServlet(name = "ModificaPostazioneServlet", value = "/ModificaPostazioneServlet")
public class ModificaPostazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String action = request.getParameter("action");
		String p = request.getParameter("piattaforma");
		String ora = request.getParameter("ora");
		String d = request.getParameter("disp");
		String img = request.getParameter("img");
		boolean disp=true;

		
		PostazioneDAO pdao = new PostazioneDAO();
		if(action.equals("piattaforma")) {
			pdao.ModifyTipo(id, p);
			response.sendRedirect("catalogo.jsp");
			
		}
		
		if(action.equals("ora")) {
			pdao.ModifyOra(id, ora);
			response.sendRedirect("catalogo.jsp");
		}
		
		if(action.equals("disp")) {
			if(d.equals("false")) disp=false;
			else disp=true;
			pdao.ModifyDisp(id, disp);
			response.sendRedirect("catalogo.jsp");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
