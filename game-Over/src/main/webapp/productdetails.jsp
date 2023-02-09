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
                <title>GameOver|Prodotto</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        </head>

        <body>
                <!--Header-->
                 <%@ include file="includes/header.jsp" %>
                 <br>
                <br>
                <br>
                
                <!---------Single Product Details--------->
		<% String id= request.getParameter("id");
			int i = Integer.parseInt(id);
			VideogiocoBean b = new VideogiocoBean();
			VideogiocoDAO pdao= new VideogiocoDAO();
			b= pdao.doRetriveByKey(i);

                %>
                <div class="card-wrapper">
                        <div class="card-details">
                                <!--card left-->
                                <div class="product-imgs">
                                        <div class="img-display">
                                                <div class="img-showcase">
                                                        <img class="imgproduct" src="<%=b.getImg1() %>" alt="image1">
                                                        <img class="imgproduct" src="<%=b.getImg2() %>" alt="image2">
                                                        <img class="imgproduct" src="<%=b.getImg3() %>" alt="image3">
                                                        <img class="imgproduct" src="<%=b.getImg4() %>" alt="image4">
                                                </div>
                                        </div>
                                        <div class="img-select">
                                                <div class="img-item">
                                                        <a href="#" data-id="1">
                                                                <img class="imgproduct" src="<%=b.getImg1() %>" alt="image1">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="2">
                                                                <img class="imgproduct" src="<%=b.getImg2() %>" alt="image2">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="3">
                                                                <img class="imgproduct" src="<%=b.getImg3() %>" alt="image3">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="4">
                                                                <img class="imgproduct" src="<%=b.getImg4() %>" alt="image4">
                                                        </a>
                                                </div>
                                        </div>
                                </div>
                                <!--card right-->
                                <div class="product-content">
                                        <a href="#" class="product-link">Giochi</a>
                                        <h2 class="product-title"><%=b.getNome() %></h2>
                                        <div class="product-price">
                                                <!--<p class ="last-price">Old Price:<span>$257.00</span></p>-->
                                                <p class="new-price">Prezzo:
                                                        <span class="price">€<%=b.getPrezzo() %></span>
                                                </p>
                                                <div class="purchase-info">
                                                <form action="AddToCartServlet?id=<%=b.getId()%>&action=details" method="post">
                                                        <input type="number" min="1" placeholder="1" name="quantita" required>
                                                        <select name="piattaforma" class="option">
                                                                <option value="PC">PC</option>
                                                                <option value="Console">PlayStation 5</option>
                                                                <option value="Console">Xbox One</option>
                                                        </select>
                                                        <br>
                                                <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                                                        <a href=""><button type="submit" class="btn">
                                                                Aggiungi al carrello<i class="fas fa-shopping-cart"></i>
                                                        </button></a>
                                                        
                                                        <%} %>
                                                         <%if(auth== null) {%>
                                                        <a href=""><button type="submit" class="btn">
                                                                Aggiungi al carrello<i class="fas fa-shopping-cart"></i>
                                                        </button></a>
                                                        
                                                        <%} %>
            
                                                         </form>
                                                         <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==true){  %>
                                                          <a href="catalogo.jsp"><button type="submit" class="btn">
                                                                Vai al Catalogo dei Giochi<i class="fas fa-shopping-cart"></i>
                                                        </button></a>
                                                        <%} %>
                                                </div>
                                        </div>

                                        <div class="product-detail">
                                                <h2>Dettagli prodotto:</h2>
                                                <p><%=b.getDescrizione() %></p>
                                                
                                                <!--<ul>
                                                <li>Piattaforma:<span>PC/Console</span></li>
                                                </ul>-->
                                        </div>
                                </div>-->
                        </div>
                </div>
                </div>
                <!--Footer-->
                
<%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>