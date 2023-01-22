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
  <header>
    <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
        aria-hidden="true">GameOver</span></a>
    <ul class="nav">
      <li><a href="gamebar.html">Home</a></li>
      <li><a href="#">E-Sport</a></li>
      <li><a href="#">Games</a></li>
      <li><a href="#">Carrello</a></li>
      <li><a href="#">Prenotazioni</a></li>
      <li><a href="#">Ordini</a></li>
      <li><a href="login.html">Login</a></li>
    </ul>
    <div class="action">
      <div class="searchBx">
        <a href="#"><i class='bx bx-search'></i></a>
        <input type="text" placeholder="Search Games">
      </div>
    </div>
    <div class="toggleMenu" onclick="toggleMenu();"></div>
  </header>
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
        <form action="#">
          <div class="page">
            <div class="field">
                <div class="label">
                    Password
                </div>
                <input type="password" id="password-field" required>
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
                <input type="password" id="password-field" required>
            </div>
                          
            <div class="field">
              <button class="">Reset</button>
            </div>
          </div>
      </div>
      </form>
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


