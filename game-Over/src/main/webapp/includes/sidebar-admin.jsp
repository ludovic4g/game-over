<div class="sidebar close">
      <div class="logo-details">
        <i class='bx bxs-joystick'></i>
        <span class="logo_name">GameOver</span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="#">
            <i class='bx bx-grid-alt'></i>
            <span class="link_name">Dashboard</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="dashboard_admin.jsp">Dashboard</a></li>
          </ul>
        </li>
        <li>
          <div class="iocn-link">
            <a href="#">
              <i class='bx bx-collection'></i>
              <span class="link_name">Prodotti</span>
            </a>
            <i class='bx bxs-chevron-down arrow'></i>
          </div>
          <%if(auth.isGestoreCatalogo()!=false){ %>
          <ul class="sub-menu">
            <li><a class="link_name" href="#">Prodotto</a></li>
            <li><a href="addproduct.jsp">Aggiungi Prodotto</a></li>
            <li><a href="catalogo.jsp">Modifica Prodotto</a></li>
            <li><a href="rimuoviprodotto.jsp">Rimuovi Prodotto</a></li>
          </ul>
           <% }%>
        </li>
        <li>
        <%if(auth.isGestoreOrdini()!=false) {%>
        <li>
          <a href="orderlist.jsp">
            <i class='bx bx-cart'></i>
            <span class="link_name">Lista Ordini</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="orderlist.jsp">Ordini</a></li>
          </ul>
        </li>
        <%} %>
        <%if(auth.isGestorePrenotazioni()!=false){ %>
         <li>
          <a href="prenotazioni_list.jsp">
            <i class='bx bx-cart'></i>
            <span class="link_name">Lista Prenotazioni</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="prenotazioni_list.jsp">Prenotazioni</a></li>
          </ul>
        </li>
        <%} %>
        <li>
          <a href="index.jsp">
            <i class='bx bx-home'></i>
            <span class="link_name">Home</span>
          </a>
          <ul class="sub-menu blank">
            <li><a class="link_name" href="index.jsp">Home</a></li>
          </ul>
        </li>
      </ul>
      <!---------Home Section--------->
    </div>