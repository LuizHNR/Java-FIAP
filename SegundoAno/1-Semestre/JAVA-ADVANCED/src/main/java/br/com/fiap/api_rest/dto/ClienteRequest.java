package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150,
            message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;
    @Min(value = 18,
            message = "O cliente deve ter no mínimo 18 anos")
    private int idade;
    @Email(message = "Email fora do formato correto")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!,#])[A-Za-z\\d\\W]{8,}$",
            message = "A senha deve conter no mínimo 8 caracteres, letras maiúsculas e minúsculas, números e caracteres especiais (@!,#)")
    private String senha;
    @CPF(message = "CPF fora do formato correto")
    private String cpf;
    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    public ClienteRequest() {
    }

    public ClienteRequest(String nome, int idade, String email, String senha, String cpf, Categoria categoria) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
