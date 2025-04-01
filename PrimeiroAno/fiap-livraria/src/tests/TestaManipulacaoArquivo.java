package tests;

import models.ManipuladorArquivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestaManipulacaoArquivo {
    public static void main(String[] args) {
        try{
            String path = "D:\\1TDSPM\\LuizH\\java\\fiap-livraria\\Cupom.txt";
            ManipuladorArquivos.escrever(path);
            ManipuladorArquivos.leitor(path);
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }

        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}
