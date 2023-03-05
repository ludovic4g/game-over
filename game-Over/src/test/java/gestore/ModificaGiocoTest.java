package gestore;

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

import gestorecatalogo.control.ModificaGiocoServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ModificaGiocoTest {

	  private static ModificaGiocoServlet servlet = new ModificaGiocoServlet();
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
    public void modifica1ConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Minecraft!";
 	   String id = "7";
 	   String action="nome";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("nome")).thenReturn(nome);
       Mockito.when(request.getParameter("id")).thenReturn(id);
       Mockito.when(request.getParameter("action")).thenReturn(action);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del gioco avvenuta correttamente.", argument.getValue());		
    }
     

    @Test
    public void nomeNO() throws SQLException, ServletException, IOException, ParseException{
    	String nome="Minecraft";
    	String id = "7";
  	   String action="nome";
         
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
        Mockito.when(request.getParameter("nome")).thenReturn(nome);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(response.getWriter()).thenReturn(out);
         
        servlet.doPost(request, response);

      	
   	   Mockito.verify(out).print(argument.capture());
   	   assertEquals("Nome già esistente.", argument.getValue());	
    }
    

    @Test
    public void modifica2ConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   String img1="https://immagineififa24_1.jpg";
 	  String id = "7";
 	   String img2="https://immagineififa24_2.jpg";
 	   String action="img1";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
 	  Mockito.when(request.getParameter("action")).thenReturn(action);
 	 Mockito.when(request.getParameter("id")).thenReturn(id); 
 	  Mockito.when(request.getParameter("img1")).thenReturn(img1);
       Mockito.when(request.getParameter("img2")).thenReturn(img2);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del gioco avvenuta correttamente.", argument.getValue());		
    }
    

    @Test
    public void imgNO() throws SQLException, ServletException, IOException, ParseException{
    	 String img1="fifa24_1.jpg";
   	   String img2="https://immagineififa24_2.jpg";
   	String id = "7";
   	   String action="img1";
          
         PrintWriter out = Mockito.mock(PrintWriter.class);
   	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
         
   	  Mockito.when(request.getParameter("action")).thenReturn(action);
   	Mockito.when(request.getParameter("id")).thenReturn(id);   
   	  Mockito.when(request.getParameter("img1")).thenReturn(img1);
         Mockito.when(request.getParameter("img2")).thenReturn(img2);
         Mockito.when(response.getWriter()).thenReturn(out);
          
         servlet.doPost(request, response);

       	
    	   Mockito.verify(out).print(argument.capture());
    	   assertEquals("Formato immagine non corretto.", argument.getValue());			
    }
    
    @Test
    public void modifica3ConSuccesso() throws SQLException, ServletException, IOException, ParseException{
 	   String img3="https://immagineififa24_1.jpg";
 	   String img4="https://immagineififa24_2.jpg";
 	  String img5="https://immagineififa24_2.jpg";
 	 String id = "7";
 	   String action="img2";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
 	  Mockito.when(request.getParameter("action")).thenReturn(action);
 	 Mockito.when(request.getParameter("id")).thenReturn(id);
 	  Mockito.when(request.getParameter("img3")).thenReturn(img3);
       Mockito.when(request.getParameter("img4")).thenReturn(img4);
       Mockito.when(request.getParameter("img5")).thenReturn(img5);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Modifica del gioco avvenuta correttamente.", argument.getValue());		
    }
    

    @Test
    public void img2NO() throws SQLException, ServletException, IOException, ParseException{
    	String img3="https://immagineififa24_1.jpg";
  	   String img4="https://immagineififa24_2.jpg";
  	 String id = "7";
  	  String img5="immagineififa24_2.jpg";
  	   String action="img2";
         
        PrintWriter out = Mockito.mock(PrintWriter.class);
  	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        
  	  Mockito.when(request.getParameter("action")).thenReturn(action);
        Mockito.when(request.getParameter("img3")).thenReturn(img3);
        Mockito.when(request.getParameter("id")).thenReturn(id);
        Mockito.when(request.getParameter("img4")).thenReturn(img4);
        Mockito.when(request.getParameter("img5")).thenReturn(img5);
        Mockito.when(response.getWriter()).thenReturn(out);
         
        servlet.doPost(request, response);

      	
   	   Mockito.verify(out).print(argument.capture());
   	   assertEquals("Formato immagine non corretto.", argument.getValue());			
    }
}


