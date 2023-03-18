package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloDAO;
import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import gestoreordini.model.IncludeBean;
import gestoreordini.model.IncludeDAO;
import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import gestoreordini.model.RiguardaBean;
import gestoreordini.model.RiguardaDAO;
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

@WebServlet(name = "CancelOrdineServlet", value = "/CancelOrdineServlet")
public class CancelOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		OrdineDAO odao = new OrdineDAO();
		OrdineBean ordine = odao.doRetriveByKey(id);
		RiguardaDAO rdao = new RiguardaDAO();
		VideogiocoDAO vdao = new VideogiocoDAO();
		VideogiocoBean v = new VideogiocoBean();
		ArrayList<RiguardaBean> rig =rdao.doRetriveByOrdine(id);
		PrenotazioneDAO pdao = new PrenotazioneDAO();
		PrenotazioneBean pren = new PrenotazioneBean();
		IncludeDAO idao = new IncludeDAO();
		ArrayList<IncludeBean> inc = idao.doRetrieveAll();
		RiferiscePPDAO ppdao = new RiferiscePPDAO();
		ArrayList<RiferiscePPBean> pp = ppdao.doRetrieveAll();
		RiferiscePTDAO ptdao = new RiferiscePTDAO();
		ArrayList<RiferiscePTBean> pt = ptdao.doRetrieveAll();
		PostazioneDAO podao = new PostazioneDAO();
		TavoloDAO tdao = new TavoloDAO();
		
		for(RiguardaBean r: rig) {
			if(r.getIdOrdine()==(id)) {
				v=vdao.doRetriveByKey(r.getId());
				vdao.ModifyMagazzino(v.getId(), v.getMagazzino()+1 );
			}
		}
		
		for(IncludeBean r : inc) {
			if(r.getIdOrdine()==id) {
				for(RiferiscePPBean l : pp) {
					if(l.getIdPrenotazione()==r.getIdPrenotazione()) {
						podao.ModifyDisp(l.getIdPostazione(), true);
					}
				}
			}
		}
		
		for(IncludeBean r : inc) {
			if(r.getIdOrdine()==id) {
				for(RiferiscePTBean l : pt) {
					if(l.getIdPrenotazione()==r.getIdPrenotazione()) {
						tdao.ModifyDisponibilita(l.getIdTavolo(), true);
					}
				}
			}
		}
		
		
		
		
		
		odao.doUpdate(id, "Annullato");
		
		
		response.sendRedirect("orders.jsp");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}


}
