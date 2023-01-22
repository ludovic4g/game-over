package gestoreordini.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiltraOrdiniAlfabeticoServlet
 */
@WebServlet(name = "FiltraOrdiniServlet", value = "/FiltraOrdiniServlet")
public class FiltraOrdiniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String data1 = request.getParameter("inizio");
		String data2 = request.getParameter("fine");
		String action= request.getParameter("action");
		String modo = request.getParameter("tipo");
		OrdineDAO odao= new OrdineDAO();
		ArrayList<OrdineBean> ordini = new ArrayList<OrdineBean>();
		ArrayList<OrdineBean> from = new ArrayList<OrdineBean>();
		ArrayList<OrdineBean> to = new ArrayList<OrdineBean>();
		
		if(action.equals("data")) {
			ordini= odao.doRetriveByDates(data1, data2);		
			
			request.getSession().setAttribute("lista", ordini);
			response.sendRedirect("orderlist-data.jsp");
		}
		if(action.equals("alfabetico")) {
			if(modo.equals("za")) ordini= odao.doRetriveUsernameZA(); 
			else ordini= odao.doRetriveUsernameAZ(); 
			
			request.getSession().setAttribute("lista", ordini);
			response.sendRedirect("orderlist-alfabetico.jsp");
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
	
	}
	}

}
