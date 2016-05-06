drop database if exists leilao;

create database leilao;

use leilao;

create table Leilao (
    id integer not null auto_increment,
    codigo varchar(255),
    dataHoraFim datetime not null,
    dataHoraInicio datetime not null,
    primary key (id)
) ENGINE=InnoDB;


create table Item (
    id integer not null auto_increment,
    nome varchar(255) not null,
    precoInicial decimal(19,2),
    leilao_id integer,
    primary key (id)
) ENGINE=InnoDB;

alter table Item 
    add constraint UK_Item_nome  unique (nome);

alter table Item 
    add constraint FK_Item_Leilao 
    foreign key (leilao_id) 
    references Leilao (id);


create table Categoria (
    Item_id integer not null,
    categorias varchar(255)
) ENGINE=InnoDB;

create table Usuario (
    email varchar(255) not null,
    nome varchar(255),
    sobrenome varchar(255),
    bairro varchar(255),
    cep varchar(255),
    cidade varchar(255),
    estado varchar(255),
    logradouro varchar(255),
    primary key (email)
) ENGINE=InnoDB;


create table Lance (
    id integer not null auto_increment,
    dataHora datetime not null,
    valor decimal(19,2),
    vencedor bit not null,
    item_id integer,
    usuario_email varchar(255),
    primary key (id)
) ENGINE=InnoDB;

alter table Lance 
    add constraint FK_Lance_Item
    foreign key (item_id) 
    references Item (id);

alter table Lance 
        add constraint FK_Lance_Usuario 
        foreign key (usuario_email) 
        references Usuario (email);

create table FormaDePagamento (
    id integer not null auto_increment,
    usuario varchar(255),
    primary key (id)
) ENGINE=InnoDB;

alter table FormaDePagamento 
    add constraint FK_FormaDePagamento_Usuario
    foreign key (usuario) 
    references Usuario (email);

create table CartaoDeCredito (
    anoExpiracao integer,
    mesExpiracao integer,
    numero varchar(255),
    id integer not null,
    primary key (id)
) ENGINE=InnoDB;

alter table CartaoDeCredito 
    add constraint FK_CartaoDeCredito_FormaDePagamento
    foreign key (id) 
    references FormaDePagamento (id);

create table ContaBancaria (
    agencia varchar(255),
    banco varchar(255),
    numero varchar(255),
    id integer not null,
    primary key (id)
) ENGINE=InnoDB;

alter table ContaBancaria 
    add constraint FK_ContaBancaria_FormaDePagamento
    foreign key (id) 
    references FormaDePagamento (id);



