package tests;

import dao.ContatoDao;
import enums.TipoContatoEnum;
import models.Contato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteBuscarPorTipo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        List<Contato> contatos = new ArrayList<>();
        ContatoDao dao = new ContatoDao();
        String tipo;
        System.out.println("Selecione o tipo do contato: \n" +
                "1 - Familiar\t2 - Amigo\t3 - Profissional");

        int opcao = leitor.nextInt();
        if(opcao == 1)
            tipo = TipoContatoEnum.FAMILIAR.name();
        else if(opcao == 2)
            tipo = TipoContatoEnum.AMIGO.name();
        else
            tipo = TipoContatoEnum.PROFISSIONAL.name();

        contatos = dao.buscarPorTipo(tipo);
        System.out.println("Agenda");
        System.out.println("===================================");
        contatos.forEach(System.out::println);

    }
}
