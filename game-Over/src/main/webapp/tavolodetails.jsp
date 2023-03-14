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
                <!---------Table Select--------->
                <div class="bodycontain">
                <h2 class="h2_title">Scegli il tuo tavolo</h2>
                <div class="type-container">
        <label> Seleziona il tipo di giochi: </label>
        <select id="type">
          <option value="5">Giochi da tavolo ( 5 €)</option>
          <option value="3">Giochi di carte ( 3 €)</option>
        </select>
      </div>
      <br>
      <div class="price-container">
        <label for="numPeople">Numero di persone:</label>
        <select id="numPeople">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
      <br>
      <ul class="showcase">
        <li>
          <div class="table"></div>
          <small>Available</small>
        </li>
        <li>
          <div class="table selected"></div>
          <small>Selected</small>
        </li>
        <li>
          <div class="table sold"></div>
          <small>Sold</small>
        </li>
      </ul>
      <div class="container">

        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
        </div>

        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table sold"></div>
          <div class="table sold"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
        </div>
        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table sold"></div>
          <div class="table sold"></div>
        </div>
        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
        </div>
        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table sold"></div>
          <div class="table sold"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
        </div>
        <div class="row">
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table"></div>
          <div class="table sold"></div>
          <div class="table sold"></div>
          <div class="table sold"></div>
          <div class="table"></div>
        </div>
      </div>
            <p class="text">
        <div class="warning">Il totale viene calcolato nel CARRELLO!!</div>
      </p>
      <p class="text">
        Hai selezionato <span id="count">0</span> tavoli prezzo totale <span id="total">0</span>€
      </p>
      <p class="text">
        Prezzo totale persone <span class="price">0</span>€
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
      const tables = document.querySelectorAll(".row .table:not(.sold)");
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
        const selectedtables = document.querySelectorAll(".row .table.selected");

        const tablesIndex = [...selectedtables].map((table) => [...tables].indexOf(table));

        localStorage.setItem("selectedtables", JSON.stringify(tablesIndex));

        const selectedtablesCount = selectedtables.length;

        count.innerText = selectedtablesCount;
        total.innerText = selectedtablesCount * ticketPrice;

        settypeData(typeSelect.selectedIndex, typeSelect.value);
      }


      // Get data from localstorage and populate UI
      function populateUI() {
        const selectedtables = JSON.parse(localStorage.getItem("selectedtables"));

        if (selectedtables !== null && selectedtables.length > 0) {
          tables.forEach((table, index) => {
            if (selectedtables.indexOf(index) > -1) {
              console.log(table.classList.add("selected"));
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

      // table click event
      container.addEventListener("click", (e) => {
        if (
          e.target.classList.contains("table") &&
          !e.target.classList.contains("sold")
        ) {
          e.target.classList.toggle("selected");

          updateSelectedCount();
        }
      });

      // Initial count and total set
      updateSelectedCount();


      // Get the elements we need
      const numPeopleEl = document.getElementById('numPeople');
      const priceEl = document.querySelector('.price');

      // Set the initial price to 0
      let price = 0;

      // Calculate the price based on the number of people selected
      function calculatePrice() {
        const numPeople = numPeopleEl.value;
        price = numPeople * 5; // Assume the price is $5 per person
        priceEl.textContent = price;
      }

      // Calculate the price when the page loads
      calculatePrice();

      // Calculate the price when the number of people changes
      numPeopleEl.addEventListener('change', calculatePrice);

    </script>
        </body>

        </html>