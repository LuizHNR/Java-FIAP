package tests;

import models.ClassificacaoEnum;
import models.Filme;
import models.Serie;
import models.Titulo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Serie titulo = new Serie();
        titulo.setNome("Lucifer");
        titulo.setAnoDeLancamento(2013);
        titulo.setDuracaoEmMinutos(1500);
        titulo.exibirFichaTecnica();

        Serie minhaSerie = new Serie();
        minhaSerie.setNome("Naruto");
        minhaSerie.setAnoDeLancamento(2000);
        minhaSerie.setDuracaoEmMinutos(500000);
        minhaSerie.setAtiva(false);
        minhaSerie.setNumeroTemporada(18);
        minhaSerie.setEpisodiosPorTemporada(20);
        minhaSerie.setMinutosPorEpisodio(50);
        minhaSerie.setClassificacaoIndicativa(ClassificacaoEnum.DEZESSEIS);
        minhaSerie.exibirFichaTecnica();

        Filme filme = new Filme();
        filme.setNome("Sem memória");

        ArrayList<Titulo> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(minhaSerie);
        listaDeFilmes.add(titulo);

        System.out.println("Exibindo a lista usando foreach");
        for(Titulo t : listaDeFilmes){
            System.out.println("Titulo: " + t.getNome());
            System.out.println("Ano de lançamento: " + t.getAnoDeLancamento() + "\n");
        }

        System.out.println("Exibindo a lista usando o método forEach");
        listaDeFilmes.forEach(f -> System.out.println(f.getNome()));

        listaDeFilmes.forEach(f -> {
            System.out.println(f.getNome());
            System.out.println("Ano de lançamento: " + f.getAnoDeLancamento() + "\n");
        });






    }
}
