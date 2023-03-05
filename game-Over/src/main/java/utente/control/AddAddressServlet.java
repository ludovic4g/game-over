package utente.control;

import java.io.IOException;
import java.io.PrintWriter;
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
		int indice = Integer.parseInt(checkedIds);
		IndirizzoDAO idao = new IndirizzoDAO();
		try {
			IndirizzoBean scelto = idao.doRetrieveByKey(indice);
			if(scelto==null) response.sendRedirect("checkout_address.jsp");
			else {
				request.getSession().setAttribute("scelto", scelto);
				response.sendRedirect("checkout_final.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
		String nome = request.getParameter("nome");
		String citta = request.getParameter("citta"); 
		String paese = request.getParameter("paese"); 
		String provincia = request.getParameter("provincia"); 
		String c = request.getParameter("cap");
		
		String indirizzo = request.getParameter("indirizzo");
		HaDAO hdao = new HaDAO();
		HaBean ha = new HaBean();
		UtenteBean ctrl = new UtenteBean();
		PrintWriter out = response.getWriter();
		
		IndirizzoBean scelto = new IndirizzoBean();
		IndirizzoDAO idao = new IndirizzoDAO();
		if(!ctrl.isValid(nome)) {
			out.print("Nome non valido.");
			return;
			
		}
		scelto.setNome(nome);
		if(!ctrl.existLetter(c)) {
			int cap = Integer.parseInt(c);
			scelto.setCAP(cap);
		}else {
			out.print("CAP non valido.");
			return;
		}
		
		if(citta==null || citta.equals("")) {
			out.print("Citta' non valida.");
			return;
		}
		scelto.setCitta(citta);
		if(provincia==null || provincia.equals("") || provincia.length()!=2) {
			out.print("Provincia non valida.");
			return;
		}
		scelto.setProvincia(provincia);
		
		if(ctrl.existLetterSp(indirizzo)) {
			out.print("Indirizzo non valido.");
			return;
		}
		scelto.setVia(indirizzo);
		out.print("Aggiunta indirizzo avvenuta correttamente.");
		idao.doSave(scelto);
		ArrayList<IndirizzoBean> lista = idao.doRetrieveAll();
		ha.setIdIndirizzo(lista.size());
		ha.setUsername(auth.getUsername());
		hdao.doSave(ha);
		
		request.getSession().setAttribute("scelto", scelto);
		response.sendRedirect("checkout_final.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
