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
  <title>Dashboard Admin|Ordini</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
  <link rel="stylesheet" href="dashboard.css">
</head>

<body>
<!---------SideBar--------->
<%@ include file="includes/sidebar-admin.jsp" %>
<!-- - -->
<section class="home-section">
  <div class="home-content">
    <i class='bx bx-menu'></i>
    <span class="text">Benvenuto|Admin Dashboard</span>
  </div>
  <div class="input-box">
            <input type="text" placeholder="Cerca...">
            <span class="icon">
                <i class="uil uil-search search-icon"></i>
            </span>
            <i class="uil uil-times close-icon"></i>
        </div>
        
        <div class="filter_container"> 
        <div class="filter_title">Filtra per utente</div>
        <select id="sort-users">
        <option selected="selected">-</option>
  <option value="az">Utenti dalla A-Z</option>
  <option value="za">Utenti dalla Z-A</option>
</select>
<div class="filter_title">Data da:</div>
<input class="data_filter" type="date" id="sort-date">
<div class="filter_title">Data a:</div>
<input class="data_filter" type="date" id="sort-date">
</div>
  <div class="card">
    <div class="card-header">
      <h3 class="card-title">Lista Prenotazioni</h3>
    </div>
    
    <table>
      <tr>
        <th>N. Ordine</th>
        <th>Utente</th>
        <th>Data</th>
        <th>Totale</th>
        <th>Stato</th>
      </tr>
      <tr>
        <td>
          <div class="cart-info">
            <div>
              <p>100</p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p>Tizio</p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p>DD/MM/YY</p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p>9,99$</p>
            </div>
          </div>
        </td>
        <td><select class="stato">
          <option value="" selected="selected">Stato di conferma</option>
          <option value="">Spedito</option>
          <option value="">In fase di consegna</option>
        </select></td>
        </td>
        <td><a class="btn btn-danger btn-sm" href="#">
          </i>
          Modifica
        </a></td>
      </tr>
      </tr>
    </table>
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
  /* Js For Animated Search Bar Open/Close */
  let inputBox = document.querySelector(".input-box"),
  searchIcon = document.querySelector(".icon"),
  closeIcon = document.querySelector(".close-icon");

searchIcon.addEventListener("click", () => inputBox.classList.add("open"));
closeIcon.addEventListener("click", () => inputBox.classList.remove("open"));
</script>
</body>

</html>