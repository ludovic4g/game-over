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
                <title>GameOver | Home</title>
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
                                        <h2 class="glitch">A New Era of<br>
                                                E-Sport Commerce</h2>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisci elit, sed do eiusmod tempor
                                                incidunt ut labore et
                                                dolore magna aliqua.</p>
                                        <a href="#" class="btn">Explore</a>
                                </div>
                                <div class="imgBx">
                                        <div class="ball"></div>
                                        <img src="images/ball1.png">
                                </div>
                        </div>
                </div>
                <!-- About -->
                <div class="about animeX" id="about">
                        <div class="imgBox">
                                <img src="images/videogames.png">
                        </div>
                        <div class="contentBx">
                                <h2>About Us</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl
                                        viverra, non
                                        dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim,
                                        placerat nunc.
                                        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed
                                        est gravida, eget
                                        volutpat purus finibus.
                                        Maecenas dapibus dapibus faucibus. Mauris non euismod lorem.
                                        Phasellus ornare, nunc a aliquet posuere, ligula metus dapibus sapien, in
                                        aliquet erat purus nec dolor.
                                        Nulla facilisi. Etiam arcu sem, ultrices quis dolor vel, fringilla ultrices
                                        augue.
                                </p>
                                <a href="#">Read More</a>
                        </div>
                </div>
                <!-- Games -->
                <div class="games animeX" id="games">
                        <h2>Popular Games</h2>
                        <ul>
                                <li class="list active" data-filter="all">All</li>
                                <li class="list" data-filter="pc">Pc Games</li>
                                <li class="list" data-filter="console">Console Games</li>
                        </ul>
                        <div class="cardBx">
                                <div class="card" data-item="pc">
                                        <img src="https://upload.wikimedia.org/wikipedia/en/5/5e/Fall_Guys_cover.jpg"
                                                alt="">
                                        <div class="content">
                                                <h4>Fall Guys</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>
                                <div class="card" data-item="pc">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>
                                <div class="card" data-item="pc">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>
                                <div class="card" data-item="pc">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>
                                <div class="card" data-item="console">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>

                                <div class="card" data-item="console">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>

                                <div class="card" data-item="console">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>

                                <div class="card" data-item="console">
                                        <img src="game1.png" alt="">
                                        <div class="content">
                                                <h4>Game Name</h4>
                                                <div class="info">
                                                        <p>Pricing<br><span>$10</span></p>
                                                        <a href=""><i class='bx bx-cart-add'></i></a>
                                                </div>
                                        </div>
                                </div>
                        </div>
                </div>
                <!-- Card Banner -->
                <div class="containercard animeX" id="cards">
                        <div class="cards">
                                <div class="contentcards">
                                        <h2>Title</h2>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam
                                                a nisl viverra, non
                                                dignissim tortor molestie.
                                                Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
                                        </p>
                                        <a href="#">Read More</a>
                                </div>
                                <img src="images/raiden.png"></img>
                        </div>
                        <div class="cards1">
                                <div class="contentcards">
                                        <h2>Title</h2>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam
                                                a nisl viverra, non
                                                dignissim tortor molestie.
                                                Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
                                        </p>
                                        <a href="#">Read More</a>
                                </div>
                                <img src="images/computer.png"></img>
                        </div>
                        <div class="cards">
                                <div class="contentcards">
                                        <h2>Title</h2>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam
                                                a nisl viverra, non
                                                dignissim tortor molestie.
                                                Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
                                        </p>
                                        <a href="#">Read More</a>
                                </div>
                                <img src="images/casa.png"></img>
                        </div>
                </div>
                <!-- Tournaments -->
                <!-- <div class="tournaments animeX" id="tournaments">
<h2>Live Tournaments</h2>
<div class="boxBx">
<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>

<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>

<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>

<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>

<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>

<div class="box">
<img src="" alt="">
<div class="content">
<h4><span>50 </span>Matches in progress</h4>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eleifend diam a nisl viverra, non dignissim tortor molestie. Sed eget mi maximus, venenatis risus dignissim, placerat nunc.
        Maecenas placerat nibh tortor, in blandit arcu tempus non. Sed cursus ante sed est gravida, eget volutpat purus finibus.</p>
<div class="btn">
<a href="" class="watch">Watch</a>
<a href="" class="join">Join now</a>
</div>
</div>
</div>
</div>
</div> -->
                <!-- Contact Us -->
                <!-- <div class="contact animeX" id="contact">
<img src="" alt="">
<div class="form">
<h1>Contact Us</h1>
<div class="inputBx">
<p>Enter Name</p>
<input type="text" placeholder="Fullname">
</div>
<div class="inputBx">
<p>Enter Email</p>
<input type="text" placeholder="Fullname">
</div>
<div class="inputBx">
<p>Message</p>
<textarea placeholder="Type here..."></textarea>
</div>
<div class="inputBx">
<input type="submit" name="Submit">
</div>
</div>
</div> -->
                <!-- Footer -->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>