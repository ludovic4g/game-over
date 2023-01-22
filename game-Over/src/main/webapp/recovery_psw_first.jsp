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
        <form action="#">
          <div class="page slide-page">
            <div class="field">
              <div class="label">
                E-mail
              </div>
              <input type="text" required>
            </div>
            <div class="field">
              <button class="firstNext next">Avanti</button>
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
              <input type="text" required>
            </div>
            <div class="field btns">
              <button class="">Conferma</button>
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