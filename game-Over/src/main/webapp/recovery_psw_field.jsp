<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
       UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
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
</head>

<body>
  <!-- Header -->
  <%@ include file="includes/header.jsp" %>
  <!-- Register -->
  <div class="fakebody">
    <div class="containerbody">
      <h2>
        <a href="#" class="logo"><span aria-hidden="true">Recupero</span>Recupero<span
          aria-hidden="true">Recupero</span></a>
      <a href="#" class="logo"><span aria-hidden="true"></span>Password<span
          aria-hidden="true"></span></a>
      </h2>
      <div class="form-outer">
        <form action="RecoveryPasswordServlet?action=field&id=<%=utente.getUsername() %>" method="post">
          <div class="page">
            <div class="field">
                <div class="label">
                    Password
                </div>
                <input type="password" id="password-field" name="pass1" required>
                <div class="toggle-password">
                    <i class="fa fa-eye"></i>
                    <i class="fa fa-eye-slash"></i>
                </div>
                <div class="password-policies">
                    <div class="policy-length">
                        Almeno 8 caratteri(a-z)
                    </div>
                    <div class="policy-number">
                        Contiene un numero(0-9)
                    </div>
                    <div class="policy-uppercase">
                        Contiene una maiuscola(A-Z)
                    </div>
                    <div class="policy-special">
                        Contiene un carattere speciale(\ - .)
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
                <input type="password" id="password-field" name="pass2" required>
            </div>
                          
            <div class="field">
              <button class="">Reset</button>
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
    /* Slash/Unslash EyePSW */
    function _id(name) {
      return document.getElementById(name);
    }
    function _class(name) {
      return document.getElementsByClassName(name);
    }
    _class("toggle-password")[0].addEventListener("click", function () {
      _class("toggle-password")[0].classList.toggle("active");
      if (_id("password-field").getAttribute("type") == "password") {
        _id("password-field").setAttribute("type", "text");
      } else {
        _id("password-field").setAttribute("type", "password");
      }
    });
    /* Password Policy Validation */
    _id("password-field").addEventListener("focus", function () {
      _class("password-policies")[0].classList.add("active")
    });
    _id("password-field").addEventListener("blur", function () {
      _class("password-policies")[0].classList.remove("active")
    });
    _id("password-field").addEventListener("keyup", function () {
      let password = _id("password-field").value;
      if (/[A-Z]/.test(password)) {
        _class("policy-uppercase")[0].classList.add("active");
      } else {
        _class("policy-uppercase")[0].classList.remove("active");
      }
      if (/[0-9]/.test(password)) {
        _class("policy-number")[0].classList.add("active");
      } else {
        _class("policy-number")[0].classList.remove("active");
      }
      if (/[^A-Za-z0-9]/.test(password)) {
        _class("policy-special")[0].classList.add("active");
      } else {
        _class("policy-special")[0].classList.remove("active");
      }
      if (password.length > 7) {
        _class("policy-length")[0].classList.add("active");
      } else {
        _class("policy-length")[0].classList.remove("active");
      }
    });
  </script>

</body>

</html>


