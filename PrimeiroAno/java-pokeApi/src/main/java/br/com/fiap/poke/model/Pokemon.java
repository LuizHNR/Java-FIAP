//Erick Alves e Luiz Henrique Neri

package br.com.fiap.poke.model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private int id;
    private String name;
    private ArrayList<Types> types;

    @Override
    public String toString(){
        return "\n------------Pokemon-------------\n" +
                "Numero da pokedex: " + id +
                "\nNome do Pokemon: " + name +
                "\nTipo do Pokemon: " + types;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }
    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }
}
