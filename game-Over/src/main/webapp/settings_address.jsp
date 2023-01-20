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
    <title>Dashboard User|Modifica informazioni profilo</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
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
              <i class='bx bx-cog'></i>
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
        <span class="text">Benvenuto|Admin Dashboard</span>
      </div>
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
          <label class="collapsible-head" for="collapsible-head">Modifica Indirizzo (1)</label>
          <div class="collapsible-text">
            <div class="card-body">
              <div class="form-group">
                <label for="inputName">Nome</label>
                <input type="text" id="inputName" class="form-control">
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="inputName">Cognome</label>
                <input type="text" id="inputName" class="form-control">
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label for="inputPrice">Città</label>
                <input type="text" id="inputName" class="form-control">

              </div>
              <div class="form-group">
                <label for="inputPrice">Paese</label>
                <input type="text" id="inputName" class="form-control">

              </div>
              <div class="form-group">
                <label for="inputPrice">Provincia</label>
                <input type="text" id="inputName" class="form-control">

              </div>
              <div class="form-group">
                <label for="inputPrice">CAP</label>
                <input type="text" id="inputName" class="form-control">

              </div>
              <div class="form-group">
                <label for="inputPrice">Indirizzo</label>
                <input type="text" id="inputName" class="form-control">
				<div class="row">
                    <div class="col-12">
                      <input type="submit" value="Conferma" class="right button">
                    </div>
              </div>
              
                <div class="form-group">
                  <label for="inputProjectLeader">Telefono</label>
                  <input type="text" id="inputName" class="form-control">
                  <div class="row">
                    <div class="col-12">
                      <input type="submit" value="Conferma" class="right button">
                    </div>
                  </div>
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
    </script>
  </body>

  </html>