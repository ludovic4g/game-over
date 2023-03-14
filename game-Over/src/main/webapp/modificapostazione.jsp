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
	PostazioneBean b = new PostazioneBean();
	PostazioneDAO pdao= new PostazioneDAO();
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
          <label class="collapsible-head" for="collapsible-head">Modifica Informazioni Postazione</label>
          <div class="collapsible-text">
            <div class="card-body">
              <form action="ModificaPostazioneServlet?action=prezzo&id=<%=b.getIdPostazione() %>" method="post">
              <div class="form-group">
                <label for="inputPrice">Prezzo</label>
                <input type="number" id="inputPrice" class="form-control" name="prezzo" placeholder="<%=b.getPrezzo()%>" required>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaPostazioneServlet?action=ora&id=<%=b.getIdPostazione() %>" method="post">
              <div class="form-group">
                <label for="inputName">Ora</label>
                <select name="ora" class="option">
                  <option value="9:30 - 11:30">9:30 - 11:30</option>
                  <option value="14:30 - 16:30">14:30 - 16:30</option>
                  <option value="18:30 - 20:30">18:30 - 20:30</option>
                </select>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
              <form action="ModificaPostazioneServlet?action=disp&id=<%=b.getIdPostazione() %>" method="post">
              <div class="form-group">
                <label for="inputName">Disponibilità</label>
                <select name="disp" class="option">
                  <option value="false">Non Disponibile</option>
                  <option value="true">Disponibile</option>
                </select>
                <div class="row">
                  <div class="col-12">
                    <input type="submit" value="Conferma" class="right button">
                  </div>
                </div>
              </div>
              </form>
               <form action="ModificaPostazioneServlet?action=img&id=<%=b.getIdPostazione() %>" method="post">
                <div class="form-group">
                  <label for="inputProjectLeader">Immagine</label>
                  <input type="link" id="inputName" class="form-control" name="img" required>
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