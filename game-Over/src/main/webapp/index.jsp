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
                <div class="banner animeX" id="home">
                        <div class="bg">
                                <div class="content">
                                        <h2 class="glitch">A New Era of<br>
                                                E-Sport Commerce</h2>
                                        <p> La forma di competizione che coinvolge videogiochi competitivi, dove i giocatori si sfidano tra loro per raggiungere gli obiettivi del gioco e divertirsi con gli amici.
                                        Per chi non ha possibilità di permettersi un PC da gaming o vuole passare del tempo con dei propri amici in compagnia attorno a un tavolo da giochi.
                                        In più avrai la possibilità di acquistare direttamente i giochi offerti nelle postazioni da gaming direttamente sul nostro sito!</p>
                                        <a href="shopgame.jsp" class="btn">Esplora</a>
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
                                <p>GameOver è un progetto dedicato agli appassionati di videogiochi e giochi da tavolo, che mira a creare uno spazio accogliente dove incontrarsi, socializzare e divertirsi insieme. Offriamo un ambiente confortevole, dotato di postazioni di gioco attrezzate con computer o adatte a giochi da tavolo, accompagnate da snack e bevande per rendere l'esperienza ancora più piacevole. Inoltre, proponiamo la vendita e la prenotazione di videogiochi, giochi da tavolo e bustine di carte collezionabili per coloro che vogliono provare i nuovi titoli sul mercato. Siamo il punto d'incontro perfetto per tutti gli appassionati di videogiochi e giochi da tavolo, indipendentemente dall'età, dal genere o dalla classe sociale. Venite a trovarci per vivere insieme la passione per i giochi!
                                </p>
                              <a href="aboutus.jsp">Leggi di più</a>
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
            <%if(!lista.isEmpty()){
		    		for(VideogiocoBean b: lista){
		    			if(b.getTipo().contains("PS4")||b.getTipo().contains("Nintendo")){%>
                <div class="card" data-item="console">
                     <img src="<%=b.getImg1() %>" alt="game1.png">
                    <div class="content">
                        <h4><%=b.getNome()%></h4>
                        <p class="price">Pricing<span> €<%=b.getPrezzo()%></span></p>
                        <div class="info">
                         <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <%} %>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>              
            <%}
		    		}
            }%>
                       </div>
              <div class="cardBx">
            <%if(!lista.isEmpty()){
		    		for(VideogiocoBean b: lista){
		    			if(b.getTipo().contains("PC")){%>
                <div class="card" data-item="pc">
                    <img src="<%=b.getImg1() %>" alt="game1.png">
                    <div class="content">
                        <h4><%=b.getNome()%></h4>
                        <p class="price">Pricing<span> €<%=b.getPrezzo()%></span></p>
                        <div class="info">
                         <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <%} %>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>              
            <%}
		    		}
            }%>
                        </div>
                </div>
                <!-- Card Banner -->
                <!-- <div class="containercard animeX" id="cards">
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
                </div> -->
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