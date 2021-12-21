drop table if exists users;
create table users(
	id integer serial primary key,
	email varchar(50) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	losses integer,
	password varchar(50) not null,
	role integer not null,
	wins integer
	);
	
drop table if exists history;
create table history(
	game_id integer serial primary key,
	player_id integer not null,
	outcome integer,
	balance float,
	initialhand varchar(50) not null,
	dealerhand varchar(10) not null,
	recommend varchar(50) not null,
	followedrec boolean,
	numofdecks integer
	);
