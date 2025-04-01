package tests;

import dao.ContatoDao;
import enums.TipoContatoEnum;
import models.Contato;

import java.util.Scanner;

public class TesteInsercao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o código do contato: ");
        contato.setCodigo(leitor.nextInt());
        System.out.println("Digite o nome do contato: ");
        contato.setNome(leitorTexto.nextLine());
        System.out.println("Digite o celular do contato: ");
        contato.setTelefone(leitorTexto.nextLine());
        System.out.println("Digite o email do contato: ");
        contato.setEmail(leitorTexto.nextLine());
        System.out.println("Digite o instagram do contato: ");
        contato.setInstagram(leitorTexto.nextLine());
        System.out.println("Selecione o tipo do contato: " +
                "1 - Familiar\t2- Amigo\t3 - Profissional");
        int op = leitor.nextInt();
        if(op == 1)
            contato.setTipoContato(TipoContatoEnum.FAMILIAR);
        else if(op == 2)
            contato.setTipoContato(TipoContatoEnum.AMIGO);
        else
            contato.setTipoContato(TipoContatoEnum.PROFISSIONAL);
        dao.cadastrarContato(contato);
        System.out.println("Contato adicionado com sucesso!");
    }
}
