-- liquibase formatted sql

-- changeset thiago.oliveira:1.0 dbms:mysql

create table company
(
	id bigint auto_increment,
	name varchar(100) not null,
	document varchar(13) not null,
	salary decimal(10,2) null,
	age integer null,
	vacancies integer not null,
    site varchar(255) not null,
	constraint company_pk
		primary key (id)
);

-- changeset thiago.oliveira:1.1 dbms:mysql

create table user
(
	id bigint auto_increment,
	name varchar(100) not null,
	document varchar(13) not null,
	salary decimal(10,2) null,
	age integer null,
	login varchar (100) not null,
	password varchar (255) not null,
	company_id bigint not null,
	constraint user_pk
		primary key (id),
    constraint user_company_id_fk
		foreign key (company_id) references connected.company (id)
);

