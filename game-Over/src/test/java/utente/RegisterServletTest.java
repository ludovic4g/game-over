package utente;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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

	  private static RegisterServlet servlet = new RegisterServlet();
	  private static  HttpServletRequest request ;
	  private static HttpServletResponse response ;
	  private static HttpSession session;
	  
	  @BeforeEach
	    void setUp() throws Exception {
	    	request = Mockito.mock(HttpServletRequest.class) ;
			response = Mockito.mock(HttpServletResponse.class);
			session = mock(HttpSession.class);
			Mockito.when(request.getSession()).thenReturn(session);
			ServletContext context = Mockito.mock(ServletContext.class); 
			Mockito.when(context.getRequestDispatcher(response.encodeURL(""))).thenReturn(Mockito.mock(RequestDispatcher.class));
	    }
	
	  @AfterEach
	    void tearDown() throws Exception {
	        request=null;
	        response=null;
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
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("username")).thenReturn(un);
        Mockito.when(request.getParameter("pass1")).thenReturn(password);
        Mockito.when(request.getParameter("pass2")).thenReturn(password2);
        Mockito.when(request.getParameter("mail")).thenReturn(email);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
        Mockito.when(request.getParameter("ddn")).thenReturn(d);
        Mockito.when(request.getParameter("sesso")).thenReturn(sex);
        Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Registrazione effettuata con successo.", argument.getValue());
  	   

		
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
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Username esistente.", argument.getValue());
        
    }

    @Test
    public void usernameNonValido() throws SQLException, ServletException, IOException, ParseException{
    	String username="";
    	String password="Manuel1.";
    	String password2="Manuel1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Username non valido.", argument.getValue());
        
       
    }
  
    @Test
    public void nomeNonValido() throws SQLException, ServletException, IOException, ParseException{
    	String username= "manueeee";
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
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Nome non valido.", argument.getValue());
        
    }
    @Test
    public void cognomeNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueee";
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
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Cognome non valido.", argument.getValue());
      
    }
   
  @Test
    public void genereNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueeeeeeeee";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Genere non valido.", argument.getValue());
        
    }
   @Test
    public void mailNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueeee";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuelgmailcom";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Mail non valida.", argument.getValue());
     		
    }
    @Test
    public void mailEsistente() throws SQLException, ServletException, IOException, ParseException{
     	String username= "mmmmaaaaaayyyyyyyy";
    	String password="mmmManue1.";
    	String password2="mmmManue1.";
    	String email= "manuel@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Mail esistente.", argument.getValue());
       
    }
    @Test
    public void passwordNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueeeee";
    	String password="mmmManue.";
    	String password2="mmmManue.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Password non valida.", argument.getValue());

    }
   @Test
    public void passwordNotEquals() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueeee";
    	String password="mmmManue1.";
    	String password2="mmmManue2.";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= "Benevento";
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Password non coincidono.", argument.getValue());
    }
    @Test
    public void rispostaNonValido() throws SQLException, ServletException, IOException, ParseException{
     	String username= "manueeeee";
    	String password="Manuel1!";
    	String password2="Manuel1!";
    	String email= "manuel1@gmail.com";
    	String nome= "Manuel";
    	String cognome ="Sica";
    	String d = "2001-05-23";
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date ddn = f.parse(d);
        String sex = "Maschio";
        String risposta= null;
        String domanda ="Città preferita";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
         Mockito.when(request.getParameter("username")).thenReturn(username);
         Mockito.when(request.getParameter("pass1")).thenReturn(password);
         Mockito.when(request.getParameter("pass2")).thenReturn(password2);
         Mockito.when(request.getParameter("mail")).thenReturn(email);
         Mockito.when(request.getParameter("nome")).thenReturn(nome);
         Mockito.when(request.getParameter("cognome")).thenReturn(cognome);
         Mockito.when(request.getParameter("ddn")).thenReturn(d);
         Mockito.when(request.getParameter("sesso")).thenReturn(sex);
         Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
         Mockito.when(response.getWriter()).thenReturn(out);
         
         servlet.doPost(request, response);
      	
   	   	Mockito.verify(out).print(argument.capture());
   	   	assertEquals("Risposta non valida.", argument.getValue());
    }
   }


