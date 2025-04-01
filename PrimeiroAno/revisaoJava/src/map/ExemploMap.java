package map;

import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        Map<Integer, String> mapNomes = new HashMap<>();

        mapNomes.put(1, "João Delfino");
        mapNomes.put(2, "Maria do Carmo");
        mapNomes.put(3, "Claudinei Silva");

        System.out.println(mapNomes);

        //resgatando o nome da posição 2
        System.out.println(mapNomes.get(2));

        //Posso declarar um objeto do tipo HasMap
        HashMap<String, String> contato = new HashMap<>();
        contato.put("Eliane", "93738393383");

        /*
        values() - É uma Collection com todos os valores que foram associados a alguma das chaves.
        keySet() - Retorna um Set com as chaves do mapa especificado.
        entrySet() - Retorna um conjunto de Maps contido no mapa configurado, podendo ser possível acessar suas chaves e valores.
        put (Key key, Value value) - Associa um valor a uma chave específica.
        * */

        //Declarando um HashMap
        Map<String, Integer> map = new HashMap<>();

//Adicionando itens 
        map.put("Eliane", 45);
        map.put("Ana", 18);
        map.put("Teste", 30);

//Exibindo a idade da AnaSystem.out.println(“Idade da Ana" + map.get(“Ana”));
//Excluindo um elemento
        map.remove("Teste");
        System.out.println("Contem Teste? " + map.containsKey("Teste"));
    }
}
