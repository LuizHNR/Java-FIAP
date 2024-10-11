package listas;

import java.util.ArrayList;
import java.util.List;

public class ExemploArrayList {

    public static void exibirListaFor(ArrayList<String> nomes){
        System.out.println("\nLista de nomes usando for ....");
        for(int i =0; i <nomes.size(); i++){
            System.out.println(nomes.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        //Adicionar um nome;
        nomes.add("Eliane");
        nomes.add("Ana");
        nomes.add("Felipe");
        nomes.add("Maria");
        exibirListaFor(nomes);
        nomes.add(2, "José");
        exibirListaFor(nomes);

        System.out.println("Primeiro nome da lista: " + nomes.get(0));
        System.out.println("Tamanho da lista: " + nomes.size());
        nomes.remove(2);
        exibirListaFor(nomes);

        System.out.println("\nClonar uma lista");
        ArrayList<String> nomeAlunos = new ArrayList<>();
        nomeAlunos = (ArrayList<String>) nomes.clone();
        exibirListaFor(nomeAlunos);

        //Verificar se algum elemento existe na lista
        if(nomes.contains("Andre")){
            System.out.println("Existe na lista");
        }
        else {
            System.out.println("Não existe na lista");
        }

        //Ordenar lista
        System.out.println("Ordenação da lista nomes");
        nomes.sort(null);
        exibirListaFor(nomes);
    }
}
