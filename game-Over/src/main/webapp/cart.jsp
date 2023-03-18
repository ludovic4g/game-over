
<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        ArrayList<VideogiocoBean> games =null;
        ArrayList<TavoloBean> tavoli = null;
        ArrayList<PostazioneBean> postazioni = null;
        
        if(carrello== null){
        	carrello = new Carrello();
        }
        boolean ctrl= carrello.isEmpty();
        tavoli = carrello.getTavoli();
        postazioni = carrello.getPostazioni();
        games= carrello.getGames();
        request.setAttribute("carrello", carrello);
        request.setAttribute("auth", auth);
        %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Carrello</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <!--Header-->
        <%@ include file="includes/header.jsp" %>
        <!--Carrello-->
        <div class="containercart">
            <h2 class="title-page">Carrello</h2>
            <div class="small-container cart-page">
                <table>
                <%if(!tavoli.isEmpty()){ %>
                    <tr class="column">
                        <th>Prodotti</th>
                        <th>Tipo</th>
                     
                        <th>Totale</th>
                    </tr>
                    <%for(TavoloBean v: tavoli) {
                    %>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="<%=v.getImg()%>">
                                <div class="resume">
                                    <p>Tavolo n.<%=v.getIdTavolo() %></p>
                                    <small class="single-product-price">Prezzo:<%out.println(String.format("%.2f&euro;", v.getPrezzoPosto()));%></small>
                                    <br>
                                    <small class="single-product-price">Orario:<%=v.getOra()%></small>
                                    <small class="single-product-price">N.Persone:<%=v.getNumeroPosti() %></small>
                                    <br>
                                    <a class="remove" href="RemoveFromCartServlet?action=tavolo&id=<%=v.getIdTavolo()%>">Remove</a>
                                </div>
                            </div>
                        </td>
                        <td class="platform">Gioco di <%=v.getTipo() %></td>
                        <td class="product-price"><%out.println(String.format("%.2f&euro;", v.getPrezzoPosto()*v.getNumeroPosti()));%></td>
                    </tr>
                    <%}
                    }%>
                    <%if(!postazioni.isEmpty()) { %>
                    <tr class="column">
                        <th>Prodotti</th>
                        <th>Tipo</th>
                        
                        <th>Totale</th>
                    </tr>
                    <%
                    for(PostazioneBean v: postazioni) {
                    %>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="<%=v.getImg()%>">
                                <div class="resume">
                                    <p>Postazione n.<%=v.getIdPostazione() %></p>
                                    <small class="single-product-price">Prezzo:<%out.println(String.format("%.2f&euro;", v.getPrezzo()));%></small>
                                    <br>
                                    <small class="single-product-price">Orario:<%=v.getOra() %></small>
                                    <br>
                                    <a class="remove" href="RemoveFromCartServlet?action=postazione&id=<%=v.getIdPostazione()%>">Remove</a>
                                </div>
                            </div>
                        </td>
                        <td class="platform"><%=v.getTipo() %></td>
                        <td class="product-price"><%out.println(String.format("%.2f&euro;", v.getPrezzo()));%></td>
                    </tr>
                    <%}
                    }%>
                    <%if(!games.isEmpty()) { %>
                    <tr class="column">
                        <th>Prodotti</th>
                        <th>Quantità</th>
                        <th>Piattaforma</th>
                        <th>Totale</th>
                    </tr>
                    <%
                    for(VideogiocoBean v: games) {
                    %>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src=<%=v.getImg1() %>>
                                <div class="resume">
                                    <p><%=v.getNome() %></p>
                                    <small class="single-product-price">Prezzo:<%out.println(String.format("%.2f&euro;", v.getPrezzo()));%></small>
                                    <br>
                                    <a class="remove" href="RemoveFromCartServlet?action=game&id=<%=v.getId()%>">Remove</a>
                                </div>
                            </div>
                        </td>
                        <td><input type="number" min="1" value="<%=v.getQuantita() %>"></td>
                        <td class="platform"><%=v.getTipo() %></td>
                        <td class="product-price">$<%out.println(String.format("%.2f&euro;", v.getPrezzo()* v.getQuantita()));%></td>
                    </tr>
                    <% }
                    }
                    %>
                   </table>

                <div class="total-price">

                    <table>
                        <tr>
                            <td class="subtitle">Subtotal</td>
                            <td class="total-product-price"><%if(!ctrl){
                        out.println(String.format("%.2f&euro;", carrello.getTotal()));
                        }else{
                        	out.println("0.00");
                        }
                        %></td>
                        </tr>
                        <tr>
                            <td class="subtitle">Tax</td>
                            <td class="total-product-price">22%</td>
                        </tr>
                        <tr>
                            <td class="subtitle">Total</td>
                            <td class="total-product-price"><%if(!ctrl){
                        out.println(String.format("%.2f&euro;", carrello.getTotal()*0.22+carrello.getTotal()));
                        }else{
                        	out.println("0.00");
                        }
                        %></td>
                        </tr>
                        <tr>
                        	 <%if(ctrl){ %>
                            <td><br><a href="cart.jsp" class="btn">Acquista</a></td>
                            <%}else{ %>
                            <td><br><a href="RedirectServlet" class="btn">Acquista</a></td>
                            <%} %>
                            <td><br><a href="RemoveFromCartServlet?action=clear" class="btn">Svuota</a></td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
        <!--Footer-->
       <%@ include file="includes/footer.jsp" %>
        <script src="scripts/script.js"></script>
    </body>

    </html>