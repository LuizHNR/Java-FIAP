public class Moeda {
    public double valorReal;
    public double cotacaoDolar;
    public double quantidadeDolar;

    public void calcularConversao(){
        this.quantidadeDolar = this.valorReal/this.cotacaoDolar;
    }
    public double retornarCalculoConversao(){
        double dolar = this.valorReal/this.cotacaoDolar;
        return dolar;
    }

    public String comprarDolar(String cpf, String nome){
        this.calcularConversao();
        return "O cliente com cpf: " + cpf + "\nNome: " + nome + " comprou na data de hoje a quantia de $ " + this.quantidadeDolar;
    }

}
