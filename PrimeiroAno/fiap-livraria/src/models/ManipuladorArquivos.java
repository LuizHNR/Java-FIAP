package models;

import java.io.*;
import java.util.Scanner;

public class ManipuladorArquivos {

    public  static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true){
            if(linha != null){
                System.out.println(linha);
            }else{
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    public  static void escrever(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite algo: ");
        linha = leitor.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
}
