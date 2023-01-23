package utente.control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String username = request.getParameter("username");
            String mail = request.getParameter("mail");
            String sesso = request.getParameter("sesso");
            String b = request.getParameter("ddn");
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date ddn = f.parse(b);
            String pass1 = request.getParameter("pass1");
            String pass2= request.getParameter("pass2");
            String risposta = request.getParameter("risposta");
            String domanda = request.getParameter("domanda");
            UtenteBean utente = new UtenteBean();


            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setUsername(username);
            utente.setEmail(mail);
            utente.setSex(sesso);
            utente.setBday(ddn);
            utente.setPassword(pass1);
            utente.setRisposta(risposta);
            utente.setDomanda(domanda);
            utente.setGestoreCatalogo(false);
            utente.setGestorePrenotazioni(false);
            utente.setGestoreOrdini(false);

            UtenteDAO udao = new UtenteDAO();
            udao.saveDomanda(domanda);
            udao.doSave(utente);
            response.sendRedirect("login.jsp");
               
          



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
