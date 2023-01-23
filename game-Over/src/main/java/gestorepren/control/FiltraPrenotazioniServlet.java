package gestorepren.control;

import java.io.IOException;
import java.util.ArrayList;

import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiltraPrenotazioniServlet
 */
@WebServlet(name = "FiltraPrenotazioniServlet", value = "/FiltraPrenotazioniServlet")
public class FiltraPrenotazioniServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String data1 = request.getParameter("inizio");
		String data2 = request.getParameter("fine");
		String action= request.getParameter("action");
		String modo = request.getParameter("tipo");
		PrenotazioneDAO pdao= new PrenotazioneDAO();
		ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();
		
		if(action.equals("data")) {
			prenotazioni= pdao.doRetriveByDates(data1, data2);		
			
			request.getSession().setAttribute("lista", prenotazioni);
			response.sendRedirect("prenotazioni-data.jsp");
		}
		if(action.equals("alfabetico")) {
			if(modo.equals("za")) prenotazioni= pdao.doRetriveUsernameZA(); 
			else prenotazioni= pdao.doRetriveUsernameAZ(); 
			
			request.getSession().setAttribute("lista", prenotazioni);
			response.sendRedirect("prenotazioni-alfabetico.jsp");
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
	
	}
}
}
