<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page import="java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth", auth);
    }
    String cerca = (String) request.getSession().getAttribute("cerca");
    if(cerca!=null){
        request.setAttribute("cerca", cerca);
    }

%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Giochi</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    </head>

    <body>
        <!--Header-->
        <%@ include file="includes/header.jsp" %>
        <br>
        <!--Games-->
        <div class="games animeX" id="games">
            <h2><%= "Risultati per "+ cerca %>  </h2>
            <div class="cardBx">
                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="productdetails.jsp">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="productdetails.jsp">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="productdetails.jsp">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href=productdetails.jsp"">Dettagli</a>
                        </div>
                    </div>
                </div>


                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="">Dettagli</a>
                        </div>
                    </div>
                </div>

                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4>Game Name</h4>
                        <p class="price">Pricing<span>$10</span></p>
                        <div class="info">
                            <a href=""><i class='bx bx-cart-add'></i></a>
                            <a href="">Dettagli</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
        <script src="scripts/script.js"></script>
    </body>

    </html>