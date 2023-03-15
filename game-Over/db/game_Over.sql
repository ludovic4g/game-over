drop database if exists game_Over;
create database game_Over;
use game_Over;

create table Utente(
	username varchar(30) primary key,
    password text not null,
    email varchar(25) unique not null,
    nome varchar(30) not null,
    cognome varchar(20) not null,
    ddn date not null,
    sex	varchar(10) not null,
    risposta varchar(30) not null,
    ammin1 boolean not null,
    ammin2 boolean not null,
    ammin3 boolean not null
);

create table Videogioco(
	id integer auto_increment primary key,
    nome varchar(50) not null,
    prezzo double not null,
    anno int not null,
    quantita int not null,
    magazzino int not null,
    tipo varchar(15) not null,
    descrizione varchar(1500) not null,
	img1        varchar(100)   not null,
    img2        varchar(100)   not null,
    img3        varchar(100)   not null,
    img4        varchar(100)   not null,
    img5        varchar(100)   not null
);

create table Compra(
	username varchar(30) not null,
    id integer not null,
    
    primary key(username, id),
    foreign key(username) references Utente(username) on update cascade on delete cascade,
    foreign key(id) references Videogioco(id) on update cascade on delete cascade
);


create table Ordine(
    idOrdine integer primary key auto_increment,
    utente varchar(30) not null,
    dataAcquisto date not null,
    prezzoTotale double not null,
    iva int not null,
    numeroProdotti int not null,
    stato varchar(20) not null
);

create table Riguarda(
    id integer not null,
    idOrdine integer not null,
    
    primary key(id, idOrdine),
    foreign key(id) references Videogioco(id) on update cascade on delete cascade,
    foreign key(idOrdine) references Ordine(idOrdine) on update cascade on delete cascade
);

create table Prenotazione(
    id integer primary key auto_increment,
    utente varchar(30) not null,
    prezzoTotale double not null,
    postiPrenotati int not null,
    ora varchar(20) not null,
    dataprenotazione date not null,
    stato varchar(20) not null
 
);

create table OrdinePrenotazione(
    id integer not null,
    idOrdine integer not null,
    
    primary key(id, idOrdine),
    foreign key(id) references Prenotazione(id) on update cascade on delete cascade,
    foreign key(idOrdine) references Ordine(idOrdine) on update cascade on delete cascade
);

create table Tavolo(
	numero integer primary key auto_increment,
    numeroPosti int not null,
    prezzoPosto double not null,
    ora varchar(20) not null,
    tipo varchar(20) not null,
    disp boolean not null,
    img varchar(50) not null
);

create table PrenotazioneTavolo(
    id integer not null,
    numero integer not null,
    
    primary key(id, numero),
    foreign key(id) references Prenotazione(id) on update cascade on delete cascade,
    foreign key(numero) references Tavolo(numero) on update cascade on delete cascade
);

create table Indirizzo(
    id integer primary key auto_increment,
    nome varchar(20) not null,
    indirizzo varchar(50) not null,
    cap char(6) not null,
    citta varchar(30),
    provincia char(2)
    
);

create table Ha(
    id integer not null,
    username varchar(30) not null,
    
    primary key(id, username),
    foreign key(id) references Indirizzo(id) on update cascade on delete cascade,
    foreign key(username) references Utente(username) on update cascade on delete cascade
);

create table Postazione(
	id integer not null primary key auto_increment,
    ora varchar(20) not null,
    tipo varchar(20) not null,
    prezzo double not null,
    disp boolean not null,
    img varchar(50) not null
    );
    
create table PrenotazionePostazione(
    id integer not null,
    idPostazione integer not null,
    
    primary key(id, idPostazione),
    foreign key(id) references Prenotazione(id) on update cascade on delete cascade,
    foreign key(idPostazione) references Postazione(id) on update cascade on delete cascade
);



