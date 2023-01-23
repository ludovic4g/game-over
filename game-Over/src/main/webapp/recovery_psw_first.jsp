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
  <title>GameOver</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
  <script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                 $("#sub").change(function(){
                     var mail = $(this).val();
                     $.get("data.jsp",{q:value},function(data){
                      $("#msg").html(data);
                     });
                 });
             });
        </script>
        
</head>

<body>
  <!-- Header -->
  <%@ include file="includes/header.jsp" %>
  <!-- Register -->
<%String mail = request.getParameter("Email");
  UtenteDAO udao = new UtenteDAO();
  String domanda = udao.doRetrieveDomanda(mail);
  out.println("eiiiii");
  %>
  <div class="fakebody">
    <div class="containerbody">
      <h2>
        <a href="#" class="logo"><span aria-hidden="true">Recupero</span>Recupero<span
            aria-hidden="true">Recupero</span></a>
        <a href="#" class="logo"><span aria-hidden="true"></span>Password<span
            aria-hidden="true"></span></a>
      </h2>
      <div class="progress-bar">
        <div class="step">
          <p>
            1
          </p>
          <div class="bullet_psw">
          </div>
          <div class="check fas fa-check"></div>
        </div>
        <div class="step">
          <p>
            2
          </p>
          <div class="bullet_psw">
          </div>
          <div class="check fas fa-check"></div>
        </div>
      </div>
      <div class="form-outer">
        <form action="RecoveryPasswordServlet?action=first" method="post">
          <div class="page slide-page">
            <div class="field">
              <div class="label">
                E-mail
              </div>
              <input type="text" name="mail" required>
            </div>
            <div class="field">
              <button class="firstNext next" id="sub" type="submit">Avanti</button>
            </div>
          </div>
          <div class="page">
            <div class="field">
              <div class="label">
                Domanda di sicurezza
              </div>
              <div id="msg" style="" ><b></b></div>
            </div>
            <div class="field">
              <div class="label">
                Risposta
              </div>
              <input type="text" name="risposta" required>
            </div>
            <div class="field btns">
              <button class="" type="submit">Conferma</button>
            </div>
          </div>
         </form>
      </div>
    </div>
  </div>
  </div>
  <!-- Footer -->
  <%@ include file="includes/footer.jsp" %>
  <script src="anime.min.js"></script>
  <script>
    /* Sticky NavBar */
    window.addEventListener('scroll', function () {
      var header = document.querySelector('header');
      header.classList.toggle('sticky', window.scrollY > 0);
    });
    /* Responsive NavBar */
    function toggleMenu() {
      const toggleMenu = document.querySelector('.toggleMenu');
      const nav = document.querySelector('.nav')
      toggleMenu.classList.toggle('active')
      nav.classList.toggle('active')
    }
    /* Scrolling Animation Effects*/
    window.addEventListener('scroll', function () {
      var anime = document.querySelectorAll('.animeX');

      for (var s = 0; s < anime.length; s++) {
        var windowheight = window.innerHeight;
        var animetop = anime[s].getBoundingClientRect().top;
        var animepoint = 150;

        if (animetop < windowheight - animepoint) {
          anime[s].classList.add('active');
        }
        else {
          anime[s].classList.remove('active');
        }
      }
    })
    /* Registration Page Next/Prev */
    const slidePage = document.querySelector(".slide-page");
    const nextBtnFirst = document.querySelector(".firstNext");
    const progressText = document.querySelectorAll(".step p");
    const progressCheck = document.querySelectorAll(".step .check");
    const bullet_psw = document.querySelectorAll(".step .bullet_psw");
    let current = 1;
    nextBtnFirst.addEventListener("click", function (event) {
      event.preventDefault();
      slidePage.style.marginLeft = "-25%";
      bullet_psw[current - 1].classList.add("active");
      progressCheck[current - 1].classList.add("active");
      progressText[current - 1].classList.add("active");
      current += 1;
    });

  </script>

</body>

</html>