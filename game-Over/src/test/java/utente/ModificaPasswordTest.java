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
import utente.control.ModificaInfoServlet;

public class ModificaPasswordTest {

	  private static ModificaInfoServlet servlet = new ModificaInfoServlet();
	  private static HttpServletRequest request ;
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
    public void modificaConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   	String action ="password";
 	   	String id = "manuelito";
 	   	String old="Manuelsica1.";
    	String password="Manuel1.";
    	String conferma="Manuel1.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("old")).thenReturn(old);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(request.getParameter("new1")).thenReturn(password);
        Mockito.when(request.getParameter("new2")).thenReturn(conferma);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica della password avvenuta correttamente.", argument.getValue());
  	   

		
    }
   
    @Test
    public void passwordNonValida() throws SQLException, ServletException, IOException, ParseException{
    	String action ="password";
    	String id ="manuelito";
    	String old="Manuel1.";
    	String password="Manuel1";
    	String conferma="Manuel1.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("old")).thenReturn(old);
        Mockito.when(request.getParameter("new1")).thenReturn(password);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(request.getParameter("new2")).thenReturn(conferma);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password non valida.", argument.getValue());
        
    }

    @Test
    public void passwordNonUguali() throws SQLException, ServletException, IOException, ParseException{
    	String action ="password";
    	String old="Manuel1.";
    	String id = "manuelito";
    	String password="Manuel2.";
    	String conferma="Manuel";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("old")).thenReturn(old);
        Mockito.when(request.getParameter("new1")).thenReturn(password);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(request.getParameter("new2")).thenReturn(conferma);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password non coincidono.", argument.getValue());
        
       
    }
    
    @Test
    public void oldNonCorrispondente() throws SQLException, ServletException, IOException, ParseException{
    	String action ="password";
    	String old="Manu111.";
    	String password="Manuel1.";
    	String conferma="Manuel1.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("old")).thenReturn(old);
        Mockito.when(request.getParameter("new1")).thenReturn(password);
        Mockito.when(request.getParameter("new2")).thenReturn(conferma);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password attuale errata.", argument.getValue());
        
       
    }
     }


