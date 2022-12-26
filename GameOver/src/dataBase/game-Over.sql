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
    tipo varchar(15) not null,
    descrizione varchar(1500) not null,
    img1 varchar(50) not null,
    img2 varchar(50) not null,
    img3 varchar(50) not null,
    img4 varchar(50) not null,
    img5 varchar(50) not null
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
    iva double not null,
    numeroProdotti integer not null
    
);

create table Riguarda(
    id integer not null,
    idOrdine integer not null,
    
    primary key(id, idOrdine),
    foreign key(id) references Videogioco(id) on update cascade on delete cascade,
    foreign key(idOrdine) references Ordine(idOrdine) on update cascade on delete cascade
);

create table Prenotazione(
    idPrenotazione integer primary key auto_increment,
    utente varchar(30) not null,
    prezzo double not null,
    postiPrenotati integer not null,
    ora varchar(10) not null
 
);

create table OrdinePrenotazione(
    idPrenotazione integer not null,
    idOrdine integer not null,
    
    primary key(idPrenotazione, idOrdine),
    foreign key(idPrenotazione) references Prenotazione(idPrenotazione) on update cascade on delete cascade,
    foreign key(idOrdine) references Ordine(idOrdine) on update cascade on delete cascade
);

create table Tavolo(
	idTavolo integer primary key auto_increment,
    numeroPosti integer not null,
    prezzoPosto double not null,
    ora varchar(5) not null,
    img varchar(50) not null
);

create table PrenotazioneTavolo(
    idPrenotazione integer not null,
    idTavolo integer not null,
    
    primary key(idPrenotazione, idTavolo),
    foreign key(idPrenotazione) references Prenotazione(idPrenotazione) on update cascade on delete cascade,
    foreign key(idTavolo) references Tavolo(idTavolo) on update cascade on delete cascade
);

create table Indirizzo(
    idIndirizzo integer primary key auto_increment,
    via varchar(50) not null,
    cap integer not null,
    citta varchar(30) not null,
    provincia char(2) not null
    
);

create table Ha(
    idIndirizzo integer not null,
    username varchar(30) not null,
    
    primary key(idIndirizzo, username),
    foreign key(idIndirizzo) references Indirizzo(idIndirizzo) on update cascade on delete cascade,
    foreign key(username) references Utente(username) on update cascade on delete cascade
);

create table Postazione(
	idPostazione integer not null primary key auto_increment,
    ora varchar(5) not null,
    prezzo double not null,
    img varchar(50) not null
    );
    
create table PrenotazionePostazione(
    idPrenotazione integer not null,
    idPostazione integer not null,
    
    primary key(idPrenotazione, idPostazione),
    foreign key(idPrenotazione) references Prenotazione(idPrenotazione) on update cascade on delete cascade,
    foreign key(idPostazione) references Postazione(idPostazione) on update cascade on delete cascade
);