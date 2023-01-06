<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible"content="IE=edge">
<meta name="viewport"content="width=device-width, initial-scale=1.0">
<title>GameOver|Registrazione</title>
<link rel="stylesheet"type="text/css"href="style.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'rel='stylesheet'>
<link rel="stylesheet"href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
<!--Header-->
<header>
<a href="#"class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
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
<input type="text"placeholder="Search Games">
</div>
</div>
<div class="toggleMenu"onclick="toggleMenu();"></div>
</header>
<!--Register-->
<!--<div class="containerlogin">
<div class="boxRegister">
<div class="formlogin">
<h2>Sign in</h2>
<div class="inputBox">
<input type="text"required="required">
<span>Username</span>
<i></i>
</div>
<div class="inputBox">
<input type="email"required="required">
<span>E-mail</span>
<i></i>
</div>
<div class="inputBox">
<select class="selection">
<option selected="selected">Genere</option>
<option value="">Uomo</option>
<option value="">Donna</option>
<option value="">Altro</option>
</select>
<span></span>
<i></i>
</div>
<div class="inputBox">
<input type="date"required="required">
<span></span>
<i></i>
</div>
<div class="inputBox">
<input type="text"required="required">
<span>Nome</span>
<i></i>
</div>
<div class="inputBox">
<input type="text"required="required">
<span>Cognome</span>
<i></i>
</div>
<div class="inputBox">
<input type="Password"required="required">
<span>Password</span>
<i></i>
</div>
<div class="inputBox">
<input type="Password"required="required">
<span>Conferma Password</span>
<i></i>
</div>
<div class="links">
<a href="login.html">Sign In</a>
</div>
<input type="submit"value="Avanti">
</div>
</div>
</div>-->

<div class="fakebody">
<div class="containerbody">
<h2>
<a href="#"class="logo"><span aria-hidden="true">Registrazione</span>Registrazione<span
                    aria-hidden="true">Registrazione</span></a>
</h2>
<div class="progress-bar">
<div class="step">
<p>
                    1
</p>
<div class="bullet">
</div>
<div class="check fas fa-check"></div>
</div>
<div class="step">
<p>
                    2
</p>
<div class="bullet">
</div>
<div class="check fas fa-check"></div>
</div>
<div class="step">
<p>
                    3
</p>
<div class="bullet">
</div>
<div class="check fas fa-check"></div>
</div>
<div class="step">
<p>
                    4
</p>
<div class="bullet">
</div>
<div class="check fas fa-check"></div>
</div>
</div>
<div class="form-outer">
<form action="#">
<div class="page slide-page">
<div class="field">
<div class="label">
        Nome
</div>
<input type="text"required>
</div>
<div class="field">
<div class="label">
        Cognome
</div>
<input type="text"required>
</div>
<div class="field">
<div class="label">
        Username
</div>
<input type="text"required>
</div>
<div class="field">
<div class="label">
        E-mail
</div>
<input type="text"required>
</div>
<div class="field">
<button class="firstNext next">Avanti</button>
</div>
</div>
<div class="page">
<div class="field">
<div class="label">
        Genere
</div>
<select required>
<option selected="selected">Preferisco non specificarlo</option>
<option>Maschio</option>
<option>Femmina</option>
<option>Altro</option>
</select>
</div>
<div class="field">
<div class="label">
        Data di Nascita
</div>
<input type="date"required>
</div>
<div class="field btns">
<button class="prev-1 prev">Indietro</button>
<button class="next-1 next">Avanti</button>
</div>
</div>
<div class="page">
<div class="field">
<div class="label">
        Password
</div>
<input type="password"id="password-field"required>
<div class="toggle-password">
<i class="fa fa-eye"></i>
<i class="fa fa-eye-slash"></i>
</div>
<div class="password-policies">
<div class="policy-length">
        Almeno 8caratteri(a-z)
</div>
<div class="policy-number">
        Contiene un numero(0-9)
</div>
<div class="policy-uppercase">
        Contiene una maiuscola(A-Z)
</div>
<div class="policy-special">
        Contiene un carattere speciale(\ -.)
</div>
</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="field">
<div class="label">
        Conferma Password
</div>
<input type="password"id="password-field"required>
</div>
<div class="field btns">
<button class="prev-2 prev">Indietro</button>
<button class="next-2 next">Avanti</button>
</div>
</div>
<div class="page">
<div class="field">
<div class="label">
        Domanda di sicurezza
</div>
<select required>
<option selected="selected">Città preferita</option>
<option>Nome dell’amico del cuore</option>
<option>Qual'era il cognome da nubile di tua madre</option>
<option>Il nome del tuo primo animale domestico</option>
</select>
</div>
<div class="field">
<div class="label">
        Risposta
</div>
<input type="text"required>
</div>
<div class="field btns">
<button class="prev-3 prev">Indietro</button>
<button class="submit">Registrati</button>
</div>
</div>
</form>
</div>
</div>
</div>
<!--Footer-->
<footer>
<div class="info">
<a href="#"class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
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
<script src="anime.min.js"></script>
<script src="scripts/script.js"></script>
</body>
</html>