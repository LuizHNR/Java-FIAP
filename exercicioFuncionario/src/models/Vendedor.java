package models;

public class Vendedor extends Funcionario {
    private double comissao;

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calcularBonificacao() {
        return super.calcularBonificacao() + 500;
    }
    public double calculoComissao(double valorVendido){
        this.comissao = valorVendido * 0.10;
        return super.getSalario() + this.comissao;
    }
}
