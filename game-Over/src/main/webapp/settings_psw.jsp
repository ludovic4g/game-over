<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Admin|Aggiungi Prodotto</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="dashboard.css">
  </head>

  <body>
    <!---------SideBar--------->
    <div class="sidebar close">
      <div class="logo-details">
        <i class='bx bxs-joystick'></i>
        <span class="logo_name">GameOver</span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="#">
            <i class='bx bx-grid-alt'></i>
            <span class="link_name">Dashboard</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="dashboard_user.jsp">Dashboard</a></li>
          </ul>
        </li>
        <li>
          <div class="iocn-link">
            <a href="#">
              <i class='bx bx-lock'></i>
              <span class="link_name">Impostazioni profilo</span>
            </a>
            <i class='bx bxs-chevron-down arrow'></i>
          </div>
          <ul class="sub-menu">
            <li><a class="link_name" href="#">Impostazioni</a></li>
            <li><a href="settings.jsp">Modica informazioni</a></li>
            <li><a href="settings_address.jsp">Modifica Indirizzo</a></li>
            <li><a href="settings_psw.jsp">Modifica Password</a></li>
          </ul>
        </li>
        <li>
          <a href="index.jsp">
            <i class='bx bx-home'></i>
            <span class="link_name">Home</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="index.jsp">Home</a></li>
          </ul>
        </li>
      </ul>
      <!---------Home Section--------->
    </div>
    <section class="home-section">
      <div class="home-content">
        <i class='bx bx-menu'></i>
        <span class="text">Aggiungi Prodotto|Admin Dashboard</span>
      </div>
      <!---------AddProduct Section--------->
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
          <label class="collapsible-head" for="collapsible-head">Modifica Password</label>
          <div class="collapsible-text">
            <div class="card-body">
              <div class="form-group">
                <label for="inputName">Vecchia Password</label>
                <input type="text" id="inputName" class="form-control">
              </div>
              <div class="form-group">
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
                        <br>
                        <br>
                        <br>
                        <div class="field">
                            <div class="label">
                                Conferma Password
                            </div>
                            <input type="password" id="password-field" required>
                        </div>
              <div class="row">
                <div class="col-12">
                  <input type="submit" value="Modifica" class="right button">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <script>
      /* Js For Animated SideBar */
      let arrow = document.querySelectorAll(".arrow");
      for (var i = 0; i < arrow.length; i++) {
        arrow[i].addEventListener("click", (e) => {
          let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
          arrowParent.classList.toggle("showMenu");
        });
      }
      let sidebar = document.querySelector(".sidebar");
      let sidebarBtn = document.querySelector(".bx-menu");
      console.log(sidebarBtn);
      sidebarBtn.addEventListener("click", () => {
        sidebar.classList.toggle("close");
      });
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