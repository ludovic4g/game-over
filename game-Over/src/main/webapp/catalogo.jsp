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
                <title>Dashboard Admin|Catalogo Prodotti</title>
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
                <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
                <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
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
                                                <li><a class="link_name" href="dashboard_admin.jsp">Dashboard</a></li>
                                        </ul>
                                </li>
                                <li>
                                        <div class="iocn-link">
                                                <a href="#">
                                                        <i class='bx bx-collection'></i>
                                                        <span class="link_name">Prodotti</span>
                                                </a>
                                                <i class='bx bxs-chevron-down arrow'></i>
                                        </div>
                                        <ul class="sub-menu">
                                                <li><a class="link_name" href="#">Prodotto</a></li>
                                                <li><a href="addproduct.jsp">Aggiungi Prodotto</a></li>
                                                <li><a href="catalogo.jsp">Modifica Prodotto</a></li>
                                                <li><a href="rimuoviprodotto.jsp">Rimuovi Prodotto</a></li>
                                        </ul>
                                </li>
                                <li>
                                <li>
                                        <a href="orderlist.jsp">
                                                <i class='bx bx-cart'></i>
                                                <span class="link_name">Lista Ordini</span>
                                        </a>
                                        <ul class="sub-menu blank">
                                                <li><a class="link_name" href="orderlist.jsp">Ordini</a></li>
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
                        <div class="input-box">
            <input type="text" placeholder="Cerca...">
            <span class="icon">
                <i class="uil uil-search search-icon"></i>
            </span>
            <i class="uil uil-times close-icon"></i>
        </div>
        
                        <div class="card">
                                <div class="card-header">
                                        <h3 class="card-title">Lista Prodotti</h3>
                                        
                                </div>
                                <table>
                                        <tr>
                                                <th></th>
                                                <th>ID Prodotto</th>
                                                <th>Nome Prodotto</th>
                                                <th>Prezzo</th>
                                                <th>Piattaforma</th>
                                                <th></th>
                                        </tr>
                                        <tr>
                                                <td>
                                                        <div class="cart-info">
                                                                <img
                                                                        src="https://i.etsystatic.com/27612067/r/il/f086b9/3983570447/il_794xN.3983570447_95oe.jpg">
                                                        </div>
                                                </td>
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
                                                                        <p>Bracciale tormalina nera grezza</p>
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
                                                <td>
                                                        <div class="cart-info">
                                                                <div>
                                                                        <p>PC</p>
                                                                </div>
                                                        </div>
                                                </td>
                                                <td><a class="btn btn-danger btn-sm" href="#">
                                                                </i>
                                                                Modifica
                                                        </a></td>
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