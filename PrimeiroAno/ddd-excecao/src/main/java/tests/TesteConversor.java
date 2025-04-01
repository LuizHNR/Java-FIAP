package tests;

import models.Conversor;

import java.util.Scanner;

public class TesteConversor {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        try {
            Conversor conversor = new Conversor();
            System.out.println("Digite um número: ");
            conversor.setValor(leitor.next());
            conversor.converter();
        }catch (NumberFormatException e){
            System.out.println("Valor informado não é numérico!");
        }catch (RuntimeException e){
            System.out.println("Algo errado!");
        }

    }
}
