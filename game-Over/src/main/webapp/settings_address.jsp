<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        HaDAO hdao = new HaDAO();
        ArrayList<IndirizzoBean> indirizzi = hdao.getIndirizziByUsername(auth.getUsername());
        %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard User| Modifica Informazioni Profilo</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="dashboard.css">
  </head>

  <body>
    <!---------SideBar--------->
    <%@ include file="includes/sidebar-user.jsp" %>
    <!--  -->
    <section class="home-section">
      <div class="home-content">
        <i class='bx bx-menu'></i>
        <span class="text">Benvenuto|User Dashboard</span>
      </div>
      <% for(IndirizzoBean b : indirizzi){
      int i=0;%>
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
      
          <label class="collapsible-head" for="collapsible-head">Modifica Indirizzo (<%out.println(++i); %>)</label>
          <div class="collapsible-text">
            <div class="card-body">
             <form action="ModificaInfoServlet?action=indirizzo&id=<%=auth.getUsername()%>&add=<%=b.getId() %>&num=<%=i %>&det=dashboard" method="post">
              <div class="form-group">
                <label for="inputName">Nome e Cognome</label>
                <input type="text" id="inputName"  name="nomeind" class="form-control" placeholder="<%=auth.getNome()%> <%=auth.getCognome()%>" required>
                <small class="error_input">Errore Nome e/o Cognome - Formato non valido</small>
              </div>
              <div class="form-group">
                <label for="inputPrice">Città</label>
                <input type="text" id="inputName" name="citta" class="form-control"  placeholder="<%=b.getCitta()%>" required>
                <small class="error_input">Errore Città - Formato non valido</small>
                </div>
              <div class="form-group">
                <label for="inputPrice">Provincia</label>
                <input type="text" id="inputName" name="provincia" class="form-control"  placeholder="<%=b.getProvincia ()%>" required>
                <small class="error_input">Errore Provincia - Formato non valido</small>

              </div>
              <div class="form-group">
                <label for="inputPrice">CAP</label>
                <input type="text" id="inputName" name="cap" class="form-control" placeholder="<%=b.getCAP()%>" required>
                <small class="error_input">Errore CAP - Formato non valido</small>

              </div>
              <div class="form-group">
                <label for="inputPrice">Indirizzo</label>
                <input type="text" id="inputName"  name="via" class="form-control"  placeholder="<%=b.getVia()%>" required>
                <small class="error_input">Errore Indirizzo - Formato non valido</small>
				<div class="row">
                    <div class="col-12">
                      <input type="submit" value="Conferma" class="right button">
                      </div>
                      </div>
              </div>
              </form>
              </div>
            </div>
          </div>
        </div>
        <%} %>
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