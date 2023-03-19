<%@ page import= "utente.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        UtenteDAO udao = new UtenteDAO();
        HaDAO hdao = new HaDAO();
        ArrayList<HaBean> ha = hdao.doRetrieveByUsername(auth.getUsername());
        %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard User|Modifica Informazioni Profilo</title>
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
        <span class="text">Modifica Informazioni Profilo</span>
      </div>
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
          <label class="collapsible-head" for="collapsible-head">Modifica Informazioni Profilo</label>
          <div class="collapsible-text">
            <div class="card-body">
            <form action="ModificaInfoServlet?action=nome&id=<%=auth.getUsername()%>" method="post">
              <div class="form-group">
                <label for="inputName">Nome</label>
                <input type="text" id="inputName" name="nome" class="form-control" placeholder="<%=auth.getNome()%>" required>
                <small class="error_input">Errore Nome - Non valido</small>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaInfoServlet?action=cognome&id=<%=auth.getUsername()%>" method="post">
              <div class="form-group">
                <label for="inputName">Cognome</label>
                <input type="text" id="inputName" name="cognome" class="form-control" placeholder="<%=auth.getCognome()%>" required>
                <small class="error_input">Errore Cognome - Non valido</small>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaInfoServlet?action=ddn&id=<%=auth.getUsername()%>" method="post">
              <div class="form-group">
                <label for="inputDescription">Data di nascita</label>
                <input type="date" name="ddn" class="setting_date" placeholder="<%=auth.getBday() %>" required>
                <small class="error_input">Errore Data - Seleziona una data</small>
                <small class="error_input">Errore Data - Seleziona una data valida</small>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaInfoServlet?action=gender&id=<%=auth.getUsername()%>" method="post">
              <div class="form-group">
                <label for="inputPrice">Genere</label>
                <select name="gender" class="option" >
                <option value="" disabled selected><%=auth.getSex() %></option>
                  <option value="//">Preferisco non specificarlo</option>
                  <option value="male">Maschio</option>
                  <option value="woman">Femmina</option>
                </select>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaInfoServlet?action=mail&id=<%=auth.getUsername()%>" method="post">
                <div class="form-group">
                  <label for="inputProjectLeader">E-mail</label>
                  <input type="email" id="inputName" name="mail" class="form-control" placeholder="<%=auth.getEmail() %>"required>
                  <small class="error_input">Errore Email - Non Valida</small>
                  <small class="error_input">Errore Email - Già esistente</small>
                  <div class="row">
                    <div class="col-12">
                      <input type="submit" value="Conferma" class="right button">
                    </div>
                  </div>
                </div>
                </form>
             <form action="ModificaInfoServlet?action=domanda&id=<%=auth.getUsername()%>" method="post">
                <div class="form-group">
                  <label for="inputProjectLeader">Domanda di Sicurezza</label>
                            <select name="domanda " class="form-control" required>
                               <option value="" disabled selected></option>
                               <option>Citta' preferita</option>
                                <option>Nome dell’amico del cuore</option>
                                <option>Qual'era il cognome da nubile di tua madre?</option>
                                <option>Il nome del tuo primo animale domestico</option>
                            </select>
                </div>
                </form>
                 <form action="ModificaInfoServlet?action=risposta&id=<%=auth.getUsername()%>" method="post">
                <div class="form-group">
                  <label for="inputProjectLeader">Risposta</label>
                  <input type="text" id="inputName" name="risposta" class="form-control">
                  <small class="error_input">Errore Risposta - Formato non valido</small>
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