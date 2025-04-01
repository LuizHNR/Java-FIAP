package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println("Extrair os números pares desta lista de inteiros");
        List<Integer> numerosPares = numeros.stream()
                                            .filter(n-> n % 2 == 0)
                                            .collect(Collectors.toList());
        System.out.println(numerosPares);

        List<String> nomes = Arrays.asList("Ana", "Maria", "Paulo", "Rodrigo", "Eliane");
        List<Integer> tamanhoNomes = nomes.stream()
                .map(n -> n.length())
                .collect(Collectors.toList());
        System.out.println(tamanhoNomes);


        nomes.stream()
                .forEach(n -> System.out.println("Olá " + n + ", seja bem vindo!"));

        nomes.forEach(n -> System.out.println("Olá " + n + ", seja bem vindo!"));

    }
}
