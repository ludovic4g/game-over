package utente.control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        UtenteDAO udao= new UtenteDAO();
        UtenteBean utente = new UtenteBean();
        PrintWriter out = response.getWriter();
        boolean un = false;
        boolean pw=false;
        
        if(udao.doRetrieveByKey(username).getUsername()==null) {
        	un=true;
        	request.getSession().setAttribute("un", un);
        	request.getSession().setAttribute("pw", pw);
        	 response.sendRedirect("login.jsp");
        	 return;
        }
        
        utente= udao.login(username,password);

        if(utente==null){
        	pw=true;
        	request.getSession().setAttribute("un", un);
        	request.getSession().setAttribute("pw", pw);
        	out.print("Password non valida.");
            response.sendRedirect("login.jsp");
            return;
        }

        request.getSession().setAttribute("auth", utente);
        if(utente.isGestoreCatalogo() || utente.isGestoreOrdini() || utente.isGestorePrenotazioni()) response.sendRedirect("dashboard_admin.jsp");
        else {
        	request.getSession().setAttribute("un", un);
        	request.getSession().setAttribute("pw", pw);
        	out.print("Login effettuato con successo.");
        	response.sendRedirect("index.jsp");
        }
        
        }catch(Exception e) {
        	e.printStackTrace();
        }

    }
}
