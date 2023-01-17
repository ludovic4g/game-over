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
    prodotti varchar(100) not null,
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
    ora time not null
 
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
    ora varchar(5) not null,
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
    indirizzo varchar(50) not null,
    cap char(5) not null,
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
    ora varchar(5) not null,
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



/* modificare risposta*/
INSERT INTO Utente VALUES ("honejmoon", "Benedetta7.", "benedetta@gmail.com", "Benedetta", "Rossetti", "07/11/2001", "femmina","", false, false, false);
INSERT INTO Utente VALUES ("manuelito", "Manuelsica1.", "manuel@gmail.com", "Manuel", "Sica", "24/05/2001","maschio", "", false, false, false);
INSERT INTO Utente VALUES ("luds", "Ludovica2.", "ludovica@gmail.com", "Ludovica", "Genovese", "05/06/01","femmina", "", false, false, false);
INSERT INTO Utente VALUES ("marja", "Mariarossi5.", "maria@gmail.com", "Maria", "Rossi", "07/03/1996", "femmina","", false, false, false);
INSERT INTO Utente VALUES ("lucas", "Lucaverdi6.", "luca@gmail.com", "Luca", "Verdi", "20/01/2003","maschio", "", false, false, false);
INSERT INTO Utente VALUES ("giovanni69", "Giovanni3.", "giovanni@gmail.com", "Giovanni", "Bianchi", "25/12/1999","maschio", "", false, false, false);
INSERT INTO Utente VALUES ("marcella_", "Marcella1.", "marcella@gmail.com", "Marcella", "Vitale", "03/04/2000", "no binary","", false, false, false);
INSERT INTO Utente VALUES ("valecri", "Valeriacrispo9.", "valeria@gmail.com", "Valeria", "Crispo", "10/11/1994","femmina", "", false, false, false);
INSERT INTO Utente VALUES ("saetta", "Amedeosae2.", "amedeo@gmail.com", "Amedeo", "Saetta", "15/07/2001","maschio", "", false, false, false);
INSERT INTO Utente VALUES ("vince", "Vincenzo9.", "vincenzo@gmail.com", "Vincenzo", "Sorrentino", "06/11/2001","no binary", "", false, false, false);
INSERT INTO Utente VALUES ("consi03", "Consiglia6.", "consiglia@gmail.com", "Consiglia", "Lamberi", "01/07/1995","femmina", "", false, false, false);
INSERT INTO Utente VALUES ("Dima7", "Dimitrika16.", "dimitri@gmail.com", "Dimitri", "Kambulatov", "16/10/1992", "maschio","", false, false, false);
INSERT INTO Utente VALUES ("Enzos", "Enzoverdi4.", "enzo@gmail.com", "Vincenzo", "Verdi", "29/12/1995","maschio", "", false, false, false);
INSERT INTO Utente VALUES ("Fabbb", "Fabioava5.", "fabio@gmail.com", "Fabio", "Avagliano", "11/11/1996", "maschio","", false, false, false);
INSERT INTO Utente VALUES ("Nancy99", "Nunziatorre8.", "nunzia@gmail.com", "Nunzia", "Torre", "18/04/2002", "femmina","", false, false, false);
INSERT INTO Utente VALUES ("CateMary", "Caterina4.", "cayerina@gmail.com", "Caterina Maria", "Di Giacomo", "23/07/1993","no binary", "", false, false, false);
INSERT INTO Utente VALUES ("Francs", "Francesca0.", "francesca@gmail.com", "Francesca", "D'Aloia", "03/04/1987","no binary", "", false, false, false);
INSERT INTO Utente VALUES ("Davjde", "Davideanno5.", "davide@gmail.com", "Davide", "Dell'Anno", "24/05/1990", "no binary","", false, false, false);
INSERT INTO Utente VALUES ("Ross_", "Rossella2.", "rossella@gmail.com", "Rossella", "Senatore", "20/08/1998", "femmina","", false, false, false);
INSERT INTO Utente VALUES ("Ilarya", "Ilariasalvo0.", "ilaria@gmail.com", "Ilaria", "Salvo", "26/09/1999", "femmina","", false, false, false);

