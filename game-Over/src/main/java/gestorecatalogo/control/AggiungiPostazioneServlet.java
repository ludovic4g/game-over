package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.PostazioneDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiPostazioneServlet
 */
@WebServlet(name = "AggiungiPostazioneServlet", value = "/AggiungiPostazioneServlet")
public class AggiungiPostazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String ora = request.getParameter("ora");
		String tipo = request.getParameter("piattaforma");
		
		
		PostazioneBean postazione = new PostazioneBean();
		PostazioneDAO pdao = new PostazioneDAO();
		
		postazione.setDisp(true);
		postazione.setOra(ora);
		postazione.setTipo(tipo);
		if(tipo.equals("PC")) postazione.setPrezzo(10.00);
		else postazione.setPrezzo(8.00);
		pdao.doSave(postazione);
		response.sendRedirect("addproduct.jsp");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
