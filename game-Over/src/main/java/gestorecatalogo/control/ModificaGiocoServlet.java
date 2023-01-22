package gestorecatalogo.control;

import java.io.IOException;

import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaGiocoServlet
 */
@WebServlet(name = "ModificaGiocoServlet", value = "/ModificaGiocoServlet")
public class ModificaGiocoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			
			String nome= request.getParameter("nome");
			String descrizione = request.getParameter("desc");
			String p = request.getParameter("prezzo");
			
			String plat = request.getParameter("piattaforma");
			String a = request.getParameter("anno");
		
			String img1 = request.getParameter("img1");
			String img2 = request.getParameter("img2");
			String img3 = request.getParameter("img3");
			String img4 = request.getParameter("img4");
			String img5 = request.getParameter("img5");
			
			VideogiocoDAO vdao= new VideogiocoDAO();
			
			String action= request.getParameter("action");
			if(action.equals("nome")) {
				vdao.ModifyNome(id, nome);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("anno")) {
				int anno = Integer.parseInt(a);
				vdao.ModifyAnno(id, anno);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("descrizione")) {
				vdao.ModifyDescrizione(id, descrizione);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("prezzo")) {
				double prezzo = Double.parseDouble(p);
				vdao.ModifyPrezzo(id, prezzo);
				response.sendRedirect("catalogo.jsp");
			}
			if(action.equals("plat")) {
				vdao.ModifyPiattaforma(id, plat);
				response.sendRedirect("catalogo.jsp");
			}
			if(action.equals("img1")) {
				vdao.ModifyImg12(id, img1,img2);
				response.sendRedirect("catalogo.jsp");
			}
			if(action.equals("img2")) {
				vdao.ModifyImg345(id, img3,img4,img5);
				response.sendRedirect("catalogo.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
