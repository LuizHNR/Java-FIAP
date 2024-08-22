CREATE TABLE TBL_CONTATO(
    ID_CONTATO NUMERIC(4) PRIMARY KEY,
    NOME_CONTATO VARCHAR2(50) NOT NULL,
    CELULAR_CONTATO VARCHAR2(11) NOT NULL,
    EMAIL_CONTATO VARCHAR(60),
    INSTAGRAM VARCHAR(50),
    TIPO VARCHAR2(20)
);

DML -> Data Manipulation Language {Comandos para CRUD - create, read, update, delete}

--Create
insert into table VALUES {}
insert into tbl_contato(ID_CONTATO,NOME_CONTATO,CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO)
values{1,'Luiz', '11973076648', 'rm556864@fiap.com.br', 'luizhnr', 'Aluno'}


SELECT ' FROM TBL_CONTATO;

