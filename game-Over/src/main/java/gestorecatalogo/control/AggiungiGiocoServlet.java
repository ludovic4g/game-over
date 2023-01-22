package gestorecatalogo.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiGiocoServlet
 */
@WebServlet(name = "AggiungiGiocoServlet", value = "/AggiungiGiocoServlet")
public class AggiungiGiocoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String nome = request.getParameter("name");
 		String q = request.getParameter("quantita");
 		int quantita = Integer.parseInt(q);
 		String a = request.getParameter("anno");
 		int anno = Integer.parseInt(a);
		String descrizione = request.getParameter("descrizione");
		String p = request.getParameter("prezzo");
		double prezzo = Double.parseDouble(p);
		String plat = request.getParameter("piattaforma");
		String img1 = request.getParameter("img1");
		String img2 = request.getParameter("img2");
		String img3 = request.getParameter("img3");
		String img4 = request.getParameter("img4");
		String img5 = request.getParameter("img5");
		
		VideogiocoBean game = new VideogiocoBean();
		VideogiocoDAO vdao = new VideogiocoDAO();
		
			game.setNome(nome);
			game.setAnno(anno);
			game.setDescrizione(descrizione);
			game.setImg1(img1);
			game.setImg2(img2);
			game.setImg3(img3);
			game.setImg4(img4);
			game.setImg5(img5);
			game.updateMagazzino(quantita);
			game.setPrezzo(prezzo);
			game.setQuantita(0);
			game.setTipo(plat);
			vdao.doSave(game);
			response.sendRedirect("addproduct.jsp");	
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
