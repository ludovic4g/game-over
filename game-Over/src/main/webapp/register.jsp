<%@ page import= "utente.model.*" %>
<%@ page import= "connection.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
        if(auth!=null){
                response.sendRedirect("index.jsp");
        }
%>
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>GameOver|Registrazione</title>
                <link rel="stylesheet" type="text/css" href="style.css">
                <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
                <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
                <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        </head>

        <body>
                <!--Header-->
                <%@ include file="includes/header.jsp" %>
                <!--Register-->
                <div class="fakebody">
                        <div class="containerbody">
                                <h2>
                                        <a href="#" class="logo"><span
                                                        aria-hidden="true">Registrazione</span>Registrazione<span
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
                                        <form action="RegisterServlet" method="post">
                                                <div class="page slide-page">
                                                        <div class="field">
                                                                <div class="label">
                                                                        Nome
                                                                </div>
                                                                <input type="text" id="regName" name="nome" required>
                                                        </div>
                                                        <div class="field">
                                                                <div class="label">
                                                                        Cognome
                                                                </div>
                                                                <input type="text" id="regSurname" name="cognome" required>
                                                        </div>
                                                        <div class="field">
                                                                <div class="label">
                                                                        Username
                                                                </div>
                                                                <input type="text" id="regUsername" name="username" required>
                                                        </div>
                                                        <div class="field">
                                                                <div class="label">
                                                                        E-mail
                                                                </div>
                                                                <input type="text" id="regMail" name="mail" required>
                                                        </div>
                                                        <div class="field">
                                                                <button class="firstNext next">Avanti</button>
                                                        </div>
                                                </div>
                                                <div class="page">
                                                        <div class="field">
                                                                <div class="label">
                                                                        Genere
                                                                </div>
                                                                <select name="sesso" required>
                                                                        <option selected="selected">Preferisco non
                                                                                specificarlo</option>
                                                                        <option>Maschio</option>
                                                                        <option>Femmina</option>
                                                                        <option>Altro</option>
                                                                </select>
                                                        </div>
                                                        <div class="field">
                                                                <div class="label">
                                                                        Data di Nascita
                                                                </div>
                                                                <input type="date" id="regBirthDate" name="ddn" required>
                                                        </div>
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
                                                                <input type="password" class="password-field"  id="regPassword" name="pass1" required>
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
                                                                                Contiene un carattere speciale(\ -.)
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
                                                                <input type="password" class="password-field" id="regPasswordRepeat" name="pass2" required>
                                                        </div>
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
                                                                <select required>
                                                                        <option selected="selected">Citt?? preferita
                                                                        </option>
                                                                        <option>Nome dell???amico del cuore</option>
                                                                        <option>Qual'era il cognome da nubile di tua
                                                                                madre</option>
                                                                        <option>Il nome del tuo primo animale domestico
                                                                        </option>
                                                                </select>
                                                        </div>
                                                        <div class="field">
                                                                <div class="label">
                                                                        Risposta
                                                                </div>
                                                                <input type="text" name="risposta"  id="regSecretAnswer" required>
                                                        </div>
                                                        <div class="field btns">
                                                                <button class="prev-3 prev">Indietro</button>
                                                                <button type="submit">Registrati</button>
                                                        </div>
                                                </div>
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