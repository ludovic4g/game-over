package utente.control;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloBean;
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
import gestorepren.model.RiferiscePPDAO;
import gestorepren.model.RiferiscePTDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.Carrello;
import utente.model.CompraBean;
import utente.model.CompraDAO;
import utente.model.UtenteBean;

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
		VideogiocoDAO vdao = new VideogiocoDAO();
		PrenotazioneBean prenotazione = new PrenotazioneBean();
		PrenotazioneDAO pdao = new PrenotazioneDAO();
		PostazioneDAO pp = new PostazioneDAO();
		Date date = new Date();
		String m = "";
		int size=0;
		int s=0;
		double total=0.00;
		
		ArrayList<VideogiocoBean> games= carrello.getGames();
		ArrayList<PostazioneBean> postazioni= carrello.getPostazioni();
		ArrayList<TavoloBean> tavoli= carrello.getTavoli();
		
		//setting ordine
		ordine.setDataAcquisto(date);
		ordine.setIva(0.22);
		for(VideogiocoBean b : games) {
				m=m.concat(b.getNome() + ", ");
				size++;
				b.updateMagazzino(b.getMagazzino()-b.getQuantita());
				vdao.ModifyMagazzino(b.getId(), b.getMagazzino());
			
		}
		
		for(PostazioneBean p : postazioni) {
			m=m.concat("Postazione n. " + p.getIdPostazione() + ", ");
			size++;
			s++;
			p.setDisp(false);
			pp.ModifyDisp(p.getIdPostazione(), false);
			total+=p.getPrezzo();
		}
		
		for(TavoloBean p : tavoli) {
			m=m.concat("Tavolo n. " + p.getIdTavolo() + ", ");
			size++;
			s++;
			p.setDisp(false);
			pp.ModifyDisp(p.getIdTavolo(), false);
			total+=p.getPrezzoPosto()*p.getNumeroPosti();
		}
		
		ordine.setListaProdotti(m);
		ordine.setNumeroProdotti(size);
		ordine.setPrezzoTotale(carrello.getTotal());
		ordine.setStato("In attesa di conferma.");
		ordine.setUtente(auth.getUsername());
		odao.doSave(ordine);
		
		//setting pren
		prenotazione.setDataprenotazione(date);
		prenotazione.setPostiPrenotati(s);
		prenotazione.setStato("In stato di conferma.");
		prenotazione.setUtente(auth.getUsername());
		prenotazione.setPrezzo(total);
		pdao.doSave(prenotazione);
		
		carrello.clear();
		response.sendRedirect("acquisto.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
