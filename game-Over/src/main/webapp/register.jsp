<%@ page import= "utente.model.*" %>
<%@ page import= "gestorecatalogo.model.*" %>
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
    <title>GameOver|Registrati</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>

<body>
    <!-- Header -->
       <%@ include file="includes/header.jsp" %>
       <br>
       <br>
       <br>
       <br>
    <!-- Register -->
    <div class="fakebody">
        <div class="containerbody">
            <h2>
                <a href="#" class="logo"><span aria-hidden="true">Registrazione</span>Registrazione<span
                        aria-hidden="true">Registrazione</span></a>
            </h2>
            <div class="progress-bar">
                <div class="step">
                    <p>
                        1
                    </p>
                    <div class="bullet">
                    </div>
                    <div class="check fas fa-check"></div>
                </div>
                <div class="step">
                    <p>
                        2
                    </p>
                    <div class="bullet">
                    </div>
                    <div class="check fas fa-check"></div>
                </div>
                <div class="step">
                    <p>
                        3
                    </p>
                    <div class="bullet">
                    </div>
                    <div class="check fas fa-check"></div>
                </div>
                <div class="step">
                    <p>
                        4
                    </p>
                    <div class="bullet">
                    </div>
                    <div class="check fas fa-check"></div>
                </div>
            </div>
            <div class="form-outer">
                <form action="RegisterServlet" method= "post">
                    <div class="page slide-page">
                        <div class="field">
                            <div class="label">
                                Nome
                            </div>
                            <% if(request.getAttribute("errorNome")!=null){ %>
                             <input type="text" class="form-control is-invalid" name="nome" placeholder="Errore Nome" required>
                             <%}else{ %>
                             <input type="text" name="nome" required>
                             <%} %>
                        </div>
                        <small class="error_input">Errore Nome - Non valido</small>
                        <div class="field">
                            <div class="label">
                                Cognome
                            </div>
                             <% if(request.getAttribute("errorCognome")!=null){ %>
                             <input type="text" class="form-control is-invalid" name="nome" placeholder="Errore Cognome" required>
                             <%}else{ %>
                            <input type="text" name="cognome" required>
                            <%} %>
                        </div>
                        <small class="error_input">Errore Cognome - Non valido</small>
                        <div class="field">
                            <div class="label">
                                Username
                            </div>
                            <% if(request.getAttribute("existUsername")!=null){ %>
                            <input type="text" class="form-control is-invalid" name="username" placeholder="Username già esistente" required>
                            <%}else if(request.getAttribute("errorUsername")!=null){ %>
                            <input type="text" class="form-control is-invalid" name="username" placeholder="Errore username" required>
                            <%} else {%>
                            <input type="text" name="username" required>
                            <%} %>
                        </div>
                        <small class="error_input">Errore Username - Già esistente</small>
                        <div class="field">
                            <div class="label">
                                E-mail
                            </div>
                            <% if(request.getAttribute("errorMail")!=null){ %>
                             <input type="text" class="form-control is-invalid" name="mail" placeholder="Errore E-Mail" required>
                              <%}else if(request.getAttribute("existUsername")!=null){ %>
                            <input type="text" class="form-control is-invalid" name="username" placeholder="Email già esistente" required>
                             <%}else{ %>
                            <input type="text" name="mail" required>
                            <%} %>
                        </div>
                       <small class="error_input">Errore Email - Non Valida</small>
                        <small class="error_input">Errore Email - Già esistente</small>
                        <div class="field">
                            <button class="firstNext next">Avanti</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="field">
                            <div class="label">
                                Genere
                            </div>
                            <select name="sesso">
                                <option selected="selected" value="">Preferisco non specificarlo</option>
                                <option value="Maschio">Maschio</option>
                                <option value ="Femmina">Femmina</option>
                                <option value ="Altro">Altro</option>
                            </select>
                        </div>
                        <div class="field">
                            <div class="label">
                                Data di Nascita
                            </div>
                            <% if(request.getAttribute("errorCognome")!=null){ %>
                             <input type="date" class="form-control is-invalid" name="ddn" placeholder="Errore Formato Data" required>
                             <%}else{ %>
                            <input type="date" name="ddn" required>
                            <%} %>
                        </div>
                        <small class="error_input">Errore Data - Seleziona una data</small>
                        <small class="error_input">Errore Data - Seleziona una data valida</small>
                        <div class="field btns">
                            <button class="prev-1 prev">Indietro</button>
                            <button class="next-1 next">Avanti</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="field">
                            <div class="label">
                                Password
                            </div>
                            <% if(request.getAttribute("errorPassword")!=null){ %>
                             <input type="password" class="form-control is-invalid" name="pass1" placeholder="Errore Password" required>
                             <%}else{ %>
                            <input type="password" id="password-field" name="pass1" required>
                            <%} %>
                            <div class="toggle-password">
                                <i class="fa fa-eye"></i>
                                <i class="fa fa-eye-slash"></i>
                            </div>
                            <div class="password-policies">
                                <div class="policy-length">
                                    Almeno 8 caratteri(a-z)
                                </div>
                                <div class="policy-number">
                                    Contiene un numero(0-9)
                                </div>
                                <div class="policy-uppercase">
                                    Contiene una maiuscola(A-Z)
                                </div>
                                <div class="policy-special">
                                    Contiene un carattere speciale(\ - .)
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="field">
                            <div class="label">
                                Conferma Password
                            </div>
                            <% if(request.getAttribute("notEquals")!=null){ %>
                             <input type="password" class="form-control is-invalid" name="pass2" placeholder="Password non Coincidono" required>
                             <%}else{ %>
                            <input type="password" id="password-field" name="pass2" required>
                            <%} %>
                        </div>
                        <small class="error_input">Errore Password - Non valida</small>
                        <small class="error_input">Errore Password - Le Password non coincidono</small>
                        <div class="field btns">
                            <button class="prev-2 prev">Indietro</button>
                            <button class="next-2 next">Avanti</button>
                        </div>
                    </div>
                    <div class="page">
                        <div class="field">
                            <div class="label">
                                Domanda di sicurezza
                            </div>
                            <select name="domanda " required>
                                <option selected="selected">Città preferita</option>
                                <option>Nome dell’amico del cuore</option>
                                <option>Qual'era il cognome da nubile di tua madre?</option>
                                <option>Il nome del tuo primo animale domestico</option>
                            </select>
                        </div>
                        <div class="field">
                            <div class="label">
                                Risposta
                            </div>
                            <% if(request.getAttribute("errorPassword")!=null){ %>
                             <input type="text" class="form-control is-invalid" name="risposta" placeholder="Errore Risposta">
                             <%}else{ %>
                            <input type="text" name="risposta" required>
                            <%} %>
                        </div>
                        <small class="error_input">Errore Risposta - Formato non valido</small>
                        <div class="field btns">
                            <button class="prev-3 prev">Indietro</button>
                            <button class="submit">Registrati</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <br>
    <br>
    <br>
    <br>
       
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
    <script src="scripts/anime.min.js"></script>
    <script src="scripts/script.js"></script>

</body>

</html>