/* modificare risposta e controlla formato data*/
INSERT INTO Utente VALUES ("lucger", "MorningStar9.", "luuvifer@gmail.com", "Luciel", "Spexiato", "1990-12-07", "Femmina","", true, false, true);
INSERT INTO Utente VALUES ("tansat", "Piango2.", "sxtans@gmail.com", "Sally", "Acido", "1994-09-01", "Maschio","", false, true, false);
INSERT INTO Utente VALUES ("honejmoon", "Benedetta7.", "benedetta@gmail.com", "Benedetta", "Rossetti", "2001-11-07", "Femmina","", false, false, false);
INSERT INTO Utente VALUES ("manuelito", "Manuelsica1.", "manuel@gmail.com", "Manuel", "Sica", "2001-05-24","Maschio", "Benevento", false, false, false);
INSERT INTO Utente VALUES ("luds", "Ludovica2.", "ludovica@gmail.com", "Ludovica", "Genovese", "2001-07-16","Femmina", "", false, false, false);
INSERT INTO Utente VALUES ("marja", "Mariarossi5.", "maria@gmail.com", "Maria", "Rossi", "1996-03-07", "Femmina","", false, false, false);
INSERT INTO Utente VALUES ("lucas", "Lucaverdi6.", "luca@gmail.com", "Luca", "Verdi", "2003-01-20","Maschio", "", false, false, false);
INSERT INTO Utente VALUES ("giovanni69", "Giovanni3.", "giovanni@gmail.com", "Giovanni", "Bianchi", "1999-12-25","Maschio", "", false, false, false);
INSERT INTO Utente VALUES ("marcella_", "Marcella1.", "marcella@gmail.com", "Marcella", "Vitale", "2000-04-03", "Non-Binary","", false, false, false);
INSERT INTO Utente VALUES ("valecri", "Valeriacrispo9.", "valeria@gmail.com", "Valeria", "Crispo", "1994-11-10","Femmina", "", false, false, false);
INSERT INTO Utente VALUES ("saetta", "Amedeosae2.", "amedeo@gmail.com", "Amedeo", "Saetta", "2001-07-15","Maschio", "", false, false, false);
INSERT INTO Utente VALUES ("vince", "Vincenzo9.", "vincenzo@gmail.com", "Vincenzo", "Sorrentino", "2001-11-06","Non-Binary", "", false, false, false);
INSERT INTO Utente VALUES ("consi03", "Consiglia6.", "consiglia@gmail.com", "Consiglia", "Lamberi", "1995-07-01","Femmina", "", false, false, false);
INSERT INTO Utente VALUES ("dima7", "Dimitrika16.", "dimitri@gmail.com", "Dimitri", "Kambulatov", "1992-10-16", "Maschio","", false, false, false);
INSERT INTO Utente VALUES ("enzos", "Enzoverdi4.", "enzo@gmail.com", "Vincenzo", "Verdi", "1995-12-29","Maschio", "", false, false, false);
INSERT INTO Utente VALUES ("fabbb", "Fabioava5.", "fabio@gmail.com", "Fabio", "Avagliano", "1996-11-11", "maschio","", false, false, false);
INSERT INTO Utente VALUES ("nancy99", "Nunziatorre8.", "nunzia@gmail.com", "Nunzia", "Torre", "2002-04-18", "Femmina","", false, false, false);
INSERT INTO Utente VALUES ("cateMary", "Caterina4.", "cayerina@gmail.com", "Caterina Maria", "Di Giacomo", "1993-07-23","Non-Binary", "", false, false, false);
INSERT INTO Utente VALUES ("francs", "Francesca0.", "francesca@gmail.com", "Francesca", "D'Aloia", "1987-04-03","Non-Binary", "", false, false, false);
INSERT INTO Utente VALUES ("davjde", "Davideanno5.", "davide@gmail.com", "Davide", "Dell'Anno", "1990-05-24", "Non-Binary","", false, false, false);
INSERT INTO Utente VALUES ("ross_", "Rossella2.", "rossella@gmail.com", "Rossella", "Senatore", "1998-08-20", "Femmina","", false, false, false);
INSERT INTO Utente VALUES ("ilarya", "Ilariasalvo0.", "ilaria@gmail.com", "Ilaria", "Salvo", "1999-09-26", "Femmina","", false, false, false);

