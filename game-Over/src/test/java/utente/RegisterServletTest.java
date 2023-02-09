package utente;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utente.control.RegisterServlet;
import utente.model.UtenteDAO;

public class RegisterServletTest {
	private static HttpServletRequest request;
 	private static HttpServletResponse response;
 	private static HttpSession session;
    private static UtenteDAO udao;
    private static RegisterServlet rec;
    

    @BeforeAll
    public static void init() {
    	request = Mockito.mock(HttpServletRequest.class) ;
		response = Mockito.mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		Mockito.when(request.getSession()).thenReturn(session);
		rec = Mockito.spy(new RegisterServlet());
		Mockito.when(rec.getServletConfig()).thenReturn(Mockito.mock(ServletConfig.class));
		ServletContext context = Mockito.mock(ServletContext.class); 
		Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(Mockito.mock(RequestDispatcher.class));
		Mockito.when(rec.getServletContext()).thenReturn(context);
       // eventoDAO = Mockito.mock(EventoDAOImpl.class);
       // infoCitta = Mockito.mock(InfoCittaImpl.class);
       // eventoLogic = new EventoLogicImpl(eventoDAO,infoCitta);
    	
    	
    }

    @Test
    public void registrazioneConSuccesso() throws SQLException, ServletException, IOException, ParseException{
    	String un= "mmmanyu";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
  
        
        Mockito.when(request.getParameter("username")).thenReturn(un);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
		
        /*
		Mockito.verify(request, Mockito.never()).setAttribute("errorUsername", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("existUsername", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorPassword", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("notEquals", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorNome", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorCognome", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorMail", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("existMail", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorDate", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorSex", "true");
		Mockito.verify(request, Mockito.never()).setAttribute("errorRisposta", "true");
			
		//Mockito.verify(response).sendRedirect(("login.jsp"));
		  */
		
    }
  
   
    @Test
    public void usernameEsistente() throws SQLException, ServletException, IOException, ParseException{
    	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
        
    }
    

    @Test
    public void usernameNonValido() throws SQLException, ServletException, IOException, ParseException{
    	String username= null;
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
    }
  
    @Test
    public void nomeNonValido() throws SQLException, ServletException, IOException, ParseException{
    	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel1";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
        
    }
    public void cognomeNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password2="mmmManue1.";
    	String password="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
      
    }
    public void ddnNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "20-09-05";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
       
    }
  
    public void genereNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
        
    }
   
    public void mailNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuelgmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
     		
    }
    
    public void mailEsistente() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        
        rec.doPost(request,response);
       
    }

    public void passwordNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue.";
    	String password2="mmmManue.";
    	String email= "manuel@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        Mockito.when(request.getParameter("domanda")).thenReturn(domanda);
        
        rec.doPost(request,response);

    }
   
    public void passwordNotEquals() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue2.";
    	String email= "manuel@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        Mockito.when(request.getParameter("domanda")).thenReturn(domanda);
        
        rec.doPost(request,response);
    }
    
    public void rispostaNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manuelito";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica.";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "";
        String domanda ="Città preferita";
        
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        Mockito.when(request.getParameter("domanda")).thenReturn(domanda);
        
        rec.doPost(request,response);
    }
    
   }


