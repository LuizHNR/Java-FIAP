package models;

public class Segurado extends Veiculo implements ISeguroService{
    private double seguro;

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public Segurado(double seguro){
        this.seguro = seguro;
    }

    @Override
    public double doDesconto() {
        return super.doTotal() * seguro / 100;
    }

    @Override
    public double doTotal() {
        return super.doTotal() - doDesconto();
    }

    @Override
    public String doViewCupom() {
        return super.doViewCupom() +
                "\nO seguro é: " + this.seguro +
                "\nO Desconto é: R$" + doDesconto() +
                "\nO total é: R$" + doTotal() +
                "\n----------------------------------";
    }
}
