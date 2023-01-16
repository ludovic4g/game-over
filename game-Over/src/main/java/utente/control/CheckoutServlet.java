package utente.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import gestoreordini.model.RiguardaBean;
import gestoreordini.model.RiguardaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.Carrello;
import utente.model.CompraBean;
import utente.model.CompraDAO;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		UtenteDAO udao = new UtenteDAO();
		VideogiocoBean v = new VideogiocoBean();
		VideogiocoDAO vdao = new VideogiocoDAO();
		ArrayList<VideogiocoBean> games = carrello.getGames();
		OrdineBean o = new OrdineBean();
		OrdineDAO odao = new OrdineDAO();
		RiguardaBean riguarda = new RiguardaBean();
		RiguardaDAO rdao = new RiguardaDAO();
		CompraBean compra = new CompraBean();
		CompraDAO cdao = new CompraDAO();
		ArrayList<OrdineBean> ordini = odao.doRetrieveAll();
		int num=0;
		Random rand = new Random();
		Date d = new Date();
		int size=0;
		String m= "";
		
		if(carrello!= null && auth!= null) {
			for(OrdineBean f: ordini) {			
				num= Math.abs(rand.nextInt(400));
				if(f.getIdOrdine()!=num) {
					o.setIdOrdine(num);
					riguarda.setIdOrdine(num);
				}
			}
		}
		
		o.setUtente(auth.getUsername());
		o.setPrezzoTotale(carrello.getTotal());
		o.setDataAcquisto(d);
		o.setIva(0.22);
		o.setStato("In Preparazione");
		for(VideogiocoBean f : games) {
			if(f.getMagazzino()!=0) {
			compra.setIdVideogioco(f.getId());
			compra.setUsername(auth.getUsername());
			cdao.doSave(compra);
			riguarda.setId(f.getId());
			rdao.doSave(riguarda);
			size++;
			m=m.concat(f.getNome() + "," + "\n");
			f.updateMagazzino(f.getMagazzino()-1);
			vdao.ModifyQuantitaInMagazzino(f.getId(), f.getMagazzino());
			}
		}
		
		o.setListaProdotti(m);
		o.setNumeroProdotti(size);
		odao.doSave(o);
		
		
		carrello.clear();
		response.sendRedirect("index.jsp");
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
