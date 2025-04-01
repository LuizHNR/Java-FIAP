package models;

public class Veiculo {
    private double valorHora;
    private double valorAdicional;
    private double horas;

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double doTotal(){
        return this.valorHora + this.valorAdicional * (this.horas-1);
    }

    public String doViewCupom(){
        String mensagem = "----------Cupom de estacionamento------------" +
                "\n------------------------------------------" +
                "\nValor da Hora é: R$" + this.valorHora +
                "\nValor adicional: R$" + this.valorAdicional +
                "\nQuantidande de horas: " + this.horas +
                "\nO valor total a ser pago é: R$" + doTotal() +
                "\n---------------------------------------------";
        return mensagem;
    }
}
