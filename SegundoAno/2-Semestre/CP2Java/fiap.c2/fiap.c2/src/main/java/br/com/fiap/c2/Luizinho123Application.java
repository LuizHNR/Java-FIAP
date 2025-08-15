package br.com.fiap.c2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.fiap.c2.model")
@OpenAPIDefinition(info =
@Info(title = "API de Steam", description = "Exemplo de API de Steam com Swagger", version = "v1"))
public class Luizinho123Application {

	public static void main(String[] args) {
		SpringApplication.run(Luizinho123Application.class, args);
	}

}
