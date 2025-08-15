package models;

import enums.PlataformasEnum;

import java.util.ArrayList;

public class Pc {
    private static ArrayList<Jogos> consoleList = new ArrayList<>();

    public static ArrayList<Jogos> getConsoleList() {
        return consoleList;
    }

    public static void setConsoleList(ArrayList<Jogos> consoleList) {
        Pc.consoleList = consoleList;
    }

    public static void adicionarJogo(ArrayList<Jogos> jogosPlat){
        jogosPlat.stream()
                .filter(p -> p.getPlataforma() == PlataformasEnum.PC);
                setConsoleList(jogosPlat);
    }

    public static void mostrarLista(){
        consoleList.stream()
                .forEach(System.out::println);
    }
}
