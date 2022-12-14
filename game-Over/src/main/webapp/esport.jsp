<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>GameOver|E-Sport</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        </head>

        <body>
                <!--Header-->
                <%@ include file="includes/header.jsp" %>
                <!--Card Banner-->
                <div class="games" id="games">
                        <h2>E-Sports</h2>
                        <br>
                        <br>
                        <br>
                        <div class="containercard" id="cards">
                                <div class="cards1">
                                        <div class="contentcards">
                                                <h2>Postazioni Gioco</h2>
                                                <p>Lorem ipsum dolor sit amet,consectetur adipiscing elit.Proin eleifend
                                                        diam a nisl viverra,non
                                                        dignissim tortor molestie.
                                                        Sed eget mi maximus,venenatis risus dignissim,placerat nunc.
                                                </p>
                                                <a href="postazionedetails.jsp">Dettagli</a>
                                        </div>
                                        <img src="images/computer.png"></img>
                                </div>
                                <div class="cards">
                                        <div class="contentcards">
                                                <h2>Tavolo da Gioco</h2>
                                                <p>Lorem ipsum dolor sit amet,consectetur adipiscing elit.Proin eleifend
                                                        diam a nisl viverra,non
                                                        dignissim tortor molestie.
                                                        Sed eget mi maximus,venenatis risus dignissim,placerat nunc.
                                                </p>
                                                <a href="tavolodetails.jsp">Read More</a>
                                        </div>
                                        <img src="images/casa.png"></img>
                                </div>
                        </div>
                </div>
                </div>
                <!--Footer-->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>