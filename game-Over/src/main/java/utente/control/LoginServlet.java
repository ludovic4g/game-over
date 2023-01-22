package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UtenteDAO udao= new UtenteDAO();
        UtenteBean utente = new UtenteBean();

        boolean ctrl = false;
        utente= udao.login(username,password);

        if(utente==null){
            ctrl=true;
            request.getSession().setAttribute("ctrl", ctrl);
            response.sendRedirect("login.jsp");
        }

        request.getSession().setAttribute("ctrl", ctrl);
        request.getSession().setAttribute("auth", utente);
        if(utente.isGestoreCatalogo() || utente.isGestoreOrdini() || utente.isGestorePrenotazioni()) response.sendRedirect("dashboard_admin.jsp");
        else 
        	response.sendRedirect("index.jsp");


    }
}
