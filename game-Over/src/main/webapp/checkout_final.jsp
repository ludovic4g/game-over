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
        %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GameOver|Checkout</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    </head>

    <body>
        <!--Header-->
        <%@ include file="includes/header.jsp" %>
        <!--Checkout-->
		        <div class="container_checkout">

            <div class="card-container_checkout">
    
                <div class="front">
                    <div class="image">
                        <img src="images/chip.png" alt="">
                        <img src="images/visa.png" alt="">
                    </div>
                    <div class="card-number-CheckOut">################</div>
                    <div class="flexCheckOut">
                        <div class="CheckOut">
                            <span>Intestatario</span>
                            <div class="card-holder-name">Nome Completo</div>
                        </div>
                        <div class="CheckOut">
                            <span class="deadline">Scadenza</span>
                            <div class="expiration">
                                <span class="exp-month">mm</span>
                                <span class="exp-year">yy</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="back">
                    <div class="stripe"></div>
                    <div class="CheckOut">
                        <span>CVV</span>
                        <div class="cvv-CheckOut"></div>
                        <img src="images/visa.png"  class="cvv-chip">
                    </div>
                </div>
            </div>
            <div class="total-price_checkout">
                    <table class="checkout_table">
                        <tr>
                            <td class="subtitle-checkout">Subtotal</td>
                            <td class="subtotal-product-price-checkout">$200.00</td>
                        </tr>
                        <tr>
                            <td class="subtitle-checkout">Tax</td>
                            <td class="tax-product-price-checkout">$35.00</td>
                        </tr>
                        <tr>
                            <td class="subtitle-checkout">Totale</td>
                            <td class="total-product-price-checkout">$230,00</td>
                        </tr>
                    </table>
                </div>             
            <form action="">
                <div class="inputCheckOut">
                    <span class="span_checkout">Numero Carta</span>
                    <input type="text" maxlength="16" class="card-number-input">
                </div>
                <div class="inputCheckOut">
                    <span class="span_checkout">Nome Completo</span>
                    <input type="text" maxlength="40"class="card-holder-input">
                </div>
                <div class="flexCheckOut">
                    <div class="inputCheckOut">
                        <span class="span_checkout">Mese di scadenza</span>
                        <select name="" id="" class="month-input">
                            <option value="month" selected disabled>Mese</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                    <div class="inputCheckOut">
                        <span class="span_checkout">Anno di scadenza</span>
                        <select name="" id="" class="year-input">
                            <option value="year" selected disabled>Anno</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                            <option value="2027">2027</option>
                            <option value="2028">2028</option>
                            <option value="2029">2029</option>
                            <option value="2030">2030</option>
                        </select>
                    </div>
                    <div class="inputCheckOut">
                        <span class="span_checkout">CVV</span>
                        <input type="text" maxlength="3" class="cvv-input">
                    </div>
                </div>
                <input type="submit" value="Procedi all'acquisto" class="submit-btn">
            </form>
    
        </div>    
        <!--Footer-->
        <%@ include file="includes/footer.jsp" %>
        <script src="scripts/anime.min.js"></script>
        <script src="scripts/script.js"></script>
        <script>
        document.querySelector('.card-number-input').oninput = () => {
            document.querySelector('.card-number-CheckOut').innerText = document.querySelector('.card-number-input').value;
        }

        document.querySelector('.card-holder-input').oninput = () => {
            document.querySelector('.card-holder-name').innerText = document.querySelector('.card-holder-input').value;
        }

        document.querySelector('.month-input').oninput = () => {
            document.querySelector('.exp-month').innerText = document.querySelector('.month-input').value;
        }

        document.querySelector('.year-input').oninput = () => {
            document.querySelector('.exp-year').innerText = document.querySelector('.year-input').value;
        }

        document.querySelector('.cvv-input').onmouseenter = () => {
            document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(-180deg)';
            document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(0deg)';
        }

        document.querySelector('.cvv-input').onmouseleave = () => {
            document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(0deg)';
            document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(180deg)';
        }

        document.querySelector('.cvv-input').oninput = () => {
            document.querySelector('.cvv-CheckOut').innerText = document.querySelector('.cvv-input').value;
        }
        </script>
    </body>

    </html>