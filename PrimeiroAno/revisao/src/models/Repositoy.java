package models;

import java.util.List;

public interface Repositoy {

    void inserir(Titulo titulo);
    Titulo consultarFilme(String nome);
    List<Titulo> listarFilmes();

}