/*modifica quantita, magazzino e immagini*/
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("FIFA 23 Legacy Edition", 40, 2022, "avventura", "FIFA 23 Legacy Edition include divise, club e rose originali di alcuni dei principali campionati del mondo. Conterrà inoltre diverse tra le migliori squadre di club femminili e alcuni dei più famosi stadi al mondo, compresi alcuni inediti, una veste grafica rinnovata e un nuovo pacchetto che comprende telecronaca e grafiche aggiornate durante le partite. FIFA 23 Legacy Edition presenterà le stesse modalità e caratteristiche a livello di gameplay già viste in FIFA 22 Legacy Edition, senza novità o migliorie di rilievo.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Gran Turismo® 7", 80, 2022, "PS4, PS5", "Piloti competitivi e occasionali, collezionisti, amanti della messa a punto, progettisti di livree e fotografi: tutti troveranno la loro traiettoria grazie alle fantastiche modalità di gioco offerte, incluse le popolari modalità campagna, Arcade e Accademia di guida. Grazie al ritorno della leggendaria modalità GT Simulation, acquista, metti a punto e gareggia nel corso dell'appagante campagna per giocatore singolo man mano che sblocchi nuove auto e sfide. Se ami la competizione diretta, affina le tue abilità e gareggia nella modalità Sport. Con oltre 420 auto disponibili in Brand Central e nel concessionario di auto usate fin dal primo giorno, Gran Turismo 7 ricrea l'aspetto e le sensazioni di guida di auto classiche e moderne supercar con un livello di dettaglio senza precedenti. Ogni auto si comporta diversamente sugli oltre 90 tracciati, inclusi alcuni circuiti classici della storia di GT, con condizioni climatiche dinamiche.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Horizon Forbidden West", 80, 2022, "PS4, PS5", "Esplora terre remote, combatti contro macchine ancora più grandi e terrificanti e incontra nuove e stupefacenti tribù al tuo ritorno nel lontano futuro post-apocalittico di Horizon. La terra sta morendo. Violente tempeste e una piaga inarrestabile funestano quel poco che resta dell'umanità, mentre nuove e tremende macchine vanno a caccia lungo i confini. La vita sulla Terra sembra destinata a una nuova estinzione e nessuno ne conosce il motivo. Toccherà ad Aloy scoprire i segreti che si celano dietro queste insidie per riportare ordine ed equilibrio nel mondo. In questo viaggio incontrerà vecchie conoscenze, stringerà alleanze con nuove fazioni in guerra e farà luce sull'eredità dell'antico passato, tutto questo cercando di avere la meglio su un nemico apparentemente invincibile.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Marvel's Spider-Man: Miles Morales", 60, 2020, "PS4, PS5, PC", "Nell'ultima avventura della serie Marvel's Spider-Man, l'adolescente Miles Morales cerca di ambientarsi in un nuovo quartiere mentre segue le orme del suo mentore, Peter Parker, come nuovo Spider-Man. Ma quando una feroce lotta per il potere minaccia di distruggere la sua nuova casa, l'aspirante eroe capisce che da grandi poteri derivano grandi responsabilità. Per salvare la New York della Marvel, Miles deve raccogliere il testimone di Spider-Man e dimostrarsi all'altezza.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Pokémon Violetto", 60, 2022, "Nintendo Switch", "La serie Pokémon si evolve in un modo tutto nuovo con Pokémon Violetto per Nintendo Switch. Parti all'avventura con i tuoi amici ed esplora liberamente un ricco e vasto mondo.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Super Mario Odyssey", 60, 2017, "Nintendo Switch", "Mario girerà intorno al mondo a bordo di una nave volante chiamata Odyssey. La nave viene alimentata e preparata al viaggio tra un regno e l'altro tramite le lune di energia. Chi può dire quali straordinari luoghi scoprirà nel corso della sua odissea?");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Minecraft", 30, 2018, "Nintendo Switch", "Il nuovo Minecraft è arrivato e include tutti gli ultimi aggiornamenti come Update Aquatic, il supporto al gioco cross-play†† e l'accesso a una moltitudine di contenuti del Minecraft Marketplace.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Crash Bandicoot™ N. Sane Trilogy", 40, 2018, "Nintendo Switch", "Crash Bandicoot™, il tuo marsupiale preferito, è tornato! Più bello e scatenato che mai, è pronto a lanciarsi nelle danze nella collezione Trilogia N. Sane. Un Crash Bandicoot come non l'avevi mai visto prima! Gira, salta e balla affrontando sfide e avventure epiche nei tre giochi che hanno dato inizio alla leggenda: Crash Bandicoot™, Crash Bandicoot™ 2: Il Ritorno di Cortex e Crash Bandicoot™ 3: Teletrasportato. Rivivi i tuoi momenti preferiti in tutto lo splendore grafico dell'HD completamente rimasterizzato per un divertimento in grande stile!");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Witcher 3: Wild Hunt", 40, 2021, "Nintendo Switch", "Vincitore di più di 250 premi Game of the Year, The Witcher 3: Wild Hunt è un gioco narrativo con un mondo aperto ambientato in un cupo universo fantasy. Sei Geralt di Rivia, cacciatore di mostri mercenario. Hai a disposizione tutti i ferri del mestiere: spade affiliate come rasoi, letali pozioni, balestre silenziose e potenti magie di combattimento. Davanti a te si stende un continente devastato dalla guerra e infestato dai mostri, che potrai esplorare a piacimento. Il tuo incarico? Trovare una ragazza oggetto di una profezia, un’arma vivente che può cambiare il mondo.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Ratchet & Clank: Rift Apart", 50, 2020, "PS5", "Viaggia tra le dimensioni con Ratchet e Clank e affronta un malvagio imperatore proveniente da un'altra realtà. Salta come un fulmine tra mondi ricchi d'azione, tutti immersi in panorami mozzafiato e completi di un arsenale totalmente folle, quando l'avventura farà il suo arrivo sulla console PS5™.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("UNCHARTED: Raccolta L'eredità dei ladri", 50, 2022, "PS5, PC", "Diventa una leggenda e lascia il segno in UNCHARTED: Raccolta L'eredità dei ladri. Vivi il pathos, la narrazione cinematografica e l'iconico franchise dei titoli campioni di incassi più elettrizzanti di Naughty Dog. Scopri le imprese del passato con i ladri Nathan Drake e Chloe Frazer, personaggi tanto carismatici quanto complessi, mentre viaggiano per il mondo in cerca di avventure e storie straordinarie.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("DEATH STRANDING DIRECTOR'S CUT", 40, 2022, "PS5", "Dal leggendario creatore di giochi Hideo Kojima arriva un'esperienza che sfida il genere, ora ampliata e rimasterizzata per PS5 in questa DIRECTOR'S CUT definitiva.Nel futuro, un misterioso evento noto come Death Stranding ha aperto un varco tra il regno dei vivi e quello dei morti, permettendo alle creature dell'aldilà di vagare in un mondo ormai segnato da una società in declino.Nei panni di Sam Bridges, la tua missione sarà quella di portare speranza all'umanità mettendo in contatto gli ultimi sopravvissuti di un'America decimata.Riuscirai a riunificare un mondo in frantumi, un passo alla volta?");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Sackboy: Una Grande Avventura", 30, 2020, "PS4, PS5, PC", "Sackboy, l'iconico eroe dell'universo PlayStation®, torna a vivere avventure mozzafiato in un gigantesco, appassionante e frenetico platform 3D multigiocatore... con nuove e pupazzose abilità!");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Last of Us™ Part I", 80, 2022, "PS5", "Riscopri la straordinaria narrazione e gli indimenticabili personaggi di The Last of Us, vincitore di oltre 200 premi Game of the Year. In una civiltà senza futuro, dove imperversano infetti e criminali, un uomo ormai segnato dalla vita, Joel, viene ingaggiato per condurre una ragazzina di 14 anni, Ellie, fino a una zona di quarantena militare. Ma quello che in principio sembra un incarico irrilevante, diventa presto un logorante viaggio attraverso l'intera nazione");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("God of War Ragnarök", 80, 2022, "PS4, PS5", "È in arrivo dagli sviluppatori di Santa Monica Studio il sequel dell'apprezzatissimo God of War (2018). Il Fimbulwinter si fa già sentire. Kratos e Atreus devono esplorare ognuno dei nove regni alla ricerca di risposte, mentre le milizie di Asgard si preparano a un'annunciata battaglia che segnerà la fine del mondo.‎ Nel loro cammino si immergeranno in splendidi panorami mitici e affronteranno temibili nemici sotto forma di dèi norreni e mostri. La minaccia del Ragnarök si avvicina sempre di più. Kratos e Atreus devono scegliere tra la salvezza della loro famiglia e quella dei regni.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("EA SPORTS™ FIFA 23", 90, 2022, "PS4, PS5", "EA SPORTS™ FIFA 23 porta il gioco più bello del mondo sul campo, con i tornei della Coppa del Mondo FIFA™ maschile e femminile, l'aggiunta di squadre di club femminili e nuovi modi di giocare le tue modalità preferite. I progressi della tecnologia HyperMotion2 portano in campo un'azione e un realismo sempre più sorprendenti su PS5. Con il doppio della quantità di acquisizione di movimento reale, ora le animazioni calcistiche sono più numerose che mai in ogni partita.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("The Callisto Protocol", 70, 2022, "PS4, PS5", "In questo gioco horror narrativo in terza persona, ambientato 300 anni nel futuro, il giocatore veste i panni di Jacob Lee, uno sfortunato prigioniero rinchiuso nella prigione di Black Iron, carcere di massima sicurezza situato su Callisto, la luna morta di Giove. Quando gli altri detenuti iniziano a trasformarsi in creature da incubo, la prigione piomba nel caos. Per sopravvivere, Jacob dovrà farsi strada con la forza verso la libertà e scoprire gli oscuri e inquietanti segreti sepolti sotto la superficie di Callisto. ");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("NBA 2K23", 80, 2022, "PS4, PS5", "Competi nei panni delle tue squadre e delle tue stelle NBA e WNBA preferite e goditi il meglio del gameplay immersivo. Con una presentazione grafica all'avanguardia, un'intelligenza artificiale dei giocatori migliorata, formazioni aggiornate e squadre storiche, in NBA 2K23 il gioco è più reale e completo che mai. Senti l'energia della folla, l'intensità della competizione e l'intrattenimento senza fine di uno dei videogiochi sportivi più coinvolgenti del momento.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Elden Ring", 70, 2022, "PS4, PS5", "Nell'Interregno governato dalla regina Marika l'Eterna, l'Anello ancestrale, sorgente dell'Albero Madre, è andato in frantumi. I discendenti di Marika, tutti semidei, rivendicarono i frammenti dell'Anello ancestrale, conosciuti col nome di rune maggiori, e la corruzione folle della loro nuova forza scatenò una guerra: la Disgregazione. Una guerra che portò all'abbandono della Volontà superiore.");
INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES ("Gotham Knights", 75, 2022, "PS4, PS5", "Gotham Knights è un gioco di ruolo d'azione open world ambientato nella Gotham City più dinamica e interattiva mai vista prima d'ora. Pattuglia i cinque distretti di Gotham in modalità giocatore singolo o insieme a un altro eroe e sventa le attività criminali in cui ti imbatti.");


