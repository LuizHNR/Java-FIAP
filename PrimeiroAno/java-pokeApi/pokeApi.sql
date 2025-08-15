-- Drops
drop table Tipo_poke cascade constraints;
drop table Pokemon cascade constraints;
drop table Tem cascade constraints;

-- Cria��o das tabelas
create table Tipo_poke(
    id_tipo number(2) constraint tipo_id_pk Primary Key,
    nome_tipo VARCHAR2(10) constraint tipo_nm_nn not Null
);

create table Pokemon (
    num_pokedex NUMBER(4) constraint poke_num_pk Primary Key,
    nome_poke VARCHAR2 (20) constraint poke_nm_nn Not Null
);

create table Tem(
    qnt_tipo number(2),
    id_tipo number(2) constraint fk_tipo_id references Tipo_poke,
    num_pokedex NUMBER(4) constraint fk_poke_num references Pokemon);

