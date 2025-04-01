package models;

import java.io.FileNotFoundException;

public class Arquivo {

    public static void abrirArquivo(){
        try{
            new java.io.FileInputStream("arquivo.txt");
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado.");
        }

    }
}
