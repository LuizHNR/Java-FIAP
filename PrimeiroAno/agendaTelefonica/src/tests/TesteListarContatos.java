package tests;

import dao.ContatoDao;
import models.Contato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteListarContatos {
    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();
        ContatoDao dao = new ContatoDao();
        contatos = dao.listarContatos();
        System.out.println("Agenda");
        System.out.println("===================================");
        contatos.forEach(System.out::println);

    }
}
