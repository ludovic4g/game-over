<%@ page import="utente.model.*" %>
  <%@ page import="java.util.ArrayList" %>
    <%@ page import="connection.*" %>
      <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <% UtenteBean auth=(UtenteBean) request.getSession().getAttribute("auth"); if(auth!=null){
          request.setAttribute("auth", auth); } %>
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
              <!---------seat Select--------->
              <div class="bodycontain">
                <div class="type-container">
                  <label> Seleziona il tipo di Postazione: </label>
                  <select id="type">
                    <option value="10">PC ( 10 €)</option>
                    <option value="8">PlayStation 5 ( 8 €)</option>
                    <option value="8">XBox One ( 8 €)</option>
                  </select>
                </div>

                <div class="clock-container">
                  <label> Seleziona fascia oraria: </label>
                  <select id="clock">
                    <option>9:30 - 11:30</option>
                    <option>14:30 - 16:30</option>
                    <option>18:30 - 20:30</option>
                  </select>
                </div>
                <br>
                <br>
                <ul class="showcase">
                  <li>
                    <div class="seat"></div>
                    <small>Available</small>
                  </li>
                  <li>
                    <div class="seat selected"></div>
                    <small>Selected</small>
                  </li>
                  <li>
                    <div class="seat sold"></div>
                    <small>Sold</small>
                  </li>
                </ul>
                <div class="container">
                  <div class="row">
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                  </div>
                  <div class="row">
                   	<br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                  </div>
                  <div class="row">
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                  </div>
                  <div class="row">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                  </div>
                  <div class="row">
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat sold"></div>
                    <div class="seat"></div>
                  </div>
                </div>
                <p class="text">
                <div class="warning">Il totale viene calcolato nel CARRELLO!!</div>
                </p>
                <p class="text">
                  Hai selezionato <span id="count">0</span> postazione prezzo totale <span id="total">0</span>€
                </p>
                <a href="AddToCartServlet"><button type="button" class="btn">
                    Aggiungi al carrello<i class="fas fa-shopping-cart"></i>
                  </button></a>
              </div>
              <!--Footer-->
              <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
                <script>

                  const container = document.querySelector(".container");
                  const seats = document.querySelectorAll(".row .seat:not(.sold)");
                  const count = document.getElementById("count");
                  const total = document.getElementById("total");
                  const typeSelect = document.getElementById("type");

                  populateUI();

                  let ticketPrice = +typeSelect.value;

                  // Save selected type index and price
                  function settypeData(typeIndex, typePrice) {
                    localStorage.setItem("selectedtypeIndex", typeIndex);
                    localStorage.setItem("selectedtypePrice", typePrice);
                  }

                  // Update total and count
                  function updateSelectedCount() {
                    const selectedseats = document.querySelectorAll(".row .seat.selected");

                    const seatsIndex = [...selectedseats].map((seat) => [...seats].indexOf(seat));

                    localStorage.setItem("selectedseats", JSON.stringify(seatsIndex));

                    const selectedseatsCount = selectedseats.length;

                    count.innerText = selectedseatsCount;
                    total.innerText = selectedseatsCount * ticketPrice;

                    settypeData(typeSelect.selectedIndex, typeSelect.value);
                  }


                  // Get data from localstorage and populate UI
                  function populateUI() {
                    const selectedseats = JSON.parse(localStorage.getItem("selectedseats"));

                    if (selectedseats !== null && selectedseats.length > 0) {
                      seats.forEach((seat, index) => {
                        if (selectedseats.indexOf(index) > -1) {
                          console.log(seat.classList.add("selected"));
                        }
                      });
                    }

                    const selectedtypeIndex = localStorage.getItem("selectedtypeIndex");

                    if (selectedtypeIndex !== null) {
                      typeSelect.selectedIndex = selectedtypeIndex;
                      console.log(selectedtypeIndex)
                    }
                  }
                  console.log(populateUI())
                  // type select event
                  typeSelect.addEventListener("change", (e) => {
                    ticketPrice = +e.target.value;
                    settypeData(e.target.selectedIndex, e.target.value);
                    updateSelectedCount();
                  });

                  // seat click event
                  container.addEventListener("click", (e) => {
                    if (
                      e.target.classList.contains("seat") &&
                      !e.target.classList.contains("sold")
                    ) {
                      e.target.classList.toggle("selected");

                      updateSelectedCount();
                    }
                  });
                </script>
          </body>

          </html>