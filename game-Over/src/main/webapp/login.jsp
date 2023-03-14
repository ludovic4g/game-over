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
        <title>GameOver|Login</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    </head>

    <body>
        <!--Header-->
       <%@ include file="includes/header.jsp" %>
        <!--Login-->
        <div class="containerlogin">
            <div class="boxlogin">
                <div class="formlogin">
                    <h2>
                        <a href="#" class="logo"><span aria-hidden="true">Login</span>Login<span
                                aria-hidden="true"></span></a>
                    </h2>
                    </h2>
                <form action="LoginServlet" method="post">
                <%if(request.getSession().getAttribute("errorUsername")!=null){ %>
                    <div class="inputBox">
                        <input type="text" style="color:red" name="username" required="required">
                        <span>Username Errato!</span>
                        <i></i>
                    
                    </div>
                    <% }else{%>
                    <div class="inputBox">
                        <input type="text" name="username" required="required">
                        <span>Username</span>
                        <i></i>
                    
                    </div>
                    <%} %>
                    
                    <%if(request.getSession().getAttribute("errorPassword")!=null){ %>
                    <div class="inputBox">
                         <input type="Password" name="password" required="required">
                        <span>Password Errata!</span>
                        <i></i>
                    </div>
                    <%}else{ %>
                    <div class="inputBox">
                         <input type="Password" name="password" required="required">
                        <span>Password</span>
                        <i></i>
                    </div>
                    <% }%>
                    
                    <div class="links">
                        <a href="recovery_psw_first.jsp">Forgot Password</a>
                        <a href="register.jsp">Sign up</a>
                    </div>
                    <input type="submit" value="Login">
                    </form>
                </div>
            </div>
        </div>
        <!--Footer-->
       <%@ include file="includes/footer.jsp" %>
        <script src="scripts/anime.min.js"></script>
        <script src="scripts/script.js"></script>
    </body>

    </html>