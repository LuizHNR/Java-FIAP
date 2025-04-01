package br.com.fiap.cliente.json;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeituraJson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try(FileReader reader = new FileReader("pessoa.json")) {
            Pessoa pessoa = gson.fromJson(reader, Pessoa.class);
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo " + e.getMessage());
        }
    }
}
