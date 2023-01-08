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
        <title>GameOver|Prenotazioni</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>

    <body>
        <!--Header-->
         <%@ include file="includes/header.jsp" %>
        <!--Carrello-->
        <div class="containercart">
            <h2 class="title-page">Prenotazioni</h2>
            <div class="small-container cart-page">
                <table>
                    <tr class="column">
                        <th>Prodotti</th>
                        <th>Stato</th>
                        <th>Orario</th>
                        <th>N.A Sedere</th>
                        <th>Prezzo</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/27612067/r/il/f086b9/3983570447/il_794xN.3983570447_95oe.jpg">
                                <div class="resume">
                                    <p>Bracciale tormalina nera grezza</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/14246453/r/il/e0aa81/1218440768/il_794xN.1218440768_5k5u.jpg">
                                <div class="resume">
                                    <p>Pietra di luna</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">Annulla</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/6829831/r/il/d912d3/3255563537/il_794xN.3255563537_75og.jpg">
                                <div class="resume">
                                    <p>Anello in Quarzo Rosa</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/6829831/r/il/d912d3/3255563537/il_794xN.3255563537_75og.jpg">
                                <div class="resume">
                                    <p>Anello in Quarzo Rosa</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/6829831/r/il/d912d3/3255563537/il_794xN.3255563537_75og.jpg">
                                <div class="resume">
                                    <p>Anello in Quarzo Rosa</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/6829831/r/il/d912d3/3255563537/il_794xN.3255563537_75og.jpg">
                                <div class="resume">
                                    <p>Anello in Quarzo Rosa</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cart-info">
                                <img
                                    src="https://i.etsystatic.com/6829831/r/il/d912d3/3255563537/il_794xN.3255563537_75og.jpg">
                                <div class="resume">
                                    <p>Anello in Quarzo Rosa</p>
                                    <br>
                                    <a class="remove" href="">Annulla</a>
                                </div>
                            </div>
                        </td>
                        <td class="state">Confermato</td>
                        <td class="clock">17:30</td>
                        <td class="quantity">1</td>
                        <td class="product-price">$50.00</td>
                    </tr>
                </table>
            </div>
        </div>
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
        <script src="scripts/script.js"></script>
    </body>

    </html>