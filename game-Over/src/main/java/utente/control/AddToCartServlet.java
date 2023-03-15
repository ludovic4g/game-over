package utente.control;

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
import utente.model.Carrello;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")

public class AddToCartServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Carrello carrello;
		VideogiocoBean v = new VideogiocoBean();
		VideogiocoDAO vdao= new VideogiocoDAO();
		
		carrello= (Carrello) request.getSession().getAttribute("carrello");
		if(carrello==null) {
			carrello = new Carrello();
			request.getSession().setAttribute("car"
					+ " rello", carrello);
		}
		
		try {
		String m = request.getParameter("id");
		int id= Integer.parseInt(m);
		String action = request.getParameter("action");
		if(action.equals("lista")) {
			v=vdao.doRetriveByKey(id);
			carrello.addGame(v, 1);
			request.getSession().setAttribute("carrello",carrello);
			response.sendRedirect("shopgame.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrello carrello;
		PostazioneBean p = new PostazioneBean();
		PostazioneDAO pdao = new PostazioneDAO();
		TavoloBean t = new TavoloBean();
		TavoloDAO tdao = new TavoloDAO();
		VideogiocoBean v = new VideogiocoBean();
		VideogiocoDAO vdao =  new VideogiocoDAO();
		String action = request.getParameter("action");
		carrello = (Carrello) request.getSession().getAttribute("carrello");
		if(carrello==null) {
			carrello = new Carrello();
			request.getSession().setAttribute("carrello", carrello);
		}
		
		if(action.equals("postazioni")) {
			try {
			String tipo = request.getParameter("tipo");
			String button = request.getParameter("button");
			ArrayList<PostazioneBean> lista = (ArrayList<PostazioneBean>) request.getSession().getAttribute("lista");
			
			p= pdao.doRetriveByKey(Integer.parseInt(button));
			if(tipo.equals("PC")) p.setPrezzo(10.00);
			else p.setPrezzo(8.00);
			carrello.addPostazione(p);
			request.getSession().setAttribute("carrello", carrello);
			response.sendRedirect("esport.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
			if(action.equals("tavoli")) {
				try {
					String tipo = request.getParameter("tipo");
					String button = request.getParameter("button");
					String num = request.getParameter("persone");
					ArrayList<TavoloBean> lista = (ArrayList<TavoloBean>) request.getSession().getAttribute("lista");
					
					t= tdao.doRetriveByKey(Integer.parseInt(button));
					t.setTipo(tipo);
					t.setNumeroPosti(Integer.parseInt(num));
					if(tipo.equals("Tavolo")) t.setPrezzoPosto(5.00);
					else t.setPrezzoPosto(3.00);
					carrello.addTavolo(t);
					request.getSession().setAttribute("carrello", carrello);
					response.sendRedirect("esport.jsp");
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
			
		if(action.equals("details")) {
		try {
			String m= request.getParameter("id");
			int id = Integer.parseInt(m);
			String m2 = request.getParameter("quantita");
			int quantita = Integer.parseInt(m2);
			String plat = request.getParameter("piattaforma");
			
				v = vdao.doRetriveByKey(id);
				carrello.addGame(v, quantita);
				request.getSession().setAttribute("carrello", carrello);
				response.sendRedirect("shopgame.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		
	}

}
