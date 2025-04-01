package br.com.fiap.cliente.models;

import java.util.Scanner;

public class Cliente {

    private String nome;
    private int telefone;
    private String cpf;
    private String email;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente cadastrarCliente(){
        Scanner leitorCliente = new Scanner(System.in);
        System.out.println("------Cadastrar Cliente----------");

        System.out.print("Digite o nome do cliente: ");
        this.nome = leitorCliente.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        this.telefone = leitorCliente.nextInt();
        leitorCliente.next();
        System.out.print("Digite o cpf do cliente: ");
        this.cpf = leitorCliente.nextLine();
        System.out.print("Digite o email do cliente: ");
        this.email = leitorCliente.nextLine();

        return this;
    }
}
