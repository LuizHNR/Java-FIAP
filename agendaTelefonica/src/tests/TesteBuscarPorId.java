package tests;

import dao.ContatoDao;
import models.Contato;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteBuscarPorId {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();
        System.out.println("Digite o codigo do contato: ");
        int cod = leitor.nextInt();

        try{
            contato = dao.buscarPorId(cod);
            System.out.println(contato.toString());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
