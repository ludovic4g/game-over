package utente.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utente.model.UtenteBean;
import utente.model.UtenteDAO;

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
            PrintWriter out=response.getWriter();
           
            if(udao.doRetrieveByKey(username)==null && username!= null)
            	utente.setUsername(username);
            else if(udao.doRetrieveByKey(username).getUsername()!=null) {
            	out.print("Username esistente.");
            	response.sendRedirect("register.jsp");
            	return;
            	
            }else if(username.equals("") || username==null) {
            	out.print("Username non valido.");
            	response.sendRedirect("register.jsp");
            	return;
            }
            

            if(nome==null || !utente.isValid(nome)) {
            	out.print("Nome non valido.");
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setNome(nome);
            }
           
            if(cognome==null || !utente.isValid(cognome)) {
            	out.print("Cognome non valido.");
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setCognome(cognome);
            }
        	
            if(udao.doRetrieveByMail(mail)==null){
            if(utente.mailIsValid(mail)) {
            	utente.setEmail(mail);
            }
            }
            
            else if(udao.doRetrieveByMail(mail).getEmail()!=null){
            	out.print("Mail esistente.");
            	response.sendRedirect("register.jsp");
            	return;
            }
            else if(!(mail.contains("@") && mail.contains("."))){
            	out.print("Mail non valida.");
            	response.sendRedirect("register.jsp");
            	return;
            }
            
            if(sesso.equals("")) {
            	out.print("Genere non valido.");
            	response.sendRedirect("register.jsp");
            	return;   	
            }else {
            	 utente.setSex(sesso);
            }
           
            utente.setBday(ddn);
            if(utente.passControl(pass1)) {
            	if(utente.passConferma(pass1, pass2)) {
            		utente.setPassword(pass1);
            	}else {
            		out.print("Password non coincidono.");
                	response.sendRedirect("register.jsp");
                	return;
            	}
            }else {
            	out.print("Password non valida.");
            	response.sendRedirect("register.jsp");
            	return;
            }
            
            
            if(risposta==null) {
            	out.print("Risposta non valida.");
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setRisposta(risposta);
            	
            }
            
            utente.setGestoreCatalogo(false);
            utente.setGestorePrenotazioni(false);
            utente.setGestoreOrdini(false);
            
            udao.doSave(utente);
            out.print("Registrazione effettuata con successo.");
            response.sendRedirect("login.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
