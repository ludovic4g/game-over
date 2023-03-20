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
            boolean nm = false;
            boolean cn = false;
            boolean m1 = false;
            boolean m2 = false;
            boolean u = false;
          
            boolean p1 = false;
            boolean p2 = false;
            boolean rs = false;
           
            if(udao.doRetrieveByKey(username)==null && username!= null) {
            	utente.setUsername(username);
            	u=false;
            }
            else if(udao.doRetrieveByKey(username).getUsername()!=null) {
            	u=true;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	out.print("Username esistente.");
            	response.sendRedirect("register.jsp");
            	return;
            	
            }
            

            if(nome==null || !utente.isValid(nome)) {
            	out.print("Nome non valido.");
            	nm=true;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setNome(nome);
            	nm=false;
            }
           
            if(cognome==null || !utente.isValid(cognome)) {
            	cn=true;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	out.print("Cognome non valido.");
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setCognome(cognome);
            	cn=false;
            }
        	
            if(udao.doRetrieveByMail(mail)==null){
            if(utente.mailIsValid(mail)) {
            	utente.setEmail(mail);
            	m1=false;
            	m2=false;
            }
            }
            
            else if(udao.doRetrieveByMail(mail).getEmail()!=null){
            	out.print("Mail esistente.");
            	m1=true;
            	m2=false;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	response.sendRedirect("register.jsp");
            	return;
            }
            else if(!(mail.contains("@") && mail.contains("."))){
            	out.print("Mail non valida.");
            	m2=true;
            	m1=false;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	response.sendRedirect("register.jsp");
            	return;
            }
            
         
            	 utente.setSex(sesso);
      
           
            utente.setBday(ddn);
            if(utente.passControl(pass1)) {
            	if(utente.passConferma(pass1, pass2)) {
            		utente.setPassword(pass1);
            	}else {
            		out.print("Password non coincidono.");
            		p1=true;
            		p2=false;
            		request.getSession().setAttribute("u", u);
                	request.getSession().setAttribute("nm", nm);
                	request.getSession().setAttribute("cn", cn);
                	request.getSession().setAttribute("m1", m1);
                	request.getSession().setAttribute("m2", m2);
                	request.getSession().setAttribute("p1", p1);
                	request.getSession().setAttribute("p2", p2);
                	request.getSession().setAttribute("rs", rs);
                	response.sendRedirect("register.jsp");
                	return;
            	}
            }else {
            	out.print("Password non valida.");
            	p2=true;
            	p1=false;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	response.sendRedirect("register.jsp");
            	return;
            }
            
            
            if(risposta==null || risposta.equals("")) {
            	out.print("Risposta non valida.");
            	rs=true;
            	request.getSession().setAttribute("u", u);
            	request.getSession().setAttribute("nm", nm);
            	request.getSession().setAttribute("cn", cn);
            	request.getSession().setAttribute("m1", m1);
            	request.getSession().setAttribute("m2", m2);
            	request.getSession().setAttribute("p1", p1);
            	request.getSession().setAttribute("p2", p2);
            	request.getSession().setAttribute("rs", rs);
            	response.sendRedirect("register.jsp");
            	return;
            }else {
            	utente.setRisposta(risposta);
            	
            }
            
            utente.setGestoreCatalogo(false);
            utente.setGestorePrenotazioni(false);
            utente.setGestoreOrdini(false);
            
            udao.doSave(utente);
            request.getSession().setAttribute("u", u);
        	request.getSession().setAttribute("nm", nm);
        	request.getSession().setAttribute("cn", cn);
        	request.getSession().setAttribute("m1", m1);
        	request.getSession().setAttribute("m2", m2);
        	request.getSession().setAttribute("p1", p1);
        	request.getSession().setAttribute("p2", p2);
        	request.getSession().setAttribute("rs", rs);
            out.print("Registrazione effettuata con successo.");
            response.sendRedirect("login.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
