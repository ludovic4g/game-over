 <header>
 <a href="index.jsp" class="logo"><span aria-hidden="true">GameOver</span>GameOver<span
                                        aria-hidden="true">GameOver</span></a>
                        <ul class="nav">
                        <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==true) {%>
                        		 <li><a href="dashboard_admin.jsp">Admin</a></li>
                        		 <%}%>
                                <li><a href="esport.jsp">ESport</a></li>
                                <li><a href="shopgame.jsp">Games</a></li>
                                <li><a href="cart.jsp">Carrello</a></li>
                                <%if(auth!= null && (auth.isGestoreCatalogo()|| auth.isGestorePrenotazioni()|| auth.isGestoreOrdini())==false) {%>
                                <li><a href="prenotazioni.jsp">Prenotazioni</a></li>
                                <li><a href="orders.jsp">Ordini</a></li>
                                 <li><a href="dashboard_user.jsp">Profilo</a></li>
                                <%}
                                if(auth!=null){%>
                                <li><a href="LogoutServlet">Logout</a></li>
                                <%}else {%>
                                <li><a href="login.jsp">Login</a></li>
                                <%} %>
                               
                        </ul>
                        <div class="action">
                                <div class="searchBx">
                                        <form action="RicercaServlet" method="post">
                                        <a href=""><i class='bx bx-search'></i></a>
                                        <input type="text" name="cerca" placeholder="Cerca il tuo gioco...">
                                        </form>
                                </div>
                        </div>
                        <div class="toggleMenu" onclick="toggleMenu();"></div>
      </header>