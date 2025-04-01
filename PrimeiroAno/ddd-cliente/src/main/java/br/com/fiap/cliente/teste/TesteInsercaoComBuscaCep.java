package br.com.fiap.cliente.teste;

import br.com.fiap.cliente.dao.EnderecoDao;
import br.com.fiap.cliente.model.Endereco;
import br.com.fiap.cliente.service.ViaCepService;

import java.util.Scanner;

public class TesteInsercaoComBuscaCep {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Endereco meuEndereco = new Endereco();
        ViaCepService consulta = new ViaCepService();
        EnderecoDao enderecoDao = new EnderecoDao();

        //Preenchendo o objeto endereço
        System.out.println("Digite o número do CEP: ");
        var cep = leitor.nextLine();
        meuEndereco = consulta.buscarEndereco(cep);
        System.out.println("Digite o ID do endereço: ");
        meuEndereco.setId(leitor.nextInt());
        System.out.println("Digite o número da residência: ");
        var numero = leitor.nextLine();
        meuEndereco.setNumero(numero);
        meuEndereco.setCep(cep);

        enderecoDao.inserir(meuEndereco);
        System.out.println("Endereço cadastrado com sucesso!");

        System.out.println("\n=================================");
        System.out.println("\nListando os endereços cadastrados");
        var enderecos = enderecoDao.listar();
        enderecos.forEach(System.out::println);

    }
}
