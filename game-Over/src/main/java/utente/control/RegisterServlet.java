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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            UtenteBean utente = new UtenteBean();
            UtenteDAO udao = new UtenteDAO();
           
            if(udao.doRetrieveByKey(username)==null)
            	utente.setUsername(username);
            if(udao.doRetrieveByKey(username)!=null) {
            	request.setAttribute("existUsername", "true");
            	response.sendRedirect("register.jsp");
            	return;
            	
            }if(username.equals("")) {
            	request.setAttribute("errorUsername", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
            

            if(nome.equals("")) {
            	 utente.setNome(nome);
            }else {
            	request.setAttribute("errorNome", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
           
            if(cognome.equals("")) {
            	utente.setCognome(cognome);
            }else {
            	request.setAttribute("errorCognome", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
        	
            if(utente.mailIsValid(mail)) {
            	utente.setEmail(mail);
            }else {
            	request.setAttribute("errorMail", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
            
            if(sesso.equals("")) {
            	 utente.setSex(sesso);
            }else {
            	request.setAttribute("errorSex", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
           
            utente.setBday(ddn);
            if(utente.passControl(pass1)) {
            	if(utente.passConferma(pass1, pass2)) {
            		utente.setPassword(pass1);
            	}else {
            		request.setAttribute("notEquals", "true");
                	response.sendRedirect("register.jsp");
                	return;
            	}
            }else{
            	request.setAttribute("errorPassword", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
            if(risposta.equals("")) {
            	utente.setRisposta(risposta);
            }else {
            	request.setAttribute("errorRisposta", "true");
            	response.sendRedirect("register.jsp");
            	return;
            }
            
            utente.setGestoreCatalogo(false);
            utente.setGestorePrenotazioni(false);
            utente.setGestoreOrdini(false);
            
            udao.doSave(utente);
            response.sendRedirect("login.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
