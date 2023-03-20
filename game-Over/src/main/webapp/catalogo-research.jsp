<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
    ArrayList<VideogiocoBean> games = (ArrayList<VideogiocoBean>) request.getSession().getAttribute("lista1");
    ArrayList<PostazioneBean> post = (ArrayList<PostazioneBean>) request.getSession().getAttribute("lista2");
    ArrayList<TavoloBean> tavs = (ArrayList<TavoloBean>) request.getSession().getAttribute("lista3");
       
     
     
        %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dashboard Admin|Catalogo Prodotti</title>
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
                                <span class="text">Ricerca prodotto</span>
                                
                        </div>
                        <div class="input-box">
                        <br>
                        <form action ="RicercaCatalogoServlet" method="post">
            <input type="text" placeholder="Cerca..." name="cerca">
            <span class="icon">
                <i class="uil uil-search search-icon"></i>
            </span>
            <i class="uil uil-times close-icon"></i>
            </form>
        </div>
        
                        <div class="card">
                                <div class="card-header">
                                        <h3 class="card-title">Lista Prodotti</h3>
                                        
                                </div>
                                <table>
                                <%if(!games.isEmpty()){ %>
                                        <tr>
                                                <th></th>
                                                <th>ID Prodotto</th>
                                                <th>Nome Prodotto</th>
                                                <th>Prezzo</th>
                                                <th>Piattaforma</th>
                                                <th></th>
                                        </tr>
                                        
                                        <%
                                        for(VideogiocoBean b : games){ %>
                                        <tr>
                                                <td>
                                                        <div class="cart-info">
                                                                <img
                                                                        src="<%=b.getImg1()%>">
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getId() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getNome() %> (<%=b.getAnno() %>)</p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p>€<%=b.getPrezzo() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getTipo() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td><a class="btn btn-danger btn-sm" href="modificaprodotto.jsp?id=<%=b.getId()%>">
                                                                </i>
                                                                Modifica
                                                        </a></td>
                                                        <tr>
                                                        <%} 
                                                        }%>
                                        </tr>
                                        
                                        <table>
                                        <%if(!post.isEmpty()){ %>
                                        <div class="card2">
                                         <div class="card-header2">
                                        <h3 class="card-title2">Lista Postazioni</h3>
                                        
                                </div>
                                         <table>
                                        <tr>
                                                <th></th>
                                                <th>ID Postazione</th>
                                                <th>Ora</th>
                                                <th>Prezzo</th>
                                                <th>Disponibilità</th>
                                                <th></th>
                                        </tr>
                                        
                                        <%
                                        for(PostazioneBean b : post){ %>
                                        <tr>
                                                <td>
                                                        <div class="cart-info">
                                                                <img
                                                                        src="<%=b.getImg()%>">
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getIdPostazione() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getOra() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p>€<%=b.getPrezzo() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%if(b.isDisp()) {
                                                                        	out.println("Disponibile");
                                                                        }
                                                                        else out.println("Non Disponibile");%></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td><a class="btn btn-danger btn-sm" href="modificapostazione.jsp?id=<%=b.getIdPostazione() %>">
                                                                </i>
                                                                Modifica
                                                        </a></td>
                                                        <tr>
                                                        <%} 
                                                        }%>
                                        </tr>
                                         
                                        <table>
                                        <%if(!tavs.isEmpty()){ %>
                                        <div class="card2">
                                         <div class="card-header2">
                                      
                                        <h3 class="card-title2">Lista Tavoli</h3>
                                        
                                </div>
                                         <table>
                                        <tr>
                                                <th></th>
                                                <th>ID Postazione</th>
                                                <th>Numero Posti</th>
                                                <th>Prezzo Posto</th>
                                                <th>Ora</th>
                                                <th>Tipo</th>
                                                <th>Disponibilità</th>
                                                <th></th>
                                        </tr>
                                        
                                        <%
                                        for(TavoloBean b : tavs){ %>
                                        <tr>
                                                <td>
                                                        <div class="cart-info">
                                                                <img
                                                                        src="<%=b.getImg()%>">
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getIdTavolo() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getNumeroPosti() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p>€<%=b.getPrezzoPosto()%></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getOra() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                 <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%=b.getTipo() %></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p><%if(b.isDisp()) {
                                                                        	out.println("Disponibile");
                                                                        }
                                                                        else out.println("Non Disponibile");%></p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td><a class="btn btn-danger btn-sm" href="modificatavolo.jsp?id=<%=b.getIdTavolo() %>">
                                                                </i>
                                                                Modifica
                                                        </a></td>
                                                        <tr>
                                                        <%}
                                        }%>
                                        </tr>
                                        
                                        
                                        
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