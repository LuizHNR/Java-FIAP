package br.com.fiap.cliente.service;

import br.com.fiap.cliente.model.Endereco;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {

    /**
     * API Via Cep - https://viacep.com.br/
     * Webservice gratuito de alto desempenho para consulta de Código de Endereçamento Postal (CEP) do Brasil.
     * Exemplo de consulta de CEP:
     *     viacep.com.br/ws/01001000/json/
     * Saída
     * URL: viacep.com.br/ws/01001000/json/
     *
     *     {
     *       "cep": "01001-000",
     *       "logradouro": "Praça da Sé",
     *       "complemento": "lado ímpar",
     *       "unidade": "",
     *       "bairro": "Sé",
     *       "localidade": "São Paulo",
     *       "uf": "SP",
     *       "estado": "São Paulo",
     *       "regiao": "Sudeste",
     *       "ibge": "3550308",
     *       "gia": "1004",
     *       "ddd": "11",
     *       "siafi": "7107"
     *     }
     *
     * */
    public Endereco buscarEndereco(String cep){
        try{
            String endereco = "https://viacep.com.br/ws/" + cep+ "/json/";
            //HttClient => criar um objeto do HttpClient responsável por fazer a requisição HTTP para a api
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
