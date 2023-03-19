<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        %>
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
    <link rel="stylesheet" href="dashboard.css">
  </head>

  <body>
    <!---------SideBar--------->
    <%@ include file="includes/sidebar-admin.jsp" %>
    <!--  -->
    <section class="home-section">
      <div class="home-content">
        <i class='bx bx-menu'></i>
        <span class="text">Aggiungi Prodotto|Admin Dashboard</span>
      </div>
      <!---------AddProduct Section--------->
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
          <label class="collapsible-head" for="collapsible-head">Aggiungi Prodotto</label>
          <div class="collapsible-text">
            <div class="card-body">
            <form action="AggiungiGiocoServlet" method="post">
              <div class="form-group">
                <label for="inputName">Nome Prodotto</label>
                <input type="text" id="inputName" class="form-control" name="name">
              </div>
               <div class="form-group">
                <label for="inputName">Quantita' da Aggiungere</label>
                <input type="text" id="inputName" class="form-control" name="quantita">
              </div>
              <div class="form-group">
                <label for="inputName">Anno</label>
                <input type="text" id="inputName" class="form-control" name="anno">
              </div>
              <div class="form-group">
                <label for="inputDescription">Descrizione Prodotto</label>
                <textarea id="inputDescription" class="form-control" rows="4" name="descrizione"></textarea>
              </div>
              <div class="form-group">
                <label for="inputPrice">Prezzo</label>
                <input type="text" id="inputPrice" class="form-control" name="prezzo">
              </div>
              <div class="form-group">
                <label for="inputName">Piattaforma</label>
                <input type="text" id="inputName" class="form-control" name="piattaforma">
              </div>
              <div class="form-group">
                <label for="inputProjectLeader">Immagine Principale</label>
                <br>
                <input type="text" id="inputName" class="form-control" name="img1">
                <input type="text" id="inputName" class="form-control" name="img2">
                <div class="form-group">
                  <label for="inputProjectLeader">Immagini Secondarie</label>
                  <input type="text" id="inputName" class="form-control" name="img3">
                  <input type="text" id="inputName" class="form-control" name="img4">
                  <input type="text" id="inputName" class="form-control" name="img5">
                </div>
              </div>
              <div class="row">
                <div class="col-12">
                  <input type="submit" value="Aggiungi Prodotto" class="right button">
                </div>
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- Aggiungi Postazione -->
       <div class="wrapper">
        <div class="collapsible2">
          <input class="check2" type="checkbox" id="collapsible-head2">
          <label class="collapsible-head2" for="collapsible-head2">Aggiungi Postazione</label>
          <div class="collapsible-text2">
            <div class="card-body">
            <form action="AggiungiPostazioneServlet" method="post">
              <div class="form-group">
                <label for="inputName">Ora</label>
                <select name="ora" class="option">
                  <option value="9:30 - 11:30">9:30 - 11:30</option>
                  <option value="14:30 - 16:30">14:30 - 16:30</option>
                  <option value="18:30 - 20:30">18:30 - 20:30</option>
                </select>
              </div>
              <div class="form-group">
                <label for="inputName">Piattaforma</label>
                <select name="piattaforma" class="option">
                  <option value="PC">PC</option>
                  <option value="PS5">PS5</option>
                  <option value="XBox">XBox</option>
                </select>
              </div>
              <div class="row">
                <div class="col-12">
                  <input type="submit" value="Aggiungi Postazione" class="right button">
                </div>
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      </div>
      <!-- Add Tavoli -->
       <div class="wrapper">
        <div class="collapsible3">
          <input class="check3" type="checkbox" id="collapsible-head3">
          <label class="collapsible-head3" for="collapsible-head3">Aggiungi Tavolo da Gioco</label>
          <div class="collapsible-text3">
            <div class="card-body">
            <form action="AggiungiTavoloServlet" method="post">
               <div class="form-group">
                <label for="inputName">Tipo Tavolo</label>
               <select name="tipo" class="option">
                  <option value="Carte">Gioco di Carte</option>
                  <option value="Tavolo">Gioco da Tavolo</option>
               
                </select>
              </div>
              <div class="form-group">
                <label for="inputName">Ora</label>
                <select name="ora" class="option">
                  <option value="10:30">10:30</option>
                  <option value="16:30">16:30</option>
                  <option value="18:30">18:30</option>
                </select>
              </div>
              <div class="row">
                <div class="col-12">
                  <input type="submit" value="Aggiungi Tavolo" class="right button">
                </div>
              </div>
              </form>
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