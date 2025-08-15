package tests;

import enums.GeneroJogoEnum;
import enums.PlataformasEnum;
import models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jogos> listGames = new ArrayList<>();
        Jogos novoJogo = new Jogos();

        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println();
            String msg = "------------------- MENU ----------------------";
            System.out.print(msg +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por codigo" +
                    "\n4- Listar jogos Plataforma" +
                    "\n5- Alterar" +
                    "\n6- Excluir" +
                    "\n----------------------------------------------" +
                    "\nDigite a opção desejada: ");
            int op = leitor.nextInt();

            if (op == 0) {
                System.out.println("Volte sempre :) ");
                break;

            } else if (op == 1) {
                if (ContagemRegistros.getQtdJogos() == 0){
                    novoJogo = novoJogo.cadastrarJogo();
                    ContagemRegistros.resgistrarJogo(novoJogo);
                }else {
                    Jogos jogo2 = novoJogo.clone();
                    jogo2.cadastrarJogo();
                    ContagemRegistros.resgistrarJogo(jogo2);
                }

            } else if (op == 2) {
                if (ContagemRegistros.getQtdJogos() == 0){
                    System.out.println("Nenhum Jogo Cadastrado/Registrado");
                }else {
                    System.out.println("----------------------LISTA-DE-JOGOS-------------------------");
                    for (Jogos jogo : ContagemRegistros.getListaJogos()){
                        System.out.println("\nID: " + jogo.getId() +
                                "\nNome: " + jogo.getNome() +
                                "\nPreço: " + jogo.getPreco() +
                                "\nGenero: " + jogo.getGenero() +
                                "\nPlataformas: " + jogo.getPlataforma() +
                                "\nData de Lançamento: " + jogo.getLancamento() +
                                "\n-----------------------------------------------");
                    }
                }
            } else if (op == 3) {
                System.out.println("Digite o ID do jogo: ");
                int id = leitor.nextInt();
                for (Jogos jogo : ContagemRegistros.getListaJogos()){
                    if (jogo.getId() == id){
                        System.out.println("----------------------JOGO-ENCONTRADO-------------------------" +
                                "\nID: " + jogo.getId() +
                                "\nNome: " + jogo.getNome() +
                                "\nPreço: " + jogo.getPreco() +
                                "\nGenero: " + jogo.getGenero() +
                                "\nPlataformas: " + jogo.getPlataforma() +
                                "\nData de Lançamento: " + jogo.getLancamento() +
                                "\n-----------------------------------------------");
                    }else {
                        System.out.println("\nnão foi encontrado um jogo com o ID passado!!!\n");
                    }
                }
            } else if (op == 4) {
                while (true) {
                    System.out.println("Digite a plataforma que vc deseja pesquisar: (1)Pc/(2)Mobile/(3)Console/(4)Todos");
                    int opc = leitor.nextInt();
                    if (opc == 3) {
                        Console.adicionarJogo(ContagemRegistros.getListaJogos());
                        Console.mostrarLista();
                        break;
                    } else if (opc == 1) {
                        Pc.adicionarJogo(ContagemRegistros.getListaJogos());
                        Pc.mostrarLista();
                        break;
                    } else if (opc == 2) {
                        Mobile.adicionarJogo(ContagemRegistros.getListaJogos());
                        Mobile.mostrarLista();
                        break;
                    } else if (opc == 4) {
                        Todas.adicionarJogo(ContagemRegistros.getListaJogos());
                        Todas.mostrarLista();
                        break;
                    } else {
                        System.out.println("Opção invalida");
                    }
                }

            } else if (op == 5) {
                System.out.println("Função não criada");
            } else if (op == 6) {
                System.out.println("Digite o ID ou Codigo do jogo para exclui-lo!!: ");
                int idJogoAlvo = leitor.nextInt();
                ContagemRegistros.removerJogo(idJogoAlvo);
                System.out.println("----------------------JOGO-EXCLUIDO-------------------------");
            } else {
                System.out.println("Opção invalida, Por favor tente novamente");
            }
        }
    }
}