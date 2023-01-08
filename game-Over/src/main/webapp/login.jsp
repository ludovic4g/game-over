<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Login</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
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
        <!--Login-->
        <div class="containerlogin">
            <div class="boxlogin">
                <div class="formlogin">
                    <h2>
                        <a href="#" class="logo"><span aria-hidden="true">Login</span>Login<span
                                aria-hidden="true"></span></a>
                    </h2>
                    </h2>
                <form action="LoginServlet" method="post">
                    <div class="inputBox">
                        <input type="text" name="username" required="required">
                        <span>Username</span>
                        <i></i>
                    </div>
                    <div class="inputBox">
                        <input type="Password" name="password" required="required">
                        <span>Password</span>
                        <i></i>
                    </div>
                    <div class="links">
                        <a href="">Forgot Password</a>
                        <a href="register.jsp">Sign up</a>
                    </div>
                    <input type="submit" value="Login">
                    </form>
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
        <script src="scripts/anime.min.js"></script>
        <script src="scripts/script.js"></script>
    </body>

    </html>