create database controle_projetos;
use controle_projetos;

create table responsavel(
	id integer primary key not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(25) not null
);

create table projeto (
	id integer primary key not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(100),
    data_ini date,
    data_fim date,
    id_responsavel integer not null,
    foreign key (id_responsavel) references responsavel(id)
);

create table tarefa(
	id integer primary key not null auto_increment,
    titulo varchar(100) not null,
    decricao varchar(100),
    status_tarefa varchar(100),
    data_ini date not null,
    data_fim date not null,
    id_projeto integer not null,
    foreign key (id_projeto) references projeto(id)
);
    

    
insert into Responsavel(nome, email, telefone)
values('Douglas','dou.@gmail.com','99345859');

insert into Responsavel(nome, email, telefone)
values('yuri','yuri@gmail.com', '945887575');

insert into Responsavel(nome, email, telefone)
values('mateus','mts@gmail.om','99876899');
