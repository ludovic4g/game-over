<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
        request.setAttribute("auth", auth);
        }
        
        VideogiocoDAO vdao = new VideogiocoDAO();
        ArrayList<VideogiocoBean> lista = vdao.doRetrieveAll();
        
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
            <h2>Games</h2>
            <ul>
                <li class="list active" data-filter="all">All</li>
                <li class="list" data-filter="pc">Pc Games</li>
                <li class="list" data-filter="console">Console Games</li>
            </ul>
            
            <%if(!lista.isEmpty()){
		    		for(VideogiocoBean b: lista){ 
		    			
		    		%>
            <div class="cardBx">
                <div class="card" data-item="all">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4><%=b.getNome()%></h4>
                        <p class="price">Pricing<span> €<%=b.getPrezzo()%></span></p>
                        <div class="info">
                    <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <%} %>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>              
            </div>
            <%}
		                }%>
            
            <%if(!lista.isEmpty()){
		    		for(VideogiocoBean b: lista){
		    			if(b.getTipo().equals("Console")){%>
            <div class="cardBx">
                <div class="card" data-item="console">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4><%=b.getNome()%></h4>
                        <p class="price">Pricing<span> €<%=b.getPrezzo()%></span></p>
                        <div class="info">
                         <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <%} %>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>              
            </div>
            <%}
		    		}
            }%>
            
            <%if(!lista.isEmpty()){
		    		for(VideogiocoBean b: lista){
		    			if(b.getTipo().equals("PC")){%>
            <div class="cardBx">
                <div class="card" data-item="pc">
                    <img src="game1.png" alt="">
                    <div class="content">
                        <h4><%=b.getNome()%></h4>
                        <p class="price">Pricing<span> €<%=b.getPrezzo()%></span></p>
                        <div class="info">
                         <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                            <a href="AddToCartServlet?id=<%=b.getId()%>&action=lista"><i class='bx bx-cart-add'></i></a>
                            <%} %>
                            <a href="productdetails.jsp?id=<%=b.getId()%>">Dettagli</a>
                        </div>
                    </div>
                </div>              
            </div>
            <%}
		    		}
            }%>
        </div>
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
       
        <script src="scripts/script.js"></script>
    </body>

    </html>