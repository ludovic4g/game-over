package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.PostazioneDAO;
import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.TavoloDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RedirectPrenotazioniServlet", value = "/RedirectPrenotazioniServlet")
public class RedirectPrenotazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String orario = request.getParameter("orario");
		String action = request.getParameter("action");
		PostazioneDAO pdao = new PostazioneDAO();
		ArrayList<PostazioneBean> postazioni = pdao.doRetrieveAll();
		ArrayList<PostazioneBean> sceltip = new ArrayList<PostazioneBean>();
		TavoloDAO tdao = new TavoloDAO();
		ArrayList<TavoloBean> tavoli = tdao.doRetrieveAll();
		ArrayList<TavoloBean> sceltit = new ArrayList<TavoloBean>();
		
		if(action.equals("postazioni")) {
			for(PostazioneBean p : postazioni) {
				if(p.getOra().equals(orario) || p.getOra().contains(orario)) sceltip.add(p);
			}
			request.getSession().setAttribute("lista", sceltip);
			response.sendRedirect("postazionedetails.jsp");
		}
		
		if(action.equals("tavoli")) {
			for(TavoloBean t : tavoli) {
				if(t.getOra().equals(orario)) sceltit.add(t);
			}

			request.getSession().setAttribute("lista", sceltit);
			response.sendRedirect("tavolodetails.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
