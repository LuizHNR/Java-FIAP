package tests;

import dao.ContatoDao;
import models.Contato;

import java.util.Scanner;

public class Excluir {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o codigo do contato: ");
        int cod = leitor.nextInt();
        dao.deletarContato(cod);

    }
}
