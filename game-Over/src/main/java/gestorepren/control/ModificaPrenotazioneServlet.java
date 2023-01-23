package gestorepren.control;

import java.io.IOException;

import gestorepren.model.PrenotazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaPrenotazioneServlet
 */
@WebServlet(name = "ModificaPrenotazioneServlet", value = "/ModificaPrenotazioneServlet")
public class ModificaPrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			String stato = request.getParameter("stato");
			
			PrenotazioneDAO odao = new PrenotazioneDAO();
			odao.doUpdate(id, stato);
			response.sendRedirect("modify_prenotazioni.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
