<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        VideogiocoDAO vdao = new VideogiocoDAO();
        ArrayList<VideogiocoBean> lista = vdao.doRetrieveAll();
        %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>GameOver | Home</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        </head>

        <body>
                <!-- Header -->
                 <%@ include file="includes/header.jsp" %>

                <!-- Home Banner -->
                <div class="banner" id="">
                        <div class="bg">
                                <div class="content">
                                        <h2 class="glitch">L'ordine è andato<br>
                                        					a buon fine!</h2>
                                        <p>Per vedere il tuo ordine vai alla sezione "Ordini".</p>
                                        <p>Se invece hai effettuato una prenotazione vai alla sezione "Prenotazioni">
                                        <a href="index.jsp" class="btn">Torna sull'homepage</a>
                                        <br>
                                        <a href="orders.jsp" class="btn">Ordini</a>
                                        <br>
                                        <a href="prenotazioni.jsp" class="btn">Prenotazioni</a>
                                </div>
                                <div class="imgBx">
                                        <div class="ball"></div>
                                        <img src="images/ball_acquisto.png">
                                </div>
                        </div>
                </div>
                <!-- Footer -->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>