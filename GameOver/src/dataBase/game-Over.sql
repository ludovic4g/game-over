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
    descrizione varchar(1500) not null
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
    numeroProdotti int not null
    
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
    ora varchar(5) not null
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
    prezzo double not null
    );
    
create table PrenotazionePostazione(
    id integer not null,
    idPostazione integer not null,
    
    primary key(id, idPostazione),
    foreign key(id) references Prenotazione(id) on update cascade on delete cascade,
    foreign key(idPostazione) references Postazione(id) on update cascade on delete cascade
);