<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                request.setAttribute("auth", auth);
        }
        
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        ArrayList<VideogiocoBean> games =null;
        
        if(carrello== null){
        	carrello = new Carrello();
        }
        boolean ctrl= carrello==null;
        games= carrello.getGames();
        request.setAttribute("carrello", carrello);
        
        HaDAO hdao = new HaDAO();
        ArrayList<IndirizzoBean> indirizzi = hdao.getIndirizziByUsername(auth.getUsername());
        request.setAttribute("indirizzi", indirizzi);
        
        
        %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameOver</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <!-- Header -->
    <%@ include file="includes/header.jsp" %>
    <!-- ---------------------- -->
    <div class="container_address">
        <div class="box_address" id="box-address">
        <div class="address_form">
         <%for(IndirizzoBean b : indirizzi){ %>
            <div class="center">
                <div class="address-box">
                    <p class="address_title">Indirizzo : <%=b.getVia() %><span style="float: right;position: relative;top: 15px;">
                            <input type="checkbox" id="address-checkbox" name="address-checkbox" value= <%=b.getId()%>>
                        </span></p>
                    <button id="show-address">Modifica</button>
                </div>
            </div>
            <% }%>
            <div class="center">
                <div class="address-box">
                    <button id="add-address">+ Aggiungi Indirizzo</button>
                </div>
                
            </div>
            <button class="address-box-submit">Avanti</button>
        </div>
</div>
        <div class="popup">
            <div class="close-btn">&times;</div>
           <!--   <form action="AddAddressServlet" method="post"> -->
            <div class="form">
                <h2>Indirizzo</h2>
                <div class="form-element">
                    <label for="email">Nome</label>
                    <input type="text" id="email" name="nome">
                </div>
                <div class="form-element">
                    <label for="email">Cognome</label>
                    <input type="text" id="email" name="cognome">
                </div>
                <div class="form-element">
                    <label for="email">Città</label>
                    <input type="text" id="email" name="citta">
                </div>
                <div class="form-element">
                    <label for="email">Paese</label>
                    <input type="text" id="email" name="paese">
                </div>
                <div class="form-element">
                    <label for="email">Provincia</label>
                    <input type="text" id="email" name="provincia">
                </div>
                <div class="form-element">
                    <label for="email">CAP</label>
                    <input type="text" id="email" name="cap">
                </div>
                <div class="form-element">
                    <label for="email">Indirizzo</label>
                    <input type="text" id="email" name="indirizzo">
                </div>
                <div class="form-element">
                    <label for="email">Telefono</label>
                    <input type="text" id="email" name="telefono">
                </div>
                <button class="address-submit">Conferma</button>
            </div>
           
        </div>
        <div class="popup_add">
            <div class="close-btn">&times;</div>
            <div class="form">
                <h2>Aggiungi Indirizzo</h2>
                <div class="form-element">
                    <label for="email">Nome</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Cognome</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Città</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Paese</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Provincia</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">CAP</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Indirizzo</label>
                    <input type="text" id="email">
                </div>
                <div class="form-element">
                    <label for="email">Telefono</label>
                    <input type="text" id="email">
                </div>
                <button class="address-submit">Conferma</button>
            </div>
            
        </div>
    </div>
     <%@ include file="includes/footer.jsp" %>
    <script>
        document.querySelector("#show-address").addEventListener("click", function () {
            document.querySelector(".popup").classList.add("active");
            document.querySelector("#box-address").style.display = "none";
        })
        document.querySelector(".popup .close-btn").addEventListener("click", function () {
            document.querySelector(".popup").classList.remove("active");
            document.querySelector("#box-address").style.display = "block";
        })
        document.querySelector("#show-address2").addEventListener("click", function () {
            document.querySelector(".popup").classList.add("active");
            document.querySelector("#box-address").style.display = "none";
        })
        document.querySelector(".popup .close-btn").addEventListener("click", function () {
            document.querySelector(".popup").classList.remove("active");
            document.querySelector("#box-address").style.display = "block";
        })
        document.querySelector("#show-address3").addEventListener("click", function () {
            document.querySelector(".popup").classList.add("active");
            document.querySelector("#box-address").style.display = "none";
        })
        document.querySelector(".popup .close-btn").addEventListener("click", function () {
            document.querySelector(".popup").classList.remove("active");
            document.querySelector("#box-address").style.display = "block";
        })
        document.querySelector("#add-address").addEventListener("click", function () {
            document.querySelector(".popup_add").classList.add("active");
            document.querySelector("#box-address").style.display = "none";
        })
        document.querySelector(".popup_add .close-btn").addEventListener("click", function () {
            document.querySelector(".popup_add").classList.remove("active");
            document.querySelector("#box-address").style.display = "block";
        })
    </script>
    <script src="scripts/anime.min.js"></script>
    <script src="scripts/script.js"></script>