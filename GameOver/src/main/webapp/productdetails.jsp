<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameOver | Prodotto</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>

<body>
<!-- Header -->
<header>
    <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
            aria-hidden="true">GameOver</span></a>
    <ul class="nav">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="esport.jsp">E-Sport</a></li>
        <li><a href="shopgame.jsp">Games</a></li>
        <li><a href="cart.jsp">Carrello</a></li>
        <li><a href="#">Prenotazioni</a></li>
        <li><a href="#">Ordini</a></li>
        <li><a href="login.jsp">Login</a></li>
    </ul>
    <div class="action">
        <div class="searchBx">
            <a href="#"><i class='bx bx-search'></i></a>
            <input type="text" placeholder="Search Games">
        </div>
    </div>
    <div class="toggleMenu" onclick="toggleMenu();"></div>
</header>
<!--------- Single Product Details --------->
<!-- <div class="small-container single-product">
    <div class="row">
        <div class="col-2">
            <img src="https://upload.wikimedia.org/wikipedia/en/5/5e/Fall_Guys_cover.jpg" width="100%" id="ProductImg">
            <div class="small-img-row">
                <div class="small-img-col">
                    <img src="https://i.postimg.cc/bv0C3Q00/Prodotto-54.png" width="100%" class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="https://tinypic.host/images/2022/09/02/Prodotto_-95.png" width="100%"
                        class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="https://i.postimg.cc/hvv2D6kM/Prodotto-56.png" width="100%" class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="https://i.postimg.cc/j5Z8rtFL/Prodotto-57.png" width="100%" class="small-img">
                </div>
            </div>
        </div>
        <div class="col-2">
            <p>Game</p>
            <h1>Fall Guys</h1>
            <h4>€12,00</h4>
            <select>
                <option>Piattaforma</option>
                <option>PC</option>
                <option>Console</option>
            </select>
            <input type="number" value="1">
            <a href="" class="btn">Aggiungi al carrello</a>
            <h3>Product Details<i class="fa fa-indent"></i></h3>
            <br>
            <strong>Descrizione bracciale</strong>
            <p>Il bracciale è realizzato con pietre di tormalina nera di alta qualità e minuteria placcata argento
                925, e può essere indossato con qualsiasi vestito tutto l'anno.
                Ogni gemma è unica, ricorda che le pietre naturali hanno delle imperfezioni e possono variare di
                colore. Il braccialetto che riceverai potrebbe apparire leggermente diverso di persona rispetto a
                quello nella foto.</p>
        </div>
    </div>
</div> -->
<div class="card-wrapper">
    <div class="card-details">
        <!-- card left -->
        <div class="product-imgs">
            <div class="img-display">
                <div class="img-showcase">
                    <img  class="imgproduct" src="" alt="image1">
                    <img  class="imgproduct" src="" alt="image2">
                    <img  class="imgproduct" src="" alt="image3">
                    <img  class="imgproduct" src="" alt="image4">
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
        <!-- card right -->
        <div class="product-content">
            <a href="#" class="product-link">Giochi</a>
            <h2 class="product-title">Battlefield 2042</h2>
            <!-- <div class = "product-rating">
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star-half-alt"></i>
          <span>4.7(21)</span>
        </div> -->
            <div class="product-price">
                <!-- <p class = "last-price">Old Price: <span>$257.00</span></p> -->
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
                        Aggiungi al carrello <i class="fas fa-shopping-cart"></i>
                    </button>
                </div>
            </div>

            <div class="product-detail">
                <h2>Dettagli prodotto: </h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo eveniet veniam tempora fuga tenetur
                    placeat sapiente architecto illum soluta consequuntur, aspernatur quidem at sequi ipsa!</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur, perferendis eius.
                    Dignissimos, labore suscipit. Unde.</p>
                <!--                     <ul>
                    <li>Piattaforma: <span>PC/Console</span></li>
                </ul> -->
            </div>

            <!-- <div class = "social-links">
          <p>Share At: </p>
          <a href = "#">
            <i class = "fab fa-facebook-f"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-twitter"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-instagram"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-whatsapp"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-pinterest"></i>
          </a>
        </div> -->
        </div>
    </div>
</div>
<!-- Footer -->
<footer>
    <div class="info">
        <a href="#" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                aria-hidden="true">GameOver</span></a>
        <p><i class="bx bx-copyright"></i>2022 All Rights Reserved</p>
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