/*modifica immagini*/
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("FIFA 23 Legacy Edition", 40, 2022, 2, 50, "Nintendo Switch", "FIFA 23 Legacy Edition include divise, club e rose originali di alcuni dei principali campionati del mondo. Conterra' inoltre diverse tra le migliori squadre di club femminili e alcuni dei piu' famosi stadi al mondo, compresi alcuni inediti, una veste grafica rinnovata e un nuovo pacchetto che comprende telecronaca e grafiche aggiornate durante le partite. FIFA 23 Legacy Edition presentera' le stesse modalita'  e caratteristiche a livello di gameplay gia'  viste in FIFA 22 Legacy Edition, senza novita'  o migliorie di rilievo.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Gran Turismo 7", 80, 2022, 1, 50, "PS4, PS5", "Piloti competitivi e occasionali, collezionisti, amanti della messa a punto, progettisti di livree e fotografi: tutti troveranno la loro traiettoria grazie alle fantastiche modalita' di gioco offerte, incluse le popolari modalita' campagna, Arcade e Accademia di guida. Grazie al ritorno della leggendaria modalita' GT Simulation, acquista, metti a punto e gareggia nel corso dell'appagante campagna per giocatore singolo man mano che sblocchi nuove auto e sfide. Se ami la competizione diretta, affina le tue abilita'  e gareggia nella modalita'  Sport. Con oltre 420 auto disponibili in Brand Central e nel concessionario di auto usate fin dal primo giorno, Gran Turismo 7 ricrea l'aspetto e le sensazioni di guida di auto classiche e moderne supercar con un livello di dettaglio senza precedenti. Ogni auto si comporta diversamente sugli oltre 90 tracciati, inclusi alcuni circuiti classici della storia di GT, con condizioni climatiche dinamiche.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Horizon Forbidden West", 80, 2022, 1, 50, "PS4, PS5", "Esplora terre remote, combatti contro macchine ancora piu' grandi e terrificanti e incontra nuove e stupefacenti tribu' al tuo ritorno nel lontano futuro post-apocalittico di Horizon. La terra sta morendo. Violente tempeste e una piaga inarrestabile funestano quel poco che resta dell'umanita', mentre nuove e tremende macchine vanno a caccia lungo i confini. La vita sulla Terra sembra destinata a una nuova estinzione e nessuno ne conosce il motivo. Tocchera' ad Aloy scoprire i segreti che si celano dietro queste insidie per riportare ordine ed equilibrio nel mondo. In questo viaggio incontrera' vecchie conoscenze, stringera' alleanze con nuove fazioni in guerra e fara' luce sull'eredita' dell'antico passato, tutto questo cercando di avere la meglio su un nemico apparentemente invincibile.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Marvel's Spider-Man: Miles Morales", 60, 2020, 1, 50, "PS4, PS5, PC", "Nell'ultima avventura della serie Marvel's Spider-Man, l'adolescente Miles Morales cerca di ambientarsi in un nuovo quartiere mentre segue le orme del suo mentore, Peter Parker, come nuovo Spider-Man. Ma quando una feroce lotta per il potere minaccia di distruggere la sua nuova casa, l'aspirante eroe capisce che da grandi poteri derivano grandi responsabilita'. Per salvare la New York della Marvel, Miles deve raccogliere il testimone di Spider-Man e dimostrarsi all'altezza.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Poke'mon Violetto", 60, 2022, 0, 50, "Nintendo Switch", "La serie PokÃ©mon si evolve in un modo tutto nuovo con PokÃ©mon Violetto per Nintendo Switch. Parti all'avventura con i tuoi amici ed esplora liberamente un ricco e vasto mondo.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Super Mario Odyssey", 60, 2017, 1, 50, "Nintendo Switch", "Mario girera' intorno al mondo a bordo di una nave volante chiamata Odyssey. La nave viene alimentata e preparata al viaggio tra un regno e l'altro tramite le lune di energia. Chi puo' dire quali straordinari luoghi scoprira' nel corso della sua odissea?", "", "", "", "","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Minecraft", 30, 2018, 1, 50, "Nintendo Switch", "Il nuovo Minecraft e' arrivato e include tutti gli ultimi aggiornamenti come Update Aquatic, il supporto al gioco cross-player e l'accesso a una moltitudine di contenuti del Minecraft Marketplace.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Crash Bandicoot N. Sane Trilogy", 40, 2018, 1, 50, "Nintendo Switch", "Crash Bandicoot, il tuo marsupiale preferito, e' tornato! Piu' bello e scatenato che mai, e' pronto a lanciarsi nelle danze nella collezione Trilogia N. Sane. Un Crash Bandicoot come non l'avevi mai visto prima! Gira, salta e balla affrontando sfide e avventure epiche nei tre giochi che hanno dato inizio alla leggenda: Crash Bandicoot. Crash Bandicoot 2: Il Ritorno di Cortex e Crash Bandicoot 3: Teletrasportato. Rivivi i tuoi momenti preferiti in tutto lo splendore grafico dell'HD completamente rimasterizzato per un divertimento in grande stile!","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Witcher 3: Wild Hunt", 40, 2021,  1, 50,"Nintendo Switch", "Vincitore di piu' di 250 premi Game of the Year, The Witcher 3: Wild Hunt e' un gioco narrativo con un mondo aperto ambientato in un cupo universo fantasy. Sei Geralt di Rivia, cacciatore di mostri mercenario. Hai a disposizione tutti i ferri del mestiere: spade affiliate come rasoi, letali pozioni, balestre silenziose e potenti magie di combattimento. Davanti a te si stende un continente devastato dalla guerra e infestato dai mostri, che potrai esplorare a piacimento. Il tuo incarico? Trovare una ragazza oggetto di una profezia, un'arma vivente che puo' cambiare il mondo.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Ratchet & Clank: Rift Apart", 50, 2020, 1, 50, "PS5", "Viaggia tra le dimensioni con Ratchet e Clank e affronta un malvagio imperatore proveniente da un'altra realta'. Salta come un fulmine tra mondi ricchi d'azione, tutti immersi in panorami mozzafiato e completi di un arsenale totalmente folle, quando l'avventura fara' il suo arrivo sulla console PS5.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("UNCHARTED: Raccolta L'eredita'  dei ladri", 50, 2022, 1, 50, "PS5, PC", "Diventa una leggenda e lascia il segno in UNCHARTED: Raccolta L'eredita'  dei ladri. Vivi il pathos, la narrazione cinematografica e l'iconico franchise dei titoli campioni di incassi piu' elettrizzanti di Naughty Dog. Scopri le imprese del passato con i ladri Nathan Drake e Chloe Frazer, personaggi tanto carismatici quanto complessi, mentre viaggiano per il mondo in cerca di avventure e storie straordinarie.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("DEATH STRANDING DIRECTOR'S CUT", 40, 2022, 1, 50, "PS5", "Dal leggendario creatore di giochi Hideo Kojima arriva un'esperienza che sfida il genere, ora ampliata e rimasterizzata per PS5 in questa DIRECTOR'S CUT definitiva.Nel futuro, un misterioso evento noto come Death Stranding ha aperto un varco tra il regno dei vivi e quello dei morti, permettendo alle creature dell'aldilÃ  di vagare in un mondo ormai segnato da una societa' in declino.Nei panni di Sam Bridges, la tua missione sara' quella di portare speranza all'umanita' mettendo in contatto gli ultimi sopravvissuti di un'America decimata.Riuscirai a riunificare un mondo in frantumi, un passo alla volta?","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Sackboy: Una Grande Avventura", 30, 2020,  1, 50,"PS4, PS5, PC", "Sackboy, l'iconico eroe dell'universo PlayStation, torna a vivere avventure mozzafiato in un gigantesco, appassionante e frenetico platform 3D multigiocatore... con nuove e pupazzose abilita'!","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Last of Us Part I", 80, 2022,  1, 50,"PS5", "Riscopri la straordinaria narrazione e gli indimenticabili personaggi di The Last of Us, vincitore di oltre 200 premi Game of the Year. In una civiltÃ  senza futuro, dove imperversano infetti e criminali, un uomo ormai segnato dalla vita, Joel, viene ingaggiato per condurre una ragazzina di 14 anni, Ellie, fino a una zona di quarantena militare. Ma quello che in principio sembra un incarico irrilevante, diventa presto un logorante viaggio attraverso l'intera nazione","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("God of War Ragnarok", 80, 2022, 1, 50, "PS4, PS5", "E' in arrivo dagli sviluppatori di Santa Monica Studio il sequel dell'apprezzatissimo God of War (2018). Il Fimbulwinter si fa gia' sentire. Kratos e Atreus devono esplorare ognuno dei nove regni alla ricerca di risposte, mentre le milizie di Asgard si preparano a un'annunciata battaglia che segnera' la fine del mondo.Nel loro cammino si immergeranno in splendidi panorami mitici e affronteranno temibili nemici sotto forma di dei norreni e mostri. La minaccia del Ragnarok si avvicina sempre di piu'. Kratos e Atreus devono scegliere tra la salvezza della loro famiglia e quella dei regni.", "","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("EA SPORTS FIFA 23", 90, 2022, 1, 50, "PS4, PS5", "EA SPORTS FIFA 23 porta il gioco piu' bello del mondo sul campo, con i tornei della Coppa del Mondo FIFA maschile e femminile, l'aggiunta di squadre di club femminili e nuovi modi di giocare le tue modalita' preferite. I progressi della tecnologia HyperMotion2 portano in campo un'azione e un realismo sempre piu' sorprendenti su PS5. Con il doppio della quantita' di acquisizione di movimento reale, ora le animazioni calcistiche sono piu' numerose che mai in ogni partita.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Callisto Protocol", 70, 2022, 0, 50, "PS4, PS5", "In questo gioco horror narrativo in terza persona, ambientato 300 anni nel futuro, il giocatore veste i panni di Jacob Lee, uno sfortunato prigioniero rinchiuso nella prigione di Black Iron, carcere di massima sicurezza situato su Callisto, la luna morta di Giove. Quando gli altri detenuti iniziano a trasformarsi in creature da incubo, la prigione piomba nel caos. Per sopravvivere, Jacob dovra' farsi strada con la forza verso la liberta' e scoprire gli oscuri e inquietanti segreti sepolti sotto la superficie di Callisto.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("NBA 2K23", 80, 2022,  1, 50,"PS4, PS5", "Competi nei panni delle tue squadre e delle tue stelle NBA e WNBA preferite e goditi il meglio del gameplay immersivo. Con una presentazione grafica all'avanguardia, un'intelligenza artificiale dei giocatori migliorata, formazioni aggiornate e squadre storiche, in NBA 2K23 il gioco e' piu' reale e completo che mai. Senti l'energia della folla, l'intensita' della competizione e l'intrattenimento senza fine di uno dei videogiochi sportivi piu' coinvolgenti del momento.","","","","","");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Elden Ring", 70, 2022, 0, 50, "PS4, PS5", "Nell'Interregno governato dalla regina Marika l'Eterna, l'Anello ancestrale, sorgente dell'Albero Madre, e' andato in frantumi. I discendenti di Marika, tutti semidei, rivendicarono i frammenti dell'Anello ancestrale, conosciuti col nome di rune maggiori, e la corruzione folle della loro nuova forza scateno' una guerra: la Disgregazione. Una guerra che porto' all'abbandono della Volonta' superiore.", "", "", "", "", "");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Gotham Knights", 75, 2022, 2, 50, "PS4, PS5", "Gotham Knights e' un gioco di ruolo d'azione open world ambientato nella Gotham City piu' dinamica e interattiva mai vista prima d'ora. Pattuglia i cinque distretti di Gotham in modalita' giocatore singolo o insieme a un altro eroe e sventa le attivita' criminali in cui ti imbatti.", "","","","","");


INSERT INTO Compra VALUES ("honejmoon", 3);
INSERT INTO Compra VALUES ("honejmoon", 1);
INSERT INTO Compra VALUES ("honejmoon", 2);
INSERT INTO Compra VALUES ("vince", 8);
INSERT INTO Compra VALUES ("vince", 5);
INSERT INTO Compra VALUES ("cateMary", 10);
INSERT INTO Compra VALUES ("davjde", 18);
INSERT INTO Compra VALUES ("davjde", 15);
INSERT INTO Compra VALUES ("ross_", 20);
INSERT INTO Compra VALUES ("ross_", 11);
INSERT INTO Compra VALUES ("ross_", 13);
INSERT INTO Compra VALUES ("dima7", 1);
INSERT INTO Compra VALUES ("saetta", 4);
INSERT INTO Compra VALUES ("fabbb", 6);
INSERT INTO Compra VALUES ("marcella_", 9);
INSERT INTO Compra VALUES ("marcella_", 7);
INSERT INTO Compra VALUES ("marcella_", 12);
INSERT INTO Compra VALUES ("francs", 14);
INSERT INTO Compra VALUES ("ilarya", 16);
INSERT INTO Compra VALUES ("ilarya", 20);

/* modificare il prezzo totale */
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("honejmoon", "2022-04-05", 40, 0.22, 3, "consegnato");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("vince", "2023-01-05", 40, 0.22, 3, "spedito");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("cateMary", "2022-08-10", 40, 0.22, 2, "consegnato");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("davjde", "2022-11-20", 40, 0.22, 3, "consegnato");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("ross_", "2023-01-18", 40, 0.22, 4, "in consegna");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("dima7", "2022-12-25", 40, 0.22, 3,"spedito");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("saetta", "2022-09-05", 40, 0.22, 2, "consegnato");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("fabbb", "2023-01-01", 40, 0.22, 1, "in attesa");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("marcella_", "2022-06-15", 0.22, 10, 3, "in consegna");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("francs", "2023-01-20", 40, 0.22, 2, "in attesa");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("ilarya", "2022-10-29", 40, 0.22, 3, "in attesa");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("manuelito", "2023-01-29", 30, 0.22, 1, "in consegna");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("gioovanni69", "2022-10-12", 30, 0.22, 1, "in consegna");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("marja", "2022-9-29", 30, 10, 0.22, "consegnato");
INSERT INTO Ordine(utente, dataAcquisto, prezzoTotale, iva, numeroProdotti, stato) VALUES ("luds", "2022-01-21", 30, 10, 0.22,"consegnato");

INSERT INTO Riguarda VALUES (1, 1);
INSERT INTO Riguarda VALUES (2, 1);
INSERT INTO Riguarda VALUES (3, 1);
INSERT INTO Riguarda VALUES (8, 2);
INSERT INTO Riguarda VALUES (10, 3);
INSERT INTO Riguarda VALUES (18, 4);
INSERT INTO Riguarda VALUES (15, 4);
INSERT INTO Riguarda VALUES (20, 5);
INSERT INTO Riguarda VALUES (11, 5);
INSERT INTO Riguarda VALUES (13, 5);
INSERT INTO Riguarda VALUES (1, 6);
INSERT INTO Riguarda VALUES (4, 7);
INSERT INTO Riguarda VALUES (6, 8);
INSERT INTO Riguarda VALUES (9, 9);
INSERT INTO Riguarda VALUES (7, 9);
INSERT INTO Riguarda VALUES (12, 9);
INSERT INTO Riguarda VALUES (14, 10);
INSERT INTO Riguarda VALUES (16, 11);
INSERT INTO Riguarda VALUES (20, 12);

INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("vince", 44, 4, "20:30:03", "2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("dima7", 30, 3, "14:23:00","2023-01-20","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("saetta", 60, 5, "18:11:09","2023-01-20","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("ilarya", 98, 7, "11:05:29","2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("francs", 200, 10, "22:48:56","2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("cateMary", 120, 8, "15:19:33","2022-10-29","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("davjde", 60, 6, "19:56:02","2022-10-29","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("honejmoon", 30, 1, "20:30:03","2023-01-20","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("dima7", 30, 1, "18:23:00","2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("ross_", 30, 1, "10:11:09","2023-01-20","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("manuelito", 30, 1, "19:05:29","2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("giovanni69", 30, 1, "23:48:56","2023-01-20","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("marja", 30, 1, "11:19:33","2022-08-10","");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, ora, dataprenotazione, stato) VALUES ("luds", 30, 1, "18:56:02","2022-10-29","");


INSERT INTO OrdinePrenotazione VALUES (1, 2);
INSERT INTO OrdinePrenotazione VALUES (2, 6);
INSERT INTO OrdinePrenotazione VALUES (3, 7);
INSERT INTO OrdinePrenotazione VALUES (4, 11);
INSERT INTO OrdinePrenotazione VALUES (5, 10);
INSERT INTO OrdinePrenotazione VALUES (6, 3);
INSERT INTO OrdinePrenotazione VALUES (7, 4);
INSERT INTO OrdinePrenotazione VALUES (8, 1);
INSERT INTO OrdinePrenotazione VALUES (9, 6);
INSERT INTO OrdinePrenotazione VALUES (10, 5);
INSERT INTO OrdinePrenotazione VALUES (11, 12);
INSERT INTO OrdinePrenotazione VALUES (12, 13);
INSERT INTO OrdinePrenotazione VALUES (13, 14);
INSERT INTO OrdinePrenotazione VALUES (14, 15);

/*modifica img */
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (3, 10, "10:30","", false,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (10, 20, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (5, 12, "16:00","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (5, 12, "10:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (3, 10, "10:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (7, 14, "16:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (7, 14, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (6, 13, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (6, 10, "16:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (10, 20, "16:30","", false,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (8, 15, "16:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (8, 15, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (9, 16, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (9, 16, "10:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (3, 10, "18:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (3, 10, "18:00","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (5, 12, "16:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (4, 11, "10:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (4, 11, "10:30","", true,"");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, tipo, disp, img) VALUES (8, 15, "16:30","", true,"");

INSERT INTO PrenotazioneTavolo VALUES (2, 1);
INSERT INTO PrenotazioneTavolo VALUES (1, 19);
INSERT INTO PrenotazioneTavolo VALUES (3, 4);
INSERT INTO PrenotazioneTavolo VALUES (4, 6);
INSERT INTO PrenotazioneTavolo VALUES (5, 10);
INSERT INTO PrenotazioneTavolo VALUES (6, 20);
INSERT INTO PrenotazioneTavolo VALUES (7, 9);


INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("", "Via Alfonso D'amico 8", "84013", "Cava De' Tirreni", "SA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Roma 128", "84121", " Salerno", "SA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Eduardo Russo 13", "20019", " Milano", "MI");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Umbero I", "00118", "Roma", "RM");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Celeste 43", "84013", "Fisciano", "SA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Michele Di Gioia 3", "84084", "Cava De' Tirreni", "SA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via San Gennaro 54", "80016", "Napoli", "NA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via San Nicola 121", "100024", "Torino", "TO");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Monticelli 10", "94100", "Enna", "EN");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Giovanni Manci 88", "07100", "Sassari", "SS");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Stefano D'Autore 42", "53100", "Siena", "SI");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Bruno Orlandi 65", "17100", "Savona", "SV");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Loredana Dandi 298", "35100", "Padova", "PD");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Roma 200", "86100", "Campobasso", "CB");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via San Nicola 12", "81100", "Caserta", "CE");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via San Franco 11", "48121", "Ravenna", "RA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Domenico Linci 34", "20019", "Milano", "MI");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via San Fabio Ruocco 78", "00118", "Roma", "RM");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Maria Immacolata 44", "80016", "Napoli", "NA");
INSERT INTO Indirizzo(nome, indirizzo, cap, citta, provincia) VALUES ("","Via Fatima Delmo 56", "35100", "Padona", "PD");

INSERT INTO Ha VALUES (1, "honejmoon");
INSERT INTO Ha VALUES (2, "manuelito");
INSERT INTO Ha VALUES (3, "luds");
INSERT INTO Ha VALUES (4, "marja");
INSERT INTO Ha VALUES (5, "lucas");
INSERT INTO Ha VALUES (6, "giovanni69");
INSERT INTO Ha VALUES (7, "marcella_");
INSERT INTO Ha VALUES (8, "valecri");
INSERT INTO Ha VALUES (9, "saetta");
INSERT INTO Ha VALUES (10, "vince");
INSERT INTO Ha VALUES (11, "consi03");
INSERT INTO Ha VALUES (12, "dima7");
INSERT INTO Ha VALUES (13, "enzos");
INSERT INTO Ha VALUES (14, "fabbb");
INSERT INTO Ha VALUES (15, "nancy99");
INSERT INTO Ha VALUES (16, "cateMary");
INSERT INTO Ha VALUES (17, "francs");
INSERT INTO Ha VALUES (18, "davjde");
INSERT INTO Ha VALUES (19, "ross_");
INSERT INTO Ha VALUES (10, "ilarya");

/*modifica img*/
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","PC", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","Console", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","PC", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","Console", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30", "Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30", "Console", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30", "PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30", "PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30", "Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30", "PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","PC", 30, false,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("14:30 - 16:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","Console", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("9:30 - 11:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","PC", 30, true,"");
INSERT INTO Postazione(ora, tipo, prezzo, disp, img) VALUES("18:30 - 20:30","Console", 30, true,"");

INSERT INTO PrenotazionePostazione VALUES(8, 1);
INSERT INTO PrenotazionePostazione VALUES(9, 2);
INSERT INTO PrenotazionePostazione VALUES(10, 3);
INSERT INTO PrenotazionePostazione VALUES(11, 4);
INSERT INTO PrenotazionePostazione VALUES(12, 5);
INSERT INTO PrenotazionePostazione VALUES(13, 6);
INSERT INTO PrenotazionePostazione VALUES(14, 7);
