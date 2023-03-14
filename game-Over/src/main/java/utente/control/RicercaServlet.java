package utente.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RicercaServlet", value = "/RicercaServlet")
public class RicercaServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cerca = request.getParameter("cerca");
            PrintWriter out = response.getWriter();
            VideogiocoDAO vdao = new VideogiocoDAO();
            ArrayList<VideogiocoBean> games = vdao.doRetrieveAll();
            ArrayList<VideogiocoBean> listagames = new ArrayList<VideogiocoBean>();

            for(VideogiocoBean b : games) {
                if(b.getNome().toLowerCase().contains(cerca)) listagames.add(b);
            }

            request.getSession().setAttribute("lista", listagames);
            request.getSession().setAttribute("cerca", cerca);
            
            if(listagames.isEmpty()) {
            	out.print("Nessun risultato per questo videogioco.");
            	response.sendRedirect("research.jsp");
            }else {
            	out.print("Ricerca andata a buon fine.");
            	response.sendRedirect("research.jsp");	
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
