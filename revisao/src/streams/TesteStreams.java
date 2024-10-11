package streams;

import java.util.Arrays;
import java.util.List;

public class TesteStreams {
    public static void main(String[] args) {

        List<String> nomes = Arrays.asList("Ana", "Maria", "Paulo", "Rodrigo", "Eliane");

        System.out.println("Exibição da Lista nomes");
        //n -> System.out.println(n)
        nomes.forEach(System.out::println);

        System.out.println("===============================================");
        System.out.println("Ordenando a lista nomes e exibindo");
        nomes.stream()
                .sorted()  //Fluxo intermediário (operação)
                .forEach(System.out::println); //Fluxo de finalização


        System.out.println("===============================================");
        System.out.println("Ordenando a lista nomes e exibindo apenas 3 nomes, aplicando um limite");
        nomes.stream()
                .sorted()  //Fluxo intermediário (operação)
                .limit(3)
                .forEach(System.out::println); //Fluxo de finalização

        System.out.println("===============================================");
        System.out.println(" exibindo apenas 3 nomes, aplicando um limite e Ordenando a lista nomes");
        nomes.stream()
                .limit(3)
                .sorted()
                .forEach(System.out::println);


        System.out.println("===============================================");
        System.out.println("Ordenando a lista nomes e exibindo apenas 3 nomes, aplicando um filtro de nomes que " +
                " iniciam com a letra M");
        nomes.stream()
                .sorted()  //Fluxo intermediário (operação)
                .limit(3)
                .filter(n-> n.startsWith("M"))
                .forEach(System.out::println); //Fluxo de finalização

        System.out.println("===============================================");
        System.out.println("Ordenando a lista nomes e exibindo apenas 3 nomes, aplicando um filtro de nomes que " +
                " iniciam com a letra M convertendo para maiúsculo");
        nomes.stream()
                .sorted()  //Fluxo intermediário (operação)
                .limit(3)
                .filter(n-> n.startsWith("M"))
                .map(n-> n.toUpperCase())
                .forEach(System.out::println); //Fluxo de finalização

    }

}
