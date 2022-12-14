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
                <!--Postation -->
                <!--Footer-->
                <%@ include file="includes/footer.jsp" %>
                <script src="scripts/script.js"></script>
                <script>
                /*Select Table*/

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