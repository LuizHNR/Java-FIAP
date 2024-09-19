package br.com.fiap.cliente.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

    public class EscritaJson {
        public static void main(String[] args) {
            Pessoa pessoa = new Pessoa("Maria", 25);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try (FileWriter writer = new FileWriter("pessoa.json")){
                gson.toJson(pessoa, writer);
                System.out.println("Arquivo Json escrito com sucesso!");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao escrever o arquivo" + e.getMessage() );
            }

        }
}
