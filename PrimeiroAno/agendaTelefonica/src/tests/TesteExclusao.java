package tests;

import dao.ContatoDao;
import models.Contato;

import java.util.Scanner;

public class TesteExclusao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);


        ContatoDao dao = new ContatoDao();
        System.out.println("Digite o código do contato que deseja excluir: ");
        int cod = leitor.nextInt();
        dao.deletarContato(cod);
    }
}