INSERT INTO Compra VALUES ("honejmoon", 3);
INSERT INTO Compra VALUES ("honejmoon", 1);
INSERT INTO Compra VALUES ("honejmoon", 2);
INSERT INTO Compra VALUES ("vince", 8);
INSERT INTO Compra VALUES ("vince", 5);
INSERT INTO Compra VALUES ("CateMary", 10);
INSERT INTO Compra VALUES ("Davjde", 18);
INSERT INTO Compra VALUES ("Davjde", 15);
INSERT INTO Compra VALUES ("Ross_", 20);
INSERT INTO Compra VALUES ("Ross_", 11);
INSERT INTO Compra VALUES ("Ross_", 13);
INSERT INTO Compra VALUES ("Dima7", 1);
INSERT INTO Compra VALUES ("saetta", 4);
INSERT INTO Compra VALUES ("Fabbb", 6);
INSERT INTO Compra VALUES ("marcella_", 9);
INSERT INTO Compra VALUES ("marcella_", 7);
INSERT INTO Compra VALUES ("marcella_", 12);
INSERT INTO Compra VALUES ("Francs", 14);
INSERT INTO Compra VALUES ("Ilarya", 16);
INSERT INTO Compra VALUES ("Ilarya", 20);

/* modificare il prezzo totale, prodotti e stato*/
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("honejmoon", "2022-04-05", 40, 10, 4);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("vince", "2023-01-05", 40, 10, 3);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("CateMary", "2022-08-10", 40, 10, 2);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Davjde", "2022-11-20", 40, 10, 3);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Ross_", "2023-01-18", 40, 10, 4);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Dima7", "2022-12-25", 40, 10, 3);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("saetta", "2022-09-05", 40, 10, 2);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Fabbb", "2023-01-01", 40, 10, 1);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("marcella_", "2022-06-15", 40, 10, 3);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Francs", "2023-01-20", 40, 10, 2);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Ilarya", "2022-10-29", 40, 10, 3);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("Manuelito", "2023-01-29", 30, 10, 1);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("gioovanni69", "2022-10-12", 30, 10, 1);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("marja", "2022-9-29", 30, 10, 1);
INSERT INTO Ordine(utente, dataAcquisto, prodotti, prezzoTotale, iva, numeroProdotti, stato) VALUES ("luds", "2022-01-21", 30, 10, 1);

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

INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("vince", 44, 4, "20:30:03");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Dima7", 30, 3, "14:23:00");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("saetta", 60, 5, "18:11:09");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Ilarya", 98, 7, "11:05:29");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Franc", 200, 10, "22:48:56");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("CateMary", 120, 8, "15:19:33");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Davjde", 60, 6, "19:56:02");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("honejmoon", 30, 1, "20:30:03");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Dima7", 30, 1, "18:23:00");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("Ross_", 30, 1, "10:11:09");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("manuelito", 30, 1, "19:05:29");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("giovanni69", 30, 1, "23:48:56");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("marja", 30, 1, "11:19:33");
INSERT INTO Prenotazione(utente, prezzoTotale, postiPrenotati, time) VALUES ("luds", 30, 1, "18:56:02");


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

/*modifica disponibilità e img*/
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (3, 10, "10:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (10, 20, "22:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (5, 12, "12:00");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (5, 12, "11:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (3, 10, "11:00");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (7, 14, "18:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (7, 14, "19:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (6, 13, "21:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (6, 10, "22:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (10, 20, "16:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (8, 15, "17:00");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (8, 15, "18:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (9, 16, "21:00");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (9, 16, "15:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (3, 10, "20:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (3, 10, "22:00");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (5, 12, "20:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (4, 11, "12:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (4, 11, "19:30");
INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, disp, img) VALUES (8, 15, "23:00");

INSERT INTO PrenotazioneTavolo VALUES (2, 1);
INSERT INTO PrenotazioneTavolo VALUES (1, 19);
INSERT INTO PrenotazioneTavolo VALUES (3, 4);
INSERT INTO PrenotazioneTavolo VALUES (4, 6);
INSERT INTO PrenotazioneTavolo VALUES (5, 10);
INSERT INTO PrenotazioneTavolo VALUES (6, 20);
INSERT INTO PrenotazioneTavolo VALUES (7, 9);


INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Alfonso D'amico 8", "84013", "Cava De' Tirreni", "SA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Roma 128", "84121", " Salerno", "SA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Eduardo Russo 13", "20019", " Milano", "MI");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Umbero I", "00118", "Roma", "RM");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Celeste 43", "84013", "Fisciano", "SA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Michele Di Gioia 3", "84084", "Cava De' Tirreni", "SA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via San Gennaro 54", "80016", "Napoli", "NA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via San Nicola 121", "100024", "Torino", "TO");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Monticelli 10", "94100", "Enna", "EN");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Giovanni Manci 88", "07100", "Sassari", "SS");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Stefano D'Autore 42", "53100", "Siena", "SI");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Bruno Orlandi 65", "17100", "Savona", "SV");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Loredana Dandi 298", "35100", "Padova", "PD");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Roma 200", "86100", "Campobasso", "CB");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via San Nicola 12", "81100", "Caserta", "CE");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via San Franco 11", "48121", "Ravenna", "RA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Domenico Linci 34", "20019", "Milano", "MI");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via San Fabio Ruocco 78", "00118", "Roma", "RM");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Maria Immacolata 44", "80016", "Napoli", "NA");
INSERT INTO Indirizzo(indirizzo, cap, citta, privincia) VALUES ("Via Fatima Delmo 56", "35100", "Padona", "PD");

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
INSERT INTO Ha VALUES (12, "Dima07");
INSERT INTO Ha VALUES (13, "Enzos");
INSERT INTO Ha VALUES (14, "Fabbb");
INSERT INTO Ha VALUES (15, "Nancy99");
INSERT INTO Ha VALUES (16, "CateMary");
INSERT INTO Ha VALUES (17, "Francs");
INSERT INTO Ha VALUES (18, "Davjde");
INSERT INTO Ha VALUES (19, "Ross");
INSERT INTO Ha VALUES (10, "Ilarya");

/*modifica disponibilità e img*/
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("20:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("21:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("22:00", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("22:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("18:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("19:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("17:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("11:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("12:30", 30);
INSERT INTO Postazione(ora, prezzo, disp, img) VALUES("14:30", 30);

INSERT INTO PrenotazionePostazione VALUES(1, 8);
INSERT INTO PrenotazionePostazione VALUES(2, 9);
INSERT INTO PrenotazionePostazione VALUES(3, 10);
INSERT INTO PrenotazionePostazione VALUES(4, 11);
INSERT INTO PrenotazionePostazione VALUES(5, 12);
INSERT INTO PrenotazionePostazione VALUES(6, 13);
INSERT INTO PrenotazionePostazione VALUES(7, 14);
