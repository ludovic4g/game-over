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
                <title>GameOver|Prodotto</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        </head>

        <body>
                <!--Header-->
                <%@ include file="includes/header.jsp" %>
                <!---------Single Product Details--------->
                <div class="card-wrapper">
                        <div class="card-details">
                                <!--card left-->
                                <div class="product-imgs">
                                        <div class="img-display">
                                                <div class="img-showcase">
                                                        <img class="imgproduct" src="" alt="image1">
                                                        <img class="imgproduct" src="" alt="image2">
                                                        <img class="imgproduct" src="" alt="image3">
                                                        <img class="imgproduct" src="" alt="image4">
                                                </div>
                                        </div>
                                        <div class="img-select">
                                                <div class="img-item">
                                                        <a href="#" data-id="1">
                                                                <img class="imgproduct" src="" alt="image1">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="2">
                                                                <img class="imgproduct" src="" alt="image2">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="3">
                                                                <img class="imgproduct" src="" alt="image3">
                                                        </a>
                                                </div>
                                                <div class="img-item">
                                                        <a href="#" data-id="4">
                                                                <img class="imgproduct" src="" alt="image4">
                                                        </a>
                                                </div>
                                        </div>
                                </div>
                                <!--card right-->
                                <div class="product-content">
                                        <a href="#" class="product-link">Giochi</a>
                                        <h2 class="product-title">Battlefield 2042</h2>
                                        <div class="product-price">
                                                <!--<p class ="last-price">Old Price:<span>$257.00</span></p>-->
                                                <p class="new-price">Prezzo:
                                                        <span class="price">$249.00</span>
                                                </p>
                                                <div class="purchase-info">
                                                        <select name="piattaforma" class="option">
                                                                <option value="Default">Orario</option>
                                                                <option value="Clock">17:30</option>
                                                                <option value="Clock">18:30</option>
                                                        </select>
                                                        <br>
                                                        <br>
                                                        <select name="posti" class="option">
                                                                <option value="Default">Posti</option>
                                                                <option value="Posti">2</option>
                                                                <option value="Posti">3</option>
                                                                <option value="Posti">4</option>
                                                                <option value="Posti">5</option>
                                                                <option value="Posti">6</option>
                                                                <option value="Posti">7</option>
                                                                <option value="Posti">8</option>
                                                                <option value="Posti">9</option>
                                                                <option value="Posti">10</option>
                                                        </select>
                                                        <button type="button" class="btn">
                                                                Aggiungi al carrello<i class="fas fa-shopping-cart"></i>
                                                        </button>
                                                </div>
                                        </div>

                                        <div class="product-detail">
                                                <h2>Dettagli prodotto:</h2>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.Illo eveniet
                                                        veniam tempora fuga tenetur
                                                        placeat sapiente architecto illum soluta consequuntur,aspernatur
                                                        quidem at sequi ipsa!</p>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                        elit.Consequatur,perferendis eius.
                                                        Dignissimos,labore suscipit.Unde.</p>
                                                <!--<ul>
                                                <li>Piattaforma:<span>PC/Console</span></li>
                                                </ul>-->
                                        </div>
                                </div>
                        </div>
                </div>
                <!--Footer-->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
        </body>

        </html>