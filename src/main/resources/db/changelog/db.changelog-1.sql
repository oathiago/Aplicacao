-- liquibase formatted sql

-- changeset thiago.oliveira:1.0 dbms:mysql

create table application.company
(
	id bigint auto_increment,
	name varchar(100) not null,
	document varchar(21) not null,
	salary decimal(10,2) null,
	age integer null,
	vacancies integer not null,
    site varchar(255) not null,
	constraint company_pk
		primary key (id)
);

-- changeset thiago.oliveira:1.1 dbms:mysql

create table application.user
(
	id bigint auto_increment,
	name varchar(100) not null,
	document varchar(21) not null,
	salary decimal(10,2) null,
	age integer null,
	login varchar (100) not null,
	password varchar (255) not null,
	company_id bigint,
	constraint user_pk
		primary key (id),
    constraint user_company_id_fk
		foreign key (company_id) references application.company (id)
);

-- changeset thiago.oliveira:1.2 dbms:mysql
alter table company drop column salary;
alter table company drop column age;


-- changeset thiago.oliveira:1.3 dbms:mysql

CREATE TABLE application.role
(
    id bigint auto_increment,
    name varchar(255) not null,
    constraint role_pk
        primary key (id)
);

-- changeset thiago.oliveira:1.4 dbms:mysql

INSERT INTO role (name)
    values('ADMIN');
INSERT INTO role (name)
    values('CLIENT');

-- changeset thiago.oliveira:1.5 dbms:mysql

CREATE TABLE user_role
(
    id bigint not null auto_increment,
    user_id bigint,
    role_id bigint,
    constraint user_role_pk
		primary key (id),
    constraint user_role_user_fk
		foreign key (user_id) references application.user (id),
    constraint user_role_role_fk
		foreign key (role_id) references application.role (id)
);

-- changeset thiago.oliveira:1.6 dbms:mysql
ALTER TABLE user
    CHANGE login username VARCHAR(255) NOT NULL;

-- changeset thiago.oliveira:1.7 dbms:mysql
insert into user (name, document, username, password, age)
values ('Thiago Oliveira', '073.167.186-41', 'oathiago', '12345678', 31);

-- changeset thiago.oliveira:1.8 dbms:mysql
insert into user_role (user_id, role_id)
values ((select max(id) from user), (select min(id) from role));