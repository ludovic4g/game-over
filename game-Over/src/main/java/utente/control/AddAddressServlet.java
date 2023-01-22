package utente.control;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.HaBean;
import utente.model.HaDAO;
import utente.model.IndirizzoBean;
import utente.model.IndirizzoDAO;
import utente.model.UtenteBean;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet(name = "AddAddressServlet", value = "/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String checkedIds = request.getParameter("address-checkbox");
		System.out.println(checkedIds);
		int indice=5;
		IndirizzoBean scelto = new IndirizzoBean();
		ArrayList<IndirizzoBean> indirizzi = (ArrayList<IndirizzoBean>) request.getSession().getAttribute("indirizzi");
		if(indice==5) response.sendRedirect("checkout_address.jsp");
		else {
			request.getSession().setAttribute("scelto", scelto);
			response.sendRedirect("checkout_final.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta"); 
		String paese = request.getParameter("paese"); 
		String provincia = request.getParameter("provincia"); 
		String c = request.getParameter("cap");
		int cap = Integer.parseInt(c);
		String indirizzo = request.getParameter("indirizzo");
		String tel = request.getParameter("telefono");
		long telefono = Long.parseLong(tel);
		HaDAO hdao = new HaDAO();
		HaBean ha = new HaBean();
		int num= (int) Math.floor(Math.random() *(400 - 20 + 1) + 20);
		
		IndirizzoBean scelto = new IndirizzoBean();
		IndirizzoDAO idao = new IndirizzoDAO();
		scelto.setCAP(cap);
		scelto.setCitta(citta);
		scelto.setId(num);
		scelto.setProvincia(provincia);
		scelto.setVia(indirizzo);
		idao.doSave(scelto);
		ha.setIdIndirizzo(num);
		ha.setUsername(auth.getUsername());
		hdao.doSave(ha);
		
		request.getSession().setAttribute("scelto", scelto);
		response.sendRedirect("checkout_final.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
