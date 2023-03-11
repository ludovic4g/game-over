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
                <title>GameOver | About Us</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        </head>

        <body>
                <!-- Header -->
                 <%@ include file="includes/header.jsp" %>

                <!-- Home Banner -->
                <div class="banner animeX" id="home">
                        <div class="bg">
                                <div class="content">
                                        <h2>Chi siamo?</h2>
                                        <p> Benvenuti in GameOver, ci dedichiamo al mondo del gaming e dei giochi da tavolo. 
                                        Con il nostro obiettivo di creare uno spazio accogliente per gli appassionati del settore, offriamo un'esperienza di gioco confortevole e all'avanguardia.
                                        la nostra selezione di videogiochi, giochi da tavolo e bustine di carte collezionabili è stata accuratamente scelta per soddisfare le esigenze dei nostri clienti più esigenti. 
                                        La nostra offerta comprende le ultime novità del mercato, così come i classici preferiti dagli appassionati di lunga data.</p>
                                </div>
                                <div class="imgBx">
                                        <div class="ball"></div>
                                        <img src="images/ball3.png">
                                </div>
                        </div>
                </div>
                <!-- About -->
                <div class="about animeX" id="about">
                        <div class="imgBox">
                                <img src="images/ball4.png">
                        </div>
                        <div class="contentBx">
                                <h2>Cosa puoi trovare?</h2>
                                <p>Presso GameOver, i nostri clienti possono prenotare tavoli attrezzati con computer o senza, scegliendo tra una vasta selezione di giochi per PC e console o optando per i classici giochi da tavolo. 
                                Offriamo inoltre una vasta gamma di snack e bevande per rendere la vostra esperienza di gioco ancora più piacevole.
                                </p>
                        </div>
                </div>
                </div>
                <!-- Footer -->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>