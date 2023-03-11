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
        
        if(carrello== null){
        	carrello = new Carrello();
        }
        boolean ctrl= carrello==null;
        games= carrello.getGames();
        request.setAttribute("carrello", carrello);
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
                    <tr class="column">
                        <th>Prodotti</th>
                        <th>Quantità</th>
                        <th>Piattaforma</th>
                        <th>Totale</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/27612067/r/il/f086b9/3983570447/il_794xN.3983570447_95oe.jpg">
                                <div class="resume">
                                    <p>Bracciale tormalina nera grezza</p>
                                    <small class="single-product-price">Prezzo:$50.00</small>
                                    <br>
                                    <small class="single-product-price">Orario:17:30</small>
                                    <small class="single-product-price">N.Persone:3</small>
                                    <br>
                                    <a class="remove" href="">Remove</a>
                                </div>
                            </div>
                        </td>
                        <td><input type="number" min="1" value="1"></td>
                        <td class="platform">//</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <%if(games!=null) {
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