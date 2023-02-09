package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "FilterServlet", value = "/Servlet")

public class FilterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String data1 = request.getParameter("inizio");
			String data2 = request.getParameter("fine");
			String action= request.getParameter("action");
			String filtro = request.getParameter("modo");
			String modo = request.getParameter("tipo");
			OrdineDAO odao= new OrdineDAO();
			ArrayList<OrdineBean> ordini = new ArrayList<OrdineBean>();
			PrenotazioneDAO pdao = new PrenotazioneDAO();
			ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();
			
			if(filtro.equals("pren")) {
			if(action.equals("data")) {
				prenotazioni= pdao.doRetriveByDates(data1, data2);		
				
				request.getSession().setAttribute("lista", prenotazioni);
				response.sendRedirect("prenotazioni-filter.jsp");
			}
			if(action.equals("alfabetico")) {
				if(modo.equals("za")) prenotazioni= pdao.doRetriveUsernameZA(); 
				else prenotazioni= pdao.doRetriveUsernameAZ(); 
				
				request.getSession().setAttribute("lista", prenotazioni);
				response.sendRedirect("prenotazioni-filter.jsp");
			}
			}
			
			if(filtro.equals("ordini")) {
				if(action.equals("data")) {
					ordini= odao.doRetriveByDates(data1, data2);		
					
					request.getSession().setAttribute("lista", ordini);
					response.sendRedirect("orders-filter.jsp");
				}
				if(action.equals("alfabetico")) {
					if(modo.equals("za")) ordini= odao.doRetriveUsernameZA(); 
					else ordini= odao.doRetriveUsernameAZ(); 
					
					request.getSession().setAttribute("lista", ordini);
					response.sendRedirect("orders-filter.jsp");
				}
				}
			
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
