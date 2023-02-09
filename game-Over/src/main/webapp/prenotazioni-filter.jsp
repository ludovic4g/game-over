<%@ page import= "utente.model.*" %>
<%@ page import= "gestorepren.model.*" %>
<%@ page import= "java.text.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        PrenotazioneDAO pdao = new PrenotazioneDAO();
        ArrayList<PrenotazioneBean> prenotazioni = pdao.doRetriveAllByKey(auth.getUsername());
        %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Prenotazioni</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <!--Header-->
         <%@ include file="includes/header.jsp" %>
        <!--Carrello-->
        <div class="containercart">
            <h2 class="title-page">Prenotazioni</h2>
            <div class="small-container cart-page">
                <table>
                <% for(PrenotazioneBean b: prenotazioni){%>
                    <tr class="column">
                        <th>ID Prenotazione</th>
                        <th>Stato</th>
                         <th>Data</th>
                        <th>Orario</th>
                        <th>N.A Sedere</th>
                        <th>Prezzo</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="">
                                <div class="resume">
                                    <p><%=b.getIdPrenotazione() %></p>
                                    <br>
                                    <a class="remove" href="CancelPrenotazioneServlet?id=<%=b.getIdPrenotazione()%>">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state"><%=b.getStato() %></td>
                        <td class="clock"><%=b.getOra() %></td>
                        <td class="date"><%=b.getDataprenotazione() %></td>
                        <td class="quantity"><%=b.getPostiPrenotati() %></td>
                        <td class="product-price"><%=b.getPrezzo() %></td>
                    </tr>
                   <%} %>
                </table>
            </div>
        </div>
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
        <script src="scripts/script.js"></script>
    </body>

    </html>