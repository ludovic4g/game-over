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
            <h2>Games</h2>
            <ul>
                <li class="list active" data-filter="all">All</li>
                <li class="list" data-filter="pc">Pc Games</li>
                <li class="list" data-filter="console">Console Games</li>
            </ul>
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
        <footer>
            <div class="info">
                <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                        aria-hidden="true">GameOver</span></a>
                <p><i class="bx bx-copyright"></i>2022All Rights Reserved</p>
                <ul>
                    <li><a href=""><i class="bx bxl-facebook"></i></a></li>
                    <li><a href=""><i class="bx bxl-instagram"></i></a></li>
                    <li><a href=""><i class="bx bxl-twitter"></i></a></li>
                    <li><a href=""><i class="bx bxl-youtube"></i></a></li>
                </ul>
            </div>
        </footer>
        <script src="scripts/script.js"></script>
    </body>

    </html>