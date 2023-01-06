<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameOver | E-Sport</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>

<body>
<!-- Header -->
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
<!-- Card Banner -->
<div class="games" id="games">
    <h2>E-Sports</h2>
    <br>
    <br>
    <br>
    <div class="containercard" id="cards">
        <div class="cards1">
            <div class="contentcards">
                <h2>Postazioni Gioco</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non
                    dignissim tortor molestie.
                    Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
                </p>
                <a href="postazionedetails.jsp">Dettagli</a>
            </div>
            <img src="images/computer.png"></img>
        </div>
        <div class="cards">
            <div class="contentcards">
                <h2>Tavolo da Gioco</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non
                    dignissim tortor molestie.
                    Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
                </p>
                <a href="tavolodetails.jsp">Read More</a>
            </div>
            <img src="images/casa.png"></img>
        </div>
    </div>
</div>
</div>
<!-- Footer -->
<footer>
    <div class="info">
        <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                aria-hidden="true">GameOver</span></a>
        <p><i class="bx bx-copyright"></i>2022 All Rights Reserved</p>
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