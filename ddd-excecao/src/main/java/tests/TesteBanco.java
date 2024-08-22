package tests;

import models.Banco;

import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

            Banco banco = new Banco();
            banco.setSaldo(100);

            System.out.println("Escolha de qual conta irá sacar" +
                    "1-poupança" +
                    "2-corrente");
            int op = leitor.nextInt();
            if(op == 1){
                try {
                    banco.saca(500);
                }catch (RuntimeException e){
                    System.out.println("Saldo insuficiente, saque não efetuado.");
                }
            }else{
                try{
                    banco.setSaldo(banco.getSaldo()+ 1000);
                    banco.saca(1500);
                }catch (RuntimeException e){
                    System.out.println("Saldo insuficiente mesmo com limite, saque não efetuado.");

                }
            }
    }
}
