<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                                        <input type="number" min="1" value="1">
                                                        <select name="piattaforma" class="option">
                                                                <option value="PC">PC</option>
                                                                <option value="PC">PlayStation 5</option>
                                                                <option value="PC">Xbox One</option>
                                                        </select>
                                                        <br>
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
                                </div>-->
                        </div>
                </div>
                </div>
                <!--Footer-->
                <footer>
                        <div class="info">
                                <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                                                aria-hidden="true">GameOver</span></a>
                                <p><i class="bx bx-copyright"></i>2022All Rights Reserved</p>
                                <ul>
                                        <li><a href=""><i class="bx bxl-facebook"></i></a></li>
                                        <li><a href=""><i class="bx bxl-instagram"></i></a></li>
                                        <li><a href=""><i class="bx bxl-twitter"></i></a></li>
                                        <li><a href=""><i class="bx bxl-youtube"></i></a></li>
                                </ul>
                        </div>
                </footer>
                <script src="scripts/script.js"></script>
        </body>

        </html>