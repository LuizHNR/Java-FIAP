package tests;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

            Scanner leitor = new Scanner(System.in);
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por codigo" +
                    "\n4- Consultar por xxx" +
                    "\n5- Alterar" +
                    "\n6- Excluir" +
                    "\nDigite a operação desejada: ");
            int op = leitor.nextInt();
    }

}
