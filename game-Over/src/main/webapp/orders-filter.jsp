<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "gestoreordini.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        OrdineDAO odao = new OrdineDAO();
    	ArrayList<OrdineBean> o = odao.doRetrieveAllbyUsername(auth.getUsername());
        if(auth!=null)
        	request.setAttribute("ordine", o);
        RiguardaDAO rdao = new RiguardaDAO();
        ArrayList<RiguardaBean> riguarda = null;
        VideogiocoBean game=null;
        VideogiocoDAO vdao = new VideogiocoDAO();
        %>
        
  
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>GameOver|Ordini</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        </head>

        <body>
                <!--Header-->
                <header>
                        <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                                        aria-hidden="true">GameOver</span></a>
                        <ul class="nav">
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="esport.jsp">E-Sport</a></li>
                                <li><a href="shopgame.jsp">Games</a></li>
                                <li><a href="cart.jsp">Carrello</a></li>
                                <li><a href="prenotazioni.jsp">Prenotazioni</a></li>
                                <li><a href="orders.jsp">Ordini</a></li>
                                <li><a href="login.jsp">Login</a></li>
                        </ul>
                        <div class="action">
                                <div class="searchBx">
                                        <a href="#"><i class='bx bx-search'></i></a>
                                        <input type="text" placeholder="Search Games">
                                </div>
                        </div>
                        <div class="toggleMenu" onclick="toggleMenu();"></div>
                </header>
                <!--Carrello-->
                <div class="containercart">
                        <h2 class="title-page">Ordini</h2>
                        <div class="small-container cart-page">
                                <table>
                                        <tr class="column">
                                                <th>Prodotti</th>
                                                <th>Stato</th>
                                                <th>Quantità</th>
                                                <th>Data</th>
                                                <th>Prezzo</th>
                                        </tr>
                                        
                                        <%if(o!=null){
                                        	for(OrdineBean f : o){
                                        		riguarda= rdao.doRetriveByOrdine(f.getIdOrdine());
                                        		game = vdao.doRetriveByKey(riguarda.get(0).getId());
                                        	%>
                                                                              <tr>
                                                <td>
                                                        <div class="cart-info">
                                                                <img
                                                                        src=<%=game.getImg1()%>>
                                                                <div class="resume">
                                                                        <p><%=f.getListaProdotti() %></p>
                                                                        <br>
                                                                        <a class="remove" href="CancelOrderServlet?id=<%=f.getIdOrdine()%>">Annulla</a>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td class="state"><%=f.getStato() %></td>
                                                <td class="quantity"><%=f.getNumeroProdotti() %></td>
                                                <td class="platform"><%=f.getDataAcquisto() %></td>
                                                <td class="product-price">€ <%=f.getPrezzoTotale() %></td>
                                        </tr>
                                        <% }
                                        	}%>
                                        
                                </table>
                        </div>
                </div>
                <!--Footer-->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>