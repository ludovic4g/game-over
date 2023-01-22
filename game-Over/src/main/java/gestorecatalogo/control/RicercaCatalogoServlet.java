package gestorecatalogo.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.TavoloDAO;
import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RicercaCatalogoServlet
 */
@WebServlet(name = "RicercaCatalogoServlet", value = "/RicercaCatalogoServlet")
public class RicercaCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String cerca = request.getParameter("cerca");
		VideogiocoDAO vdao = new VideogiocoDAO();
		ArrayList<VideogiocoBean> games = vdao.doRetrieveAll();
		ArrayList<VideogiocoBean> lista1 = new ArrayList<VideogiocoBean>();
		
		PostazioneDAO pdao = new PostazioneDAO();
		ArrayList<PostazioneBean> post = pdao.doRetrieveAll();
		ArrayList<PostazioneBean> lista2 = new ArrayList<PostazioneBean>();
		
		TavoloDAO tdao = new TavoloDAO();
		ArrayList<TavoloBean> tavs = tdao.doRetrieveAll();
		ArrayList<TavoloBean> lista3 = new ArrayList<TavoloBean>();
		String m1 = "postazione";
		String m2 = "tavolo";
		
		for(VideogiocoBean b : games) {
            if(b.getNome().toLowerCase().contains(cerca)) lista1.add(b);
        }
		
		for(PostazioneBean b : post) {
            if(m1.toLowerCase().contains(cerca)) lista2.add(b);
        }
		
		for(TavoloBean b : tavs) {
            if(m2.toLowerCase().contains(cerca)) lista3.add(b);
            }
		
		 request.getSession().setAttribute("lista1", lista1);
		 request.getSession().setAttribute("lista2", lista2);
		 request.getSession().setAttribute("lista3", lista3);
		 
		 response.sendRedirect("catalogo-research.jsp");
		
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
