package utente;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utente.control.RecoveryPasswordServlet;

public class RecoveryPassTest {

	  private static RecoveryPasswordServlet servlet = new RecoveryPasswordServlet();
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
    public void recupero1ConSuccesso() throws SQLException, ServletException, IOException, ParseException{
    	String email ="manuel@gmail.com";
    	String risposta="Benevento";
    	String action="first";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("mail")).thenReturn(email);
       Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Identificazione avvenuta correttamente.", argument.getValue());		
    }
    
    @Test
    public void recupero1mailNO() throws SQLException, ServletException, IOException, ParseException{
    	String email ="manuelll@gmail.com";
    	String risposta="Benevento";
    	String action="first";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("mail")).thenReturn(email);
       Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Mail non esistente.", argument.getValue());		
    }
    
    @Test
    public void recupero1rispostaNO() throws SQLException, ServletException, IOException, ParseException{
    	String email ="manuel@gmail.com";
    	String risposta="Baronissi";
    	String action="first";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("mail")).thenReturn(email);
       Mockito.when(request.getParameter("risposta")).thenReturn(risposta);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Risposta non corrispondente.", argument.getValue());		
    }
    
    @Test
    public void recupero2ConSuccesso() throws SQLException, ServletException, IOException, ParseException{
    	String id ="manuelito";
    	String new1="Manuel2.";
    	String new2="Manuel2.";
    	String action="field";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("id")).thenReturn(id);
       Mockito.when(request.getParameter("pass1")).thenReturn(new1);
       Mockito.when(request.getParameter("pass2")).thenReturn(new2);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Recupero della password avvenuto correttamente.", argument.getValue());		
    }
    
    @Test
    public void recupero2pass1NO() throws SQLException, ServletException, IOException, ParseException{
    	String id ="manuelito";
    	String new1="Manuel.";
    	String new2="Manuel2.";
    	String action="field";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("id")).thenReturn(id);
       Mockito.when(request.getParameter("pass1")).thenReturn(new1);
       Mockito.when(request.getParameter("pass2")).thenReturn(new2);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password non valida.", argument.getValue());		
    }
    
    @Test
    public void recupero2pass2NO() throws SQLException, ServletException, IOException, ParseException{
    	String id ="manuelito";
    	String new1="Manuel2.";
    	String new2="Manuel2";
    	String action="field";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(request.getParameter("id")).thenReturn(id);
       Mockito.when(request.getParameter("pass1")).thenReturn(new1);
       Mockito.when(request.getParameter("pass2")).thenReturn(new2);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password non coincidono.", argument.getValue());		
    }
        }


