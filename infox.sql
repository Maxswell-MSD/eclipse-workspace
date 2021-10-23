

/**
Agenda de contatos
Aluno: Maxswell Sousa Diniz
Curso: Técnico em informática - Senac Tatuapé - SP

Atividade Projeto Banco de dados usários - iniciado em 1/09/2021

*/

-- Pesquisar bancos de dados disponíveis
show databases;

-- Criando um banco de dados
create database dbinfox;


-- Selecionar o banco de dados sempre que for trabalha sempre tem que iniciar
use dbinfox;




-- Remover um banco de dados
drop database dbinfox;



-- Verificar tabelas 
show tables;

-- Criando uma tabela no baco de dados
create table usuarios(
id int primary key auto_increment,
usuario varchar(100) not null,
login varchar(100) not null unique,
senha varchar(250) 
);
select * from usuarios;	
-- Criando usuário e fazendo 
insert into usuarios (usuario,login, senha) values ('Maxswell','maxswellsousadiniz@yahoo.com', md5('1234'));
insert into usuarios (usuario,login, senha) values ('Carla','carla@email.com', md5('1234'));
-- Fazendo verificação de usuário para ligar com Eclipse
select * from usuarios where login ='maxswellsousadiniz@yahoo.com' and senha= md5('1234');

-- Linha de Editar ou Update de Usuário
update usuarios set usuario='Maxswell Diniz',login='maxswell@email.com',senha=md5('6936995591845880') where id=5;
-- Para excluir usuário sempre pelo id
delete from usuarios where id=4;

-- Codigo infox no banco de dados p

select * from usuarios;
select * from usuarios where id = 1;
select * from usuarios where login='admin@email.com' and senha=md5('123456');



update usuarios set usuario='Leandro Pereira Ramos',login='ramos@email.com',senha=md5('1234') where id=3;



-- Comando usado para descrever a tabela
describe usuarios;
select * from usuarios;

-- CRUD Criando o cadastro de banco de dados sem colocar o id cujo ele automáticamente distribui para diferênciar um cadastro igual
insert into usuarios (usuario,login, senha) values ('Camila','camila@gmail.com','12345');

-- Armazenando um campo com criptografia
insert into usuarios (usuario,login, senha) values ('Daniel','danielalmeida@gmail.com', md5('1234'));
insert into usuarios (usuario,login, senha) values ('camila','camilaferraz@gmail.com', md5('46584'));
insert into usuarios (usuario,login, senha) values ('Bruna','Brunapereira@yahoo.com', md5('48754545'));
insert into usuarios (usuario,login, senha) values ('marcio','marcioalgusto@outlook.com', md5('42125454546'));
insert into usuarios (usuario,login, senha) values ('Betina','Betinafernandez@gmail.com', md5('4456464654'));


select * from usuarios where login='camilaferraz@gmail.com' and senha=md5('46584');




-- Tabela de clientes (clientes da empresa)
create table clientes(
   idCli int primary key auto_increment,
   nome varchar(50) not null,
   fone varchar(15) not null
   );
   
   
   -- Cadastro de clientes

insert into clientes (nome,fone) values('carlos','787454645');
insert into clientes (nome,fone) values('fernanda','91234-1111');

describe clientes;
select * from clientes;
delete from clientes where idCli=3;
drop table clientes;

-- no Mysql faça uma pesquisa diferente de usuário seguindo os devidos passos esse j% trás somente nomes com essa letra e assim serve para outra pesquisa.
 select * from clientes where nome like 'c%';

   
   
   
   -- Tabela de ordem de serviço (OS)
create table tbos(
   os int primary key auto_increment,
   equipamento varchar(250) not null,
   defeito varchar(250) not null,
   dataos timestamp default current_timestamp,
   statusos varchar(50) not null,
   valor decimal(10,2),
   idCli int not null,
   foreign key(idCli) references clientes (idCli)
   );
  describe tbos; 
  select * from tbos;
   
insert into tbos(equipamento,defeito,statusos,idcli)
values('Notebook Lenovo modelo','Não liga','Orçamento',1);


insert into tbos(equipamento,defeito,statusos,valor,idcli)
values('PC Positivo','Formatação do Windows','Aprovado',80,2);










-- Comando para remover uma tabela
drop table usuarios;
drop table clientes;
drop table tbos;



-- ordem alfabética pode selecionar todas as listas em ordem alfabética (asc)
select * from usuarios order by usuario asc;

-- Comando usado para apagar um campo da tabela
-- alter table (nome da tabela) drop column (nome da coluna);











