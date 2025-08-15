package models;

import enums.PlataformasEnum;

import java.util.ArrayList;

public class Todas {
    private static ArrayList<Jogos> consoleList = new ArrayList<>();

    public static ArrayList<Jogos> getConsoleList() {
        return consoleList;
    }

    public static void setConsoleList(ArrayList<Jogos> consoleList) {
        Todas.consoleList = consoleList;
    }

    public static void adicionarJogo(ArrayList<Jogos> jogosPlat){
        jogosPlat.stream()
                .filter(p -> p.getPlataforma() == PlataformasEnum.TODAS);
                setConsoleList(jogosPlat);
    }

    public static void mostrarLista(){
        consoleList.stream()
                .forEach(System.out::println);
    }
}
