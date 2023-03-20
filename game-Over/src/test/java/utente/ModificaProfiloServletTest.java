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

public class ModificaProfiloServletTest {

	  private static ModificaInfoServlet servlet = new ModificaInfoServlet();
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
    public void modificaNomeSI() throws SQLException, ServletException, IOException, ParseException{
    	String action= "nome";
    	String nome="Benedetta";
    	String id ="honejmoon";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del profilo avvenuta correttamente.", argument.getValue());
    }
   
    @Test
    public void modificaNomeNO() throws SQLException, ServletException, IOException, ParseException{
    	String action= "nome";
    	String id="honejmoon";
    	String nome="Benedett4";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Nome non valido.", argument.getValue());
    }
    
    @Test
    public void modificaCognomeSI() throws SQLException, ServletException, IOException, ParseException{
    	String action= "cognome";
    	String id="honejmoon";
    	String nome="Rossetti";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("cognome")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del profilo avvenuta correttamente.", argument.getValue());
    }
    
    @Test
    public void modificaCognomeNO() throws SQLException, ServletException, IOException, ParseException{
    	String action= "cognome";
    	String id="honejmoon";
    	String nome="R0ssetti";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("cognome")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Cognome non valido.", argument.getValue());
    }
   
    @Test
    public void modificaMailSI() throws SQLException, ServletException, IOException, ParseException{
    	String action= "mail";
    	String id="honejmoon";
    	String nome="benedetta1@gmail.com";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("mail")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del profilo avvenuta correttamente.", argument.getValue());
    }
    
    @Test
    public void modificaMailNO() throws SQLException, ServletException, IOException, ParseException{
    	String action= "mail";
    	String id="honejmoon";
    	String nome="benedetta.com";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("mail")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Mail non valida.", argument.getValue());
    }
    
    @Test
    public void modificaMailEsistente() throws SQLException, ServletException, IOException, ParseException{
    	String action= "mail";
    	String id="honejmoon";
    	String nome="manuel@gmail.com";
    	PrintWriter out = Mockito.mock(PrintWriter.class);
    	ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("mail")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(response.getWriter()).thenReturn(out);
        
        servlet.doPost(request, response);
     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Mail già esistente.", argument.getValue());
    }
       
    
    
   }


