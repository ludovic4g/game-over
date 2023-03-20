package gestorecatalogo.control;

import java.io.IOException;
import java.io.PrintWriter;

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			
			String nome= request.getParameter("nome");
			String descrizione = request.getParameter("desc");
			String p = request.getParameter("prezzo");
			String m = request.getParameter("magazzino");
			String plat = request.getParameter("piattaforma");
			String a = request.getParameter("anno");
			PrintWriter out = response.getWriter();
			String img1 = request.getParameter("img1");
			String img2 = request.getParameter("img2");
			String img3 = request.getParameter("img3");
			String img4 = request.getParameter("img4");
			String img5 = request.getParameter("img5");
			boolean nm = false;
			boolean i1= false;
			boolean i2=false;
			
			VideogiocoDAO vdao= new VideogiocoDAO();
			
			String action= request.getParameter("action");
			if(action.equals("nome")) {
				if((vdao.doRetriveByName(nome).getNome()==null)) {
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Modifica del gioco avvenuta correttamente.");
					vdao.ModifyNome(id, nome);
					response.sendRedirect("catalogo.jsp");
				
				}else if(vdao.doRetriveByName(nome).getNome()!=null){
					nm=true;
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Nome già esistente.");
					response.sendRedirect("catalogo.jsp");
					return;
				}
		}
			if(action.equals("anno")) {
				int anno = Integer.parseInt(a);
				vdao.ModifyAnno(id, anno);
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("i1", i1);
				request.getSession().setAttribute("i2", i2);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("magazzino")) {
				int mag = Integer.parseInt(m);
				vdao.ModifyMagazzino(id, mag);
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("i1", i1);
				request.getSession().setAttribute("i2", i2);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("descrizione")) {
				vdao.ModifyDescrizione(id, descrizione);
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("i1", i1);
				request.getSession().setAttribute("i2", i2);
				response.sendRedirect("catalogo.jsp");
			}
			
			if(action.equals("prezzo")) {
				double prezzo = Double.parseDouble(p);
				vdao.ModifyPrezzo(id, prezzo);
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("i1", i1);
				request.getSession().setAttribute("i2", i2);
				response.sendRedirect("catalogo.jsp");
			}
			if(action.equals("plat")) {
				vdao.ModifyPiattaforma(id, plat);
				request.getSession().setAttribute("nm", nm);
				request.getSession().setAttribute("i1", i1);
				request.getSession().setAttribute("i2", i2);
				response.sendRedirect("catalogo.jsp");
			}
			if(action.equals("img")) {
				if(!(img1.startsWith("http") && img2.startsWith("http"))) {
					i1=true;
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Formato immagine non corretto.");
					response.sendRedirect("catalogo.jsp");
					return;
				}else {
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Modifica del gioco avvenuta correttamente.");
				vdao.ModifyImg12(id, img1,img2);
				response.sendRedirect("catalogo.jsp");
				}
			}
			if(action.equals("img2")) {
				if(!(img3.startsWith("http") && img4.startsWith("http") && img5.startsWith("http"))) {
					i2=true;
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Formato immagine non corretto.");
					response.sendRedirect("catalogo.jsp");
					return;
				}else {
					request.getSession().setAttribute("nm", nm);
					request.getSession().setAttribute("i1", i1);
					request.getSession().setAttribute("i2", i2);
					out.print("Modifica del gioco avvenuta correttamente.");
				vdao.ModifyImg345(id, img3,img4,img5);
				response.sendRedirect("catalogo.jsp");
			}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
