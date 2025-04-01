package streams;


import models.Episodio;
import models.Serie;
import models.Temporada;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        //1 serie tem n temporadas
        //Cada temporada tem n episodios

        Episodio episodio1 = new Episodio(1, "Pilot", 8.5, 1000);
        Episodio episodio2 = new Episodio(2, "Lucifer, Stay. Good Devil", 8.0, 1000);
        Episodio episodio3 = new Episodio(3, "The Would-Be Prince of Darkness", 7.5, 1000);
        Episodio episodio4 = new Episodio(4, "Manly Whatnots", 8.3, 1000);
        Episodio episodio5 = new Episodio(1, "Everything's Coming Up Lucifer", 8.5, 1000);
        Episodio episodio6 = new Episodio(2, "Liar, Liar, Slutty Dress on Fire", 0.0, 1000);
        Episodio episodio7 = new Episodio(3, "Sin-Eater", 7.9, 1000);
        Episodio episodio8 = new Episodio(4, "Lady Parts", 8.3, 1000);


        var temporada1 = new Temporada(1, List.of(episodio1, episodio2, episodio3, episodio4));
        var temporada2 = new Temporada(2, List.of(episodio5, episodio6, episodio7, episodio8));
        List<Temporada> temporadas = new ArrayList<>();
        temporadas.add(temporada1);
        temporadas.add(temporada2);

        Serie serie = new Serie("Lucifer", 2016, true,8.1, 10, 1000,false,6, 45, temporadas, 2);
        //for temporada (for episodios)
        temporadas.forEach(System.out::println);
        temporadas.forEach(t-> t.getEpisodios().forEach(e-> System.out.println(e.getNome())));

        System.out.println("============================================");
        System.out.println("Lista de episódios");
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t-> t.getEpisodios().stream())
                .collect(Collectors.toList());
        episodios.forEach(System.out::println);

        System.out.println("============================================");
        System.out.println("Lista de episódios por temporada");
        List<Episodio> dadosEpisodios = temporadas.stream()
                .flatMap(t-> t.getEpisodios().stream()
                        .map(d-> new Episodio(t.getNumeroTemporada(), d)))
                .collect(Collectors.toList());
        dadosEpisodios.forEach(System.out::println);

        System.out.println("============================================");
        System.out.println("Lista de episódios por temporada ordenado por avaliação");
        dadosEpisodios = temporadas.stream()
                .flatMap(t-> t.getEpisodios().stream()
                        .map(d-> new Episodio(t.getNumeroTemporada(), d))
                        .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed()))
                .collect(Collectors.toList());
        dadosEpisodios.forEach(System.out::println);


      //  dadosEpisodios.add(new Episodio(1, episodio1));
      //  dadosEpisodios.forEach(System.out::println);
//        System.out.println("============================================");
//        System.out.println("Lista de episódios por temporada ordenado por avaliação");
//        dadosEpisodios = temporadas.stream()
//                .flatMap(t-> t.getEpisodios().stream()
//                        .map(d-> new Episodio(t.getNumeroTemporada(), d))
//                        .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed()))
//                .toList();
//        dadosEpisodios.forEach(System.out::println);


    }


}
