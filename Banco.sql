/*drop database eliteTech_ds;*/	
create database eliteTech_ds;

use eliteTech_ds;

create table usuario (
    idUsuario int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(100) not null,
    cpf varchar(14) not null unique,
    telefone varchar(14) unique,
    status varchar(50) default 'cliente',
    data_registro timestamp default current_timestamp
);

create table endereco (
	idEndereco int primary key auto_increment,
    estado varchar(50) not null,
    cidade varchar(50) not null,
    cep VARCHAR(45) not null,
    rua varchar(100) not null,
    numero int not null,
    complemento varchar(100),
    usuario int,
    enderecoPadrao boolean,
    foreign key (usuario) references usuario(idUsuario)
);

create table categoria (
	idCategoria int primary key auto_increment,
    nome varchar(100) not null
);

create table subCategoria(
	idSubCategoria int primary key auto_increment,
    nome varchar(100) not null,
    idCategoria int not null,
	foreign key (idCategoria) references categoria(idCategoria)
);

create table produto (
	idProduto int primary key auto_increment,
    nome varchar(100) not null,
    valor float(10,2) not null,
    descricao text not null,
    categoria int not null,
    promocao int not null,
    subCategoria int not null,
    imagem longblob,
    foreign key (categoria) references categoria(idCategoria),
    foreign key (subCategoria) references subCategoria(idSubCategoria)
);

create table pedido (
	idPedido int primary key auto_increment,
    usuario int not null,
    endereco_entrega int not null,
    data_pedido timestamp default current_timestamp,
    valorTotal float,
    valorFrete int,
    status_pedido ENUM ('pendente', 'processando','enviado','entregue') DEFAULT 'pendente',
    formaDePagamento varchar(100),
    foreign key (endereco_entrega) references endereco(idEndereco),
    foreign key (usuario) references usuario(idUsuario)
);

create table carrinho (
	idCarrinho int primary key auto_increment,
    usuario int not null,
    produto int not null,
    quantidade int not null,
    foreign key (usuario) references usuario(idUsuario),
    foreign key (produto) references produto(idProduto)
);

create table produto_pedido (
	idProduto_pedido int primary key auto_increment,
    pedido int not null,
    produto int not null,
    quantidade int not null,
    foreign key (pedido) references pedido(idPedido),
    foreign key (produto) references produto(idProduto)
);

insert into categoria (nome) values ('Periféricos');

insert into usuario (nome, email, senha, cpf, telefone, status) 
values ('admin', 'admin@gmail.com', 'admin', '00000000000', '0000000000', 'admin');

insert into subCategoria (nome,idCategoria) values ('Teclado', 1);

insert into subCategoria (nome,idCategoria) values ('Mouse', 1);

insert into subCategoria (nome,idCategoria) values ('Fone', 1);

insert into subCategoria (nome,idCategoria) values ('Microfone', 1);