package br.com.fiap.cliente.teste;

import br.com.fiap.cliente.model.Endereco;
import br.com.fiap.cliente.service.ViaCepService;

import java.util.List;
import java.util.Scanner;

public class TesteBuscaCep {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Endereco meuEndereco = new Endereco();
        ViaCepService consulta = new ViaCepService();

        System.out.println("Digite o número do CEP: ");
        var cep = leitor.nextLine();
        meuEndereco = consulta.buscarEndereco(cep);
        System.out.println("Digite o número da residência: ");
        var numero = leitor.nextLine();

        meuEndereco.setNumero(numero);
        System.out.println(meuEndereco.toString());
    }
}
