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

import gestorecatalogo.control.AggiungiGiocoServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AggiuntaGiocoTest {

	  private static AggiungiGiocoServlet servlet = new AggiungiGiocoServlet();
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
 	   String nome="Genshin Impact";
 	   String prezzo="59.99";
 	   String anno="2023";
 	   String magazzino="30";
 	   String piattaforma="S5";
 	   String descrizione="Gioca nel vasto mondo fantasy di Teyvat, inizia la tua avventura alla ricerca di tua sorella...";
 	   String img1="https://immaginegi_1.jpg";
 	   String img2="https://immaginegi_2.jpg";
 	   String img3="https://immaginegi_3.jpg";
 	   String img4="https://immaginegi_4.jpg";
 	   String img5="https://immaginegi_5.jpg";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("name")).thenReturn(nome);
       Mockito.when(request.getParameter("prezzo")).thenReturn(prezzo);
       Mockito.when(request.getParameter("anno")).thenReturn(anno);
       Mockito.when(request.getParameter("quantita")).thenReturn(magazzino);
       Mockito.when(request.getParameter("piattaforma")).thenReturn(piattaforma);
       Mockito.when(request.getParameter("descrizione")).thenReturn(descrizione);
       Mockito.when(request.getParameter("img1")).thenReturn(img1);
       Mockito.when(request.getParameter("img2")).thenReturn(img2);
       Mockito.when(request.getParameter("img3")).thenReturn(img3);
       Mockito.when(request.getParameter("img4")).thenReturn(img4);
       Mockito.when(request.getParameter("img5")).thenReturn(img5);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Aggiunta del gioco avvenuta correttamente.", argument.getValue());		
    }
    
    @Test
    public void nomeNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Minecraft";
 	   String prezzo="59.99";
 	   String anno="2023";
 	   String magazzino="30";
 	   String piattaforma="Nintendo Switch";
 	   String descrizione="Il nuovo Minecraft e' arrivato e include tutti gli ultimi aggiornamenti come Update Aquatic, "
 	   		+ "il supporto al gioco cross-player e l'accesso a una moltitudine di contenuti del Minecraft Marketplace.";
 	   String img1="https://immagineminecraft_1.jpg";
 	   String img2="https://immaginemincraft_2.jpg";
 	   String img3="https://immagineminecraft_3.jpg";
 	   String img4="https://immagineminecraft_4.jpg";
 	   String img5="https://immagineminecraft_5.jpg";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("name")).thenReturn(nome);
       Mockito.when(request.getParameter("prezzo")).thenReturn(prezzo);
       Mockito.when(request.getParameter("anno")).thenReturn(anno);
       Mockito.when(request.getParameter("quantita")).thenReturn(magazzino);
       Mockito.when(request.getParameter("piattaforma")).thenReturn(piattaforma);
       Mockito.when(request.getParameter("descrizione")).thenReturn(descrizione);
       Mockito.when(request.getParameter("img1")).thenReturn(img1);
       Mockito.when(request.getParameter("img2")).thenReturn(img2);
       Mockito.when(request.getParameter("img3")).thenReturn(img3);
       Mockito.when(request.getParameter("img4")).thenReturn(img4);
       Mockito.when(request.getParameter("img5")).thenReturn(img5);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Nome del gioco già esistente.", argument.getValue());		
    }
   
    @Test
    public void magazzinoNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Genshin Impact";
 	   String prezzo="59.99";
 	   String anno="2023";
 	   String magazzino="0";
 	   String piattaforma="PS4,PS5";
 	   String descrizione="FIFA 24 include divise club e rose originali dei principati campionati del mondo...";
 	   String img1="https://immaginefifa24_1.jpg";
 	   String img2="https://immaginefifa24_2.jpg";
 	   String img3="https://immaginefifa24_3.jpg";
 	   String img4="https://immaginefifa24_4.jpg";
 	   String img5="https://immaginefifa24_5.jpg";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("name")).thenReturn(nome);
       Mockito.when(request.getParameter("prezzo")).thenReturn(prezzo);
       Mockito.when(request.getParameter("anno")).thenReturn(anno);
       Mockito.when(request.getParameter("quantita")).thenReturn(magazzino);
       Mockito.when(request.getParameter("piattaforma")).thenReturn(piattaforma);
       Mockito.when(request.getParameter("descrizione")).thenReturn(descrizione);
       Mockito.when(request.getParameter("img1")).thenReturn(img1);
       Mockito.when(request.getParameter("img2")).thenReturn(img2);
       Mockito.when(request.getParameter("img3")).thenReturn(img3);
       Mockito.when(request.getParameter("img4")).thenReturn(img4);
       Mockito.when(request.getParameter("img5")).thenReturn(img5);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Aumentare la quantità di prodotto nel magazzino.", argument.getValue());		
    }
    
    @Test
    public void immaginiNO() throws SQLException, ServletException, IOException, ParseException{
 	   String nome="Genshin Impact";
 	   String prezzo="59.99";
 	   String anno="2023";
 	   String magazzino="40";
 	   String piattaforma="PS4,PS5";
 	   String descrizione="FIFA 24 include divise club e rose originali dei principati campionati del mondo...";
 	   String img1="fifa24_1.jpg";
 	   String img2="fifa24_2.jpg";
 	   String img3="fifa24_3.jpg";
 	   String img4="fifa24_4.jpg";
 	   String img5="fifa24_5.jpg";
        
       PrintWriter out = Mockito.mock(PrintWriter.class);
 	   ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
       
       Mockito.when(request.getParameter("name")).thenReturn(nome);
       Mockito.when(request.getParameter("prezzo")).thenReturn(prezzo);
       Mockito.when(request.getParameter("anno")).thenReturn(anno);
       Mockito.when(request.getParameter("quantita")).thenReturn(magazzino);
       Mockito.when(request.getParameter("piattaforma")).thenReturn(piattaforma);
       Mockito.when(request.getParameter("descrizione")).thenReturn(descrizione);
       Mockito.when(request.getParameter("img1")).thenReturn(img1);
       Mockito.when(request.getParameter("img2")).thenReturn(img2);
       Mockito.when(request.getParameter("img3")).thenReturn(img3);
       Mockito.when(request.getParameter("img4")).thenReturn(img4);
       Mockito.when(request.getParameter("img5")).thenReturn(img5);
       Mockito.when(response.getWriter()).thenReturn(out);
        
       servlet.doPost(request, response);

     	
  	   Mockito.verify(out).print(argument.capture());
  	   assertEquals("Formato immagine non supportato.", argument.getValue());		
    }
        }


