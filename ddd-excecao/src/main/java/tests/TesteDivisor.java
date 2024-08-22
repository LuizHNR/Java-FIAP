package tests;

import models.Divisor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteDivisor {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        try {
            Divisor divisor = new Divisor();
            System.out.println("Digite primeiro número: ");
            divisor.setNumero1(leitor.nextInt());
            System.out.println("Digite segundo número: ");
            divisor.setNumero2(leitor.nextInt());
            divisor.calcular();
        }
        catch (ArithmeticException e){
            System.out.println("Operação inválida, não existe divisão por zero.");
        }
        catch (InputMismatchException e){
            System.out.println("Erro: Você deveria digitar um número");
        }
        finally {
            System.out.println("Programa finalizado !!!");
        }
    }
}
