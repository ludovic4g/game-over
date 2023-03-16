package utente.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.VideogiocoBean;
import gestoreordini.model.IncludeBean;
import gestoreordini.model.IncludeDAO;
import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import gestoreordini.model.RiguardaBean;
import gestoreordini.model.RiguardaDAO;
import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;
import gestorepren.model.RiferiscePPDAO;
import gestorepren.model.RiferiscePTDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AcquistoRedirectServlet", value = "/AcquistoRedirectServlet")
public class AcquistoRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		CompraDAO cdao = new CompraDAO();
		CompraBean compra = new CompraBean();
		RiguardaDAO rdao = new RiguardaDAO();
		RiguardaBean riguarda = new RiguardaBean();
		RiferiscePPDAO rdaopp = new RiferiscePPDAO();
		RiferiscePTDAO rdaopt = new RiferiscePTDAO();
		IncludeDAO idao = new IncludeDAO();
		IncludeBean include = new IncludeBean();
		OrdineDAO odao = new OrdineDAO();
		OrdineBean ordine = new OrdineBean();
		PrenotazioneBean prenotazione = new PrenotazioneBean();
		PrenotazioneDAO pdao = new PrenotazioneDAO();
		Date date = new Date();
		
		ArrayList<VideogiocoBean> games= carrello.getGames();
		ArrayList<PostazioneBean> postazioni= carrello.getPostazioni();
		ArrayList<TavoloBean> tavoli= carrello.getTavoli();
		
		//setting ordine
		ordine.setDataAcquisto(date);
		ordine.setIva(0.22);
		for(VideogiocoBean b : games) {
			
		}
		ordine.setListaProdotti();
		ordine.setNumeroProdotti(0);
		ordine.setPrezzoTotale(carrello.getTotal());
		ordine.setStato("In attesa di conferma.");
		ordine.setUtente(auth.getUsername());
		
		//setting pren
		
		carrello.clear();
		response.sendRedirect("acquisto.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
