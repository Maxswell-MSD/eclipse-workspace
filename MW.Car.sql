/**
Agenda de contatos
Alunos: Wesley e Maxswell  (MW)
Curso: Técnico em informática - Senac Tatuapé - SP

- Criando Registro de Usuários do comércio ()
- Criando cadastro de cliente (x)
- Criando Ordem de Serviço de pedido de cliente (X)


Atividade Projeto Banco de dados usários - iniciado em 1/09/2021

*/
-- Pesquisar bancos de dados disponíveis
show databases;
-- Verificar tabelas disponível
show tables;

-- Criando um banco de dados
create database dbmw;


-- Remover um banco de dados
drop database dbmw;
-- iniciando banco de dados
use  dbmw;

-- (((((((((((((((((((((((((( INICIANDO CADASTRO DE USUÁRIO )))))))))))))))))))))))))))))))))))))))))))))))))))

create table dbmw.usuarios(
id int primary key auto_increment,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(250) 
);
select * from dbmw.usuarios;

-- Criando usuário e fazendo 
insert into usuario (usuario,login, senha) values ('Maxswell','maxswell@email.com', md5('1234'));
-- Fazendo verificação de usuário para ligar com Eclipse
select * from usuario where usuario ='Maxswell' and senha= md5('1234');


-- Cadastro CRUD de colaboradores
insert into usuarios (usuario,login,senha) values
 ('Daniel','danielemail.com','123');
 insert into usuarios (usuario,login,senha) values
 ('carlos','danielemail.com','124783');
-- Armazenando um campo com criptografia
insert into usuarios (usuario,login,senha) values ('Daniel','danielemail.com', md5('1234'));
insert into usuarios (usuario,login,senha) values ('carlos','danielemail.com', md5('124783'));


-- Verificar tabelas disponível
show tables;

-- Comando usado para descrever a tabela
describe usuarios;

select * from usuarios;










-- ((((((((((((((((((((((((((((((((((( finalizando cadastro de usuário ))))))))))))))))))))))))))))))))))))))))))))))))



-- (((((((((((((( INICIANDO TABELA DE CADASTRO DE CLIENTES ))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))

-- Criando tabela cadastro de clientes
create table clientes(
idcli int primary key auto_increment,
nome varchar(50) not null,
Cpf varchar(12)  not null unique,
email varchar(50) not null unique,
telefone varchar(15) not null,
cep varchar(12) not null,
endereco varchar (100) not null,
numero varchar (100) not null,
cidade varchar (16) not null,
bairro varchar (200) not null,
complemento varchar (100) not null


);
-- Verificar tabelas disponível
show tables;

-- Comando usado para descrever a tabela
describe clientes;


-- preenchimento não obrigatório
-- alter table clientes modify fone varchar(15); 

-- CRUD CREATE Criando Registro de clientes para teste 
insert into clientes (nome,cpf,email,telefone,cep,endereco,numero,cidade,bairro,complemento) values
 ('Camila','456512586-12','camila@gmail.com','8456-5455','8654-250','rua três coquinho','54','São paulo','Barão','Ao lado da pastelaria');
 
-- Criando pesquisas avançadas por nome 
select * from clientes where nome like 'm%';
 
 

select * from  clientes ;



-- -----------------------------  FINAL DA CONFIGURAÇÃO DE CADASTRO DE CLIENTES ------------------------------------------------------

-- (((((((((((((((((((((((((((((((((((( CIANDO TABELA DE ORDEM DE SERVIÇO ))))))))))))))))))))))))))))))))))))))))))))))))))))))))))

 create table OsMecanica(
 idm int primary key auto_increment,
veiculo varchar(100) not null,
marca varchar(10) not null,
modelo varchar(100) not null,
dataOsMecanica timestamp default current_timestamp,
ano varchar(10) not null,
placa varchar(10) not null,
defeito varchar(50) not null,
OSstatus varchar (100) not null,
valorpeca decimal(65) not null,
valorTotal decimal(65) not null,
idcli int not null,
foreign key(idcli) references clientes(idcli)

);

insert into OsMecanica (veiculo,marca,modelo,ano,placa,defeito,OSstatus,valorpeca,valorTotal,idcli)
 values('carro','Fiat','Palho','2008','Br34554','parachoque quebrado','Aprovado','400','200','1');
 

 
 
select * from OsMecanica ;

-- Comando usado para descrever a tabela
describe OsMecanica;

-- -----------------------------  FINAL DA CONFIGURAÇÃO DE ORDEM DE SERVIÇO ------------------------------------------------------

-- (((((((((((((((((((((((((((((((((((((((((((((((((( INICIANDO TABELA DE LAUDO TÉCNICO E ORÇAMENTO )))))))))))))))))))))))))))))))))))))))))))))))))))))))
create table laudo(
idla int primary key auto_increment,
analise varchar (250) not null,
solucao varchar(250) not null,
acessorios varchar(250) not null,
diaentrega varchar (250) not null,
idm int not null,
foreign key(idm) references OsMecanica(idm)

);
-- Comando usado para descrever a tabela
describe laudo;


insert into laudo (analise,solucao,acessorios,diaentrega,idm) 
values('Parachoque danificado','substituição de peça','parachoque','6 meses','500.00','1600',1);

insert into laudo (analise,solucao,acessorios,valorpeca,valorTotal,idm) 
values('Motor vela danificada ','Vela gasta','Nova vela','2 meses','200.00','1000',2);


select * from laudo ;

-- Comando usado para descrever a tabela
describe laudo;
-- -----------------------------  FINAL DA CONFIGURAÇÃO DE ORDEM DE SERVIÇO ------------------------------------------------------


-- CAMPO PARA DELETAR TABELA
drop table clientes;
drop table OsMecanica ;
drop table laudo ;
drop table usuarios ;

-- Comando usado para descrever a tabela



-- ((((((((((((((((((((((((( Campo para CRUD de Atualização, pesquisa e Delete ))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))





