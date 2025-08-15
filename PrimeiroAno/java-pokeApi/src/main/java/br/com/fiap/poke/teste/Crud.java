//Erick Alves e Luiz Henrique Neri

package br.com.fiap.poke.teste;

import br.com.fiap.poke.dao.PokemonDao;
import br.com.fiap.poke.model.Pokemon;
import br.com.fiap.poke.service.PokeApiService;

import java.util.Scanner;

public class Crud {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Pokemon pokeAlvo = new Pokemon();
        PokeApiService consulta = new PokeApiService();
        PokemonDao database = new PokemonDao();
        boolean repetir = true;

        do {
            System.out.println("------------------CRUD------------------" +
                    "\n[1] - Cadastrar um Pokémon" +
                    "\n[2] - Buscar pokémon por nome" +
                    "\n[3] - Buscar pokémon pelo número da Pokédex" +
                    "\n[4] - Listar todos os pokémons cadastrados" +
                    "\n[5] - Finalizar Programa" +
                    "\n----------------------------------------");
            int opcaoCrud = leitor.nextInt();
            switch (opcaoCrud){
                case 1:
                    System.out.println("------------CADASTRAR------------" +
                            "\n[1] - Deseja procurar o Pokémon para cadastrar pelo nome;" +
                            "\n[2] - Deseja procurar o Pokémon para cadastrar pelo número da pokédex" +
                            "\nOBS: O número você pode digitar um número aleatorio entre 1-1025" +
                            "\n---------------------------");
                    int opcaoCadastrar = leitor.nextInt();
                    switch (opcaoCadastrar){
                        case 1:
                            System.out.println("Qual o nome do pokémon alvo");
                            String nome = leitor.next();
                            leitor.nextLine();
                            pokeAlvo = consulta.buscarPokemon(nome);
                            break;
                        case 2:
                            System.out.println("Qual o número da pokedex do Pokémon alvo?");
                            int numero = leitor.nextInt();
                            leitor.nextLine();
                            pokeAlvo = consulta.buscarPokemon(numero);
                            break;
                    }
                    database.Cadastrar(pokeAlvo);
                    System.out.println("Pokemon Cadastrado com sucesso");
                    break;
                case 2:
                    System.out.println("-------------PESQUISA-------------" +
                            "\nQual o nome do pokémon que deseja procurar?" +
                            "\nOBS: O pokémon tem que estar cadastrado" +
                            "\n--------------------------");
                    String nomePoke = leitor.nextLine();
                    System.out.println(database.buscarPorNom(nomePoke));
                    break;
                case 3:
                    System.out.println("-------------PESQUISA-------------" +
                            "\nDigite o numero do pokemon que você deseja procurar:" +
                            "\n--------------------------");
                    int num = leitor.nextInt();
                    System.out.println(database.buscarPorNum(num));

                    break;
                case 4:
                    System.out.println("Listando Pokémon" +
                            database.listar());

                    break;
                case 5:
                    System.out.printf("Programa finalizado");
                    repetir = false;
            }
        } while (repetir);
    }
}
