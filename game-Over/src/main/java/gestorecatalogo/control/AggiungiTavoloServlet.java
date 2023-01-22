package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.TavoloDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiTavoloServlet
 */
@WebServlet(name = "AggiungiTavoloServlet", value = "/AggiungiTavoloServlet")
public class AggiungiTavoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String pos = request.getParameter("posto");
		int posto = Integer.parseInt(pos);
		String tipo = request.getParameter("tavolo");
		String p = request.getParameter("prezzo");
		double prezzo = Double.parseDouble(p);
		String ora = request.getParameter("ora");
		String img = request.getParameter("img1");	
		
		TavoloBean tavolo = new TavoloBean();
		TavoloDAO tdao= new TavoloDAO();
		
		tavolo.setDisp(true);
		tavolo.setImg(img);
		tavolo.setNumeroPosti(posto);
		tavolo.setOra(ora);
		tavolo.setPrezzoPosto(prezzo);
		tavolo.setTipo(tipo);
		tdao.doSave(tavolo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
