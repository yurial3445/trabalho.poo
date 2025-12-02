CREATE DATABASE IF NOT EXISTS controle_projetos;
USE controle_projetos;

CREATE TABLE IF NOT EXISTS responsavel (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(25) NOT NULL,
);

CREATE TABLE IF NOT EXISTS projeto (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    data_ini DATE,
    data_fim DATE,
    id_responsavel INT NOT NULL,
    FOREIGN KEY (id_responsavel) REFERENCES responsavel(id)
);

CREATE TABLE IF NOT EXISTS tarefa (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    status_tarefa VARCHAR(50),
    data_ini DATE NOT NULL,
    data_fim DATE NOT NULL,
    id_projeto INT NOT NULL,
    FOREIGN KEY (id_projeto) REFERENCES projeto(id)
);

INSERT INTO responsavel (nome, email, telefone) VALUES
('Douglas', 'dou.@gmail.com', '99345859'),
('Yuri', 'yuri@gmail.com', '945887575'),
('Mateus', 'mts@gmail.com', '99876899');
