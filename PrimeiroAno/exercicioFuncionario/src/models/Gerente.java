package models;

public class Gerente extends Funcionario {
    private double gratificacao;

    public double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(double gratificacao) {
        this.gratificacao = gratificacao;
    }

    @Override
    public double calcularBonificacao() {
        return super.calcularBonificacao() + 1000;
    }
}
