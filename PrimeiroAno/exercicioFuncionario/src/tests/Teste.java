package tests;

import models.Funcionario;
import models.Gerente;
import models.Vendedor;

public class Teste {
    public static void main(String[] args) {
        double bonicacao;
        Funcionario func = new Funcionario();
        func.setNome("Eliane");
        func.setSalario(1000);
        bonicacao = func.calcularBonificacao();
        System.out.println("models.Funcionario: " + func.getNome() + "\nSálario bruto: " + func.getSalario() + "\nBonificacão: " + bonicacao + "\nSálario liquido: " + (func.getSalario() + bonicacao) + "\n\n");

        Gerente gerente = new Gerente();
        gerente.setNome("Rafael");
        gerente.setSalario(1000);
        gerente.setGratificacao(1000);
        bonicacao = gerente.calcularBonificacao();
        System.out.println("models.Gerente: " + gerente.getNome() + "\nGratificação do cargo: " + gerente.getGratificacao() + "\nSálario bruto: " + gerente.getSalario() + "\nBonificacão: " + bonicacao + "\nSálario liquido: " + (gerente.getSalario() + bonicacao) + "\n\n");

        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Carlos");
        vendedor.setSalario(1000);
        double salarioComComissao = vendedor.calculoComissao(20000);
        bonicacao = vendedor.calcularBonificacao();
        System.out.println("models.Vendedor: " + vendedor.getNome() + "\nComissao do vendedor: " + vendedor.getComissao() + "\nSálario bruto: " + vendedor.getSalario() + "\nBonificacão: " + bonicacao + "\nSálario liquido: " + salarioComComissao);
    }
}
