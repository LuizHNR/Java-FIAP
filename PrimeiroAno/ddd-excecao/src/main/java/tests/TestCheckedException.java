package tests;

import models.Arquivo;

import java.io.FileNotFoundException;

public class TestCheckedException {
    public static void main(String[] args) throws FileNotFoundException {
        Arquivo a = new Arquivo();
        a.abrirArquivo();
    }


}
