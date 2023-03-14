package utente.control;

import java.io.IOException;

import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "CancelPrenotazioneServlet", value = "/CancelPrenotazioneServlet")

public class CancelPrenotazioneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			PrenotazioneDAO odao = new PrenotazioneDAO();
			PrenotazioneBean ordine = odao.doRetrieveByKey(id);
			
			ordine.setStato("Annullato");
			response.sendRedirect("prenotazioni.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
