package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloDAO;
import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;
import gestorepren.model.RiferiscePPBean;
import gestorepren.model.RiferiscePPDAO;
import gestorepren.model.RiferiscePTBean;
import gestorepren.model.RiferiscePTDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "DeletePrenServlet", value = "/DeletePrenServlet")

public class DeletePrenServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			PrenotazioneDAO odao = new PrenotazioneDAO();
			RiferiscePPDAO ppdao = new RiferiscePPDAO();
			ArrayList<RiferiscePPBean> pp = ppdao.doRetrieveAll();
			RiferiscePTDAO ptdao = new RiferiscePTDAO();
			ArrayList<RiferiscePTBean> pt = ptdao.doRetrieveAll();
			PostazioneDAO pdao = new PostazioneDAO();
			TavoloDAO tdao = new TavoloDAO();
			
			
			odao.doUpdate(id, "Annullato");
			for(RiferiscePPBean r : pp) {
				if(r.getIdPrenotazione()==id) {
					pdao.ModifyDisp(r.getIdPostazione(), true);
				}
			}
				
				for(RiferiscePTBean r : pt) {
					if(r.getIdPrenotazione()==id) {
						tdao.ModifyDisponibilita(r.getIdTavolo(), true);
					}
				
			}
			
			response.sendRedirect("prenotazioni.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
