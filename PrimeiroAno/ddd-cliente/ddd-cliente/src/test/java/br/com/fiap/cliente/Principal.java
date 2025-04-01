package br.com.fiap.cliente;

import br.com.fiap.cliente.models.Cliente;
import br.com.fiap.cliente.models.Endereco;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Endereco end = new Endereco();
        Cliente cliente = new Cliente();

        boolean continuar = true;
        while (continuar){
            System.out.println("---------MENU-------" +
                    "\n(0)Sair" +
                    "\n(1)Cadastrar Cliente" +
                    "\n(2)Cadastrar endereço" +
                    "\n(3)Listar cliente ");
            int op = leitor.nextInt();

            switch (op){

                case 0:
                    System.out.println("Volte Sempre :)");
                    continuar = false;
                    break;
                case 1:
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    System.out.println("Cadastrar endereço");
                    break;
                case 3:
                    System.out.println("Listar cliente");
                    break;
            }
        }
    }
}
