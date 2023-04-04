drop database clinica;
create database clinica;
use clinica;
show databases;

create table ambulatorios (nroa int primary key auto_increment, andar numeric (3) not null, capacidade smallint);
create table medicos (codm int primary key auto_increment, nome varchar(40) not null, idade smallint not null, especialidade char (20), cpf numeric(11) unique, cidade varchar (30), fk_nroa int, foreign key (fk_nroa) references ambulatorios (nroa));
create table pacientes (codp int primary key auto_increment, nome varchar(40) not null, idade smallint not null, cidade char(30), cpf numeric(11) unique, doenca varchar(40) not null);
create table funcionarios (codf int primary key auto_increment, nome varchar(40) not null, idade smallint, cpf numeric(11) unique, cidade varchar(30), salario numeric (10), cargo varchar(20));
create table consultas (codm int primary key auto_increment, fk_codp int, foreign key (fk_codp) references pacientes (codp), data date, hora time);

show tables;

alter table funcionarios add column nroa int;

describe funcionarios;

alter table funcionarios drop column nroa;
alter table funcionarios drop column cargo;

insert into ambulatorios (andar, capacidade)
value (1, 30), (1, 50), (2, 40), (2, 25), (2, 55);

select * from ambulatorios;

insert into pacientes (nome, idade, cidade, cpf, doenca)
values ("Ana", 20, "Florianopolis", "20000200000", "gripe"),
		("Paulo", 24, "Palhoca", "20000220000", "fratura"),
        ("Lucia", 30, "Biguacu", "22000200000", "tendinite"),
        ("Carlos", 28, "Joinville", "11000110000", "sarampo");
        
select * from pacientes;

insert into funcionarios (nome, idade, cidade, salario, cpf)
values ("Rita", 32, "Sao Jose", 1200, "20000100000"),
	   ("Maria", 55, "Palhoca", 1220, "30000110000"),
       ("Caio", 45, "Florianopolis", 1100, "41000100000"),
       ("Carlos", 44, "Florianopolis", 1200, "51000110000"),
       ("Paula", 33, "Florianopolis", 2500, "61000111000");
       

select * from funcionarios;

insert into medicos (nome, idade, especialidade, cpf, cidade, fk_nroa)
values	("Joao", 40, "ortopedia", "10000100000", "Florianopolis", 1),
		("Maria", 42, "traumatologia", "10000110000", "Blumenau", 2),
        ("Pedro", 51, "pediatria", "11000100000","São José", 2),
        ("Carlos", 28, "ortopedia", "11000110000", "Joinville", null),
        ("Marcia", 33, "neurologia", "11000111000", "Biguacu", 3);