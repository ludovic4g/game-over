package utente.control;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RicercaServlet", value = "/RicercaServlet")
public class RicercaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cerca = request.getParameter("cerca");

            VideogiocoDAO vdao = new VideogiocoDAO();
            ArrayList<VideogiocoBean> games = vdao.doRetrieveAll();
            ArrayList<VideogiocoBean> listagames = new ArrayList<VideogiocoBean>();

            for(VideogiocoBean b : games) {
                if(b.getNome().toLowerCase().contains(cerca)) listagames.add(b);
            }

            request.getSession().setAttribute("lista", listagames);
            request.getSession().setAttribute("cerca", cerca);

            response.sendRedirect("research.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
