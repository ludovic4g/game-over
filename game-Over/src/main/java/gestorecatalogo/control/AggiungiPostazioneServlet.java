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
		String p = request.getParameter("prezzo");
		double prezzo = Double.parseDouble(p);
		String ora = request.getParameter("ora");
		String img = request.getParameter("img1");
		
		PostazioneBean postazione = new PostazioneBean();
		PostazioneDAO pdao = new PostazioneDAO();
		
		postazione.setDisp(true);
		postazione.setImg(img);
		postazione.setOra(ora);
		postazione.setPrezzo(prezzo);
		pdao.doSave(postazione);
		response.sendRedirect("addproduct.jsp");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
