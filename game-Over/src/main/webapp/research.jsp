<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page import="java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth", auth);
    }
    String cerca = (String) request.getSession().getAttribute("cerca");
    if(cerca!=null){
        request.setAttribute("cerca", cerca);
    }
    
    ArrayList<VideogiocoBean> games = (ArrayList<VideogiocoBean>) request.getSession().getAttribute("lista");
    

%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Giochi</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    </head>

    <body>
        <!--Header-->
        <%@ include file="includes/header.jsp" %>
        <br>
        <!--Games-->
        <div class="games animeX" id="games">
        <%if(games.isEmpty()){ %>
        <h2>Nessun risultato trovato.</h2>
        <%} else{%>
            <h2><%= "Risultati per '"+ cerca + "'" %>  </h2>
            <div class="cardBx">
            <%for(VideogiocoBean b : games){ %>
                <div class="card" data-item="console">
                    <img src="<%=b.getImg1() %>" alt="<%=b.getImg2()%>">
                    <div class="content">
                        <h4><%=b.getNome() %></h4>
                        <p class="price">Pricing<span>€<%=b.getPrezzo() %></span></p>
                        <div class="info">
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>
                <%}
            }%>
            </div>
        </div>
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
        <script src="scripts/script.js"></script>
    </body>

    </html>