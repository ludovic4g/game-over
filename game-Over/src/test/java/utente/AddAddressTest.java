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
import utente.control.AddAddressServlet;

public class AddAddressTest {

	  private static AddAddressServlet servlet = new AddAddressServlet();
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
    public void aggiuntaConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sica";
 	   String indirizzo="Via Umberto I";
 	   String cap = "84099";
 	   String citta="Salerno";
 	   String provincia ="SA";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Aggiunta indirizzo avvenuta correttamente.", argument.getValue());		
    }
    
    @Test
    public void nomeNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sic4";
 	   String indirizzo="Via Umberto I";
 	   String cap = "84099";
 	   String citta="Salerno";
 	   String provincia ="SA";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Nome non valido.", argument.getValue());		
    }
    
    @Test
    public void viaNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sica";
 	   String indirizzo="Via Umberto I.";
 	   String cap = "84099";
 	   String citta="Salerno";
 	   String provincia ="SA";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Indirizzo non valido.", argument.getValue());		
    }
   
    @Test
    public void capNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sica";
 	   String indirizzo="Via Umberto I";
 	   String cap = "84o99";
 	   String citta="Salerno";
 	   String provincia ="SA";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("CAP non valido.", argument.getValue());		
    }
   
    @Test
    public void cittaNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sica";
 	   String indirizzo="Via Umberto I";
 	   String cap = "84099";
 	   String citta="";
 	   String provincia ="SA";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Citta' non valida.", argument.getValue());		
    }
    
    @Test
    public void provinciaNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Manuel Sica";
 	   String indirizzo="Via Umberto I";
 	   String cap = "84099";
 	   String citta="Salerno";
 	   String provincia ="salerno";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("indirizzo")).thenReturn(indirizzo);
       Mockito.when(request.getParameter("cap")).thenReturn(cap);
       Mockito.when(request.getParameter("citta")).thenReturn(citta);
       Mockito.when(request.getParameter("provincia")).thenReturn(provincia);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Provincia non valida.", argument.getValue());		
    }
        }


