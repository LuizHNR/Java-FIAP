package listas;

import models.Filme;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {

        Filme filmeA = new Filme();
        filmeA.setNome("Divertidamente 2");
        filmeA.setAnoDeLancamento(2024);
        filmeA.setDuracaoEmMinutos(101);

        Filme filmeB = new Filme();
        filmeB.setNome("Meu malvado favorito 4");
        filmeB.setAnoDeLancamento(2024);
        filmeB.setDuracaoEmMinutos(98);

        Filme filmeC = new Filme();
        filmeC.setNome("Meu malvado favorito 1");
        filmeC.setAnoDeLancamento(2018);
        filmeC.setDuracaoEmMinutos(98);

        Queue<Filme> filmes = new LinkedList<>();
        filmes.add(filmeA);
        filmes.add(filmeC);
        filmes.add(filmeB);

        //filmes.forEach(filme -> System.out.println(filme.getNome()));
        while (!filmes.isEmpty()){
            Filme filme = filmes.poll();
            System.out.println(filme.getNome());
        }
        //filmes.forEach(filme -> System.out.println(filme.getNome()));


    }
}
