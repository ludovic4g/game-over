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
import utente.control.LoginServlet;

public class LoginServletTest {

	  private static LoginServlet servlet = new LoginServlet();
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
    public void loginConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   
    	String username="manuelito";
    	String password="Manuelsica1.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Login effettuato con successo.", argument.getValue());
  	   

		
    }
   
    @Test
    public void passwordNonValida() throws SQLException, ServletException, IOException, ParseException{
    	String username="manuelito";
    	String password="Manuel.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Password non valida.", argument.getValue());
        
    }

    @Test
    public void usernameNonValido() throws SQLException, ServletException, IOException, ParseException{
    	String username="manueeee";
    	String password="ManuelSica1.";
        
        PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("username")).thenReturn(username);
        Mockito.when(request.getParameter("password")).thenReturn(password);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Username non valido.", argument.getValue());
        
       
    }
     }


