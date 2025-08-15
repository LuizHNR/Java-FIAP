package models;


import java.util.ArrayList;


public class ContagemRegistros {

    //Atributos
    private static int qtdJogos;
    private static ArrayList<Jogos> listaJogos = new ArrayList<>();


    //Getters e Setters
    public static int getQtdJogos() {
        return qtdJogos;
    }
    public static void setQtdJogos(int qtdJogos) {
        ContagemRegistros.qtdJogos = qtdJogos;
    }

    public static ArrayList<Jogos> getListaJogos() {
        return listaJogos;
    }
    public static void setListaJogos(ArrayList<Jogos> listaJogos) {
        ContagemRegistros.listaJogos = listaJogos;
    }

    //Metodos Gerais
    public static void resgistrarJogo(Jogos novoJogo){
        qtdJogos = novoJogo.getId();
        listaJogos.add(novoJogo);

    }

    public static void removerJogo(int idJogoAlvo){
        int idAlvo = idJogoAlvo - 1;
        listaJogos.removeIf(jogo -> jogo.getId() == idAlvo);
    }
}
