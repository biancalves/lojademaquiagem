create table cliente(
    nome varchar,
    cpf varchar primary key,
    telefone integer,
    email varchar,
    endereco varchar,
    cidade varchar
    );
    
create table funcionario(
    nome varchar,
    cpf varchar,
    cod_funcionario integer primary key,
    telefone integer,
    email varchar 
    );
    
create table produto(
    id_produto integer primary key,
    preço integer,
    quantidade_estoque integer,
    nome_produto varchar
    );
    
create table venda(
    id_venda integer primary key,
    nome_cliente varchar,
    nome_funcionario varchar,
    data date,
    hora time,
    valor_venda integer,
    id_funcionario integer references funcionario(cod_funcionario),
    cpf_cliente varchar references cliente(cpf)
    );
    
    
create table item_venda(
    id_venda references venda(id_venda),
    id_produto integer references produto(id_produto),
    nome_produto varchar,
    quantidade_venda integer
    );
    