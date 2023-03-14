<%@ page import= "utente.model.*" %>
<%@ page import= "java.text.*" %>
<%@ page import= "gestorepren.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
       PrenotazioneDAO pdao = new PrenotazioneDAO();
       ArrayList<PrenotazioneBean> prenotazioni = pdao.doRetrieveAll();
        
        %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard Admin|Prenotazioni</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
  <link rel="stylesheet" href="dashboard.css">
</head>

<body>
<!---------SideBar--------->
<%@ include file="includes/sidebar-admin.jsp" %>
<!--  -->
<section class="home-section">
  <div class="home-content">
    <i class='bx bx-menu'></i>
    <span class="text">Benvenuto|Admin Dashboard</span>
  </div>
  <div class="input-box">
                        <form action ="RicercaCatalogoServlet" method="post">
            <input type="text" placeholder="Cerca..." name="cerca">
            <span class="icon">
                <i class="uil uil-search search-icon"></i>
            </span>
            <i class="uil uil-times close-icon"></i>
            </form>
        </div>
        
        <div class="filter_container"> 
        <div class="filter_title">Filtra per utente</div>
     <form action ="FiltraPrenotazioniServlet?action=alfabetico" method="post">   
        <select id="sort-users" name="tipo">
        <option selected="selected">-</option>
  <option value="az">Utenti dalla A-Z</option>
  <option value="za">Utenti dalla Z-A</option>
</select>
<button type="submit" class="btn btn-danger btn-sm">-></button>
</form>
<form action ="FiltraPrenotazioniServlet?action=data" method="post">
<div class="filter_title">Data da:</div>
<input class="data_filter" type="date" id="sort-date" name="inizio">
<div class="filter_title">Data a:</div>
<input class="data_filter" type="date" id="sort-date" name="fine">
<button type="submit" class="btn btn-danger btn-sm">-></button>
</form>
</div>
  <div class="card">
    <div class="card-header">
      <h3 class="card-title">Gestisci Prenotazione</h3>
    </div>
    
    <table>
    <%for(PrenotazioneBean b : prenotazioni){ %>
      <tr>
        <th>ID Prenotazione</th>
        <th>Utente</th>
        <th>Data</th>
        <th>Prezzo</th>
        <th>Posti Prenotati</th>
        <th>Orario</th>
        <th>Stato</th>
      </tr>
      <tr>
        <td>
          <div class="cart-info">
            <div>
              <p><%=b.getIdPrenotazione() %></p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p><%=b.getUtente() %></p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p><%Format f = new SimpleDateFormat("dd/MM/yy");
              String strDate = f.format(b.getDataprenotazione()); 
              out.print(strDate);%></p>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p>€<%=b.getPrezzo() %></p>
              <h5>Prezzo per posto: <%out.println(b.getPrezzo()/b.getPostiPrenotati()); %></h5>
            </div>
          </div>
        </td>
        <td>
          <div class="cart-info">
            <div>
              <p><%=b.getPostiPrenotati() %></p>
            </div>
          </div>
        </td>
        <td><div class="cart-info">
            <div>
              <p><%=b.getOra() %></p>
            </div>
          </div></td>
          <td>
          <%if(b.getStato().equals("Annullato")){ %>
         <td><select class="stato" name="stato"  required>
        	<option value="" disabled selected>Annullato</option> </select>
         <%}else{ %>
          <td><form action="ModificaOrdineServlet?id=<%=b.getIdPrenotazione()%>" method="post">
        <td><select class="stato" name="stato"  required>
        	<option value="" disabled selected><%=b.getStato() %></option>
          <option value="In attesa di Conferma">In attesa di conferma</option>
          <option value="Confermato">Confermato</option>
          <option value="Annullato">Annullato</option>
        </select>
        <td><input type="submit" class="btn btn-danger btn-sm" value ="Modifica"></td>
        </form>
        </td>
  <%} %>
      </tr>
      </tr>
      <%}%>
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