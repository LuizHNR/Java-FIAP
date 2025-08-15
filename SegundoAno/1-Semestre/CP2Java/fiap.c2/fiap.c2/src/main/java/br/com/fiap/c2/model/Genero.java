package br.com.fiap.c2.model;

public enum Genero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    RPG("Role-Playing Game"),
    ESTRATEGIA("Estratégia"),
    SIMULACAO("Simulação"),
    ESPORTE("Esporte"),
    LUTA("Luta"),
    CORRIDA("Corrida"),
    FANTASIA("Fantasia"),
    TERROR("Terror");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
