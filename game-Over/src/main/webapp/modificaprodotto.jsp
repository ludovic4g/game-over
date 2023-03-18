<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
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
    <title>Dashboard Admin|Modifica Prodotto</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="dashboard.css">
  </head>

  <body>
    <!---------SideBar--------->
   <%@ include file="includes/sidebar-admin.jsp" %>
   <!--  -->
   
   <% String id= request.getParameter("id");
	int i = Integer.parseInt(id);
	VideogiocoBean b = new VideogiocoBean();
	VideogiocoDAO pdao= new VideogiocoDAO();
	b= pdao.doRetriveByKey(i);
   %>
    <section class="home-section">
      <div class="home-content">
        <i class='bx bx-menu'></i>
        <span class="text">Benvenuto|Admin Dashboard</span>
      </div>
      <div class="wrapper">
        <div class="collapsible">
          <input class="check" type="checkbox" id="collapsible-head">
          <label class="collapsible-head" for="collapsible-head">Modifica Prodotto</label>
          <div class="collapsible-text">
            <div class="card-body">
            <form action="ModificaGiocoServlet?action=nome&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputName">Nome Prodotto</label>
                <input type="text" id="inputName" class="form-control"  placeholder ="<%=b.getNome() %>" name="nome" required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaGiocoServlet?action=anno&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputName">Anno Prodotto</label>
                <input type="number" id="inputName" class="form-control" name="anno" placeholder=<%=b.getAnno() %> required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
               <form action="ModificaGiocoServlet?action=magazzino&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputName">Quantità in Magazzino</label>
                <input type="number" id="inputName" class="form-control" name="magazzino" placeholder=<%=b.getMagazzino()%> required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaGiocoServlet?action=descrizione&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputDescription">Descrizione Prodotto</label>
                <textarea id="inputDescription" class="form-control" rows="4" name="desc" placeholder="<%=b.getDescrizione()%>" required></textarea>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaGiocoServlet?action=prezzo&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputPrice">Prezzo</label>
                <input type="prezzo" id="inputPrice" class="form-control" name="prezzo" placeholder="<%=b.getPrezzo()%>" required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaGiocoServlet?action=piattaforma&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputName">Piattaforma</label>
                <input type="text" id="inputName" class="form-control" name="magazzino" placeholder=<%=b.getTipo()%> required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaGiocoServlet?action=img&id=<%=b.getId() %>" method="post">
              <div class="form-group">
                <label for="inputProjectLeader">Immagine Principale</label>
                <br>
                <input type="text" id="inputName" class="form-control" name="img1" required>
                <input type="text" id="inputName" class="form-control" name="img2" required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
               </div>
               </form>
               <form action="ModificaGiocoServlet?action=img2&id=<%=b.getId() %>" method="post">
                <div class="form-group">
                  <label for="inputProjectLeader">Immagini Secondarie</label>
                  <input type="text" id="inputName" class="form-control" name="img3" required>
                  <input type="text" id="inputName" class="form-control" name="img4" required>
                  <input type="text" id="inputName" class="form-control" name="img5" required>
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