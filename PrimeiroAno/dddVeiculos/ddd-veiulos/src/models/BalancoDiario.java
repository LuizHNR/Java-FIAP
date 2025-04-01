package models;

public class BalancoDiario {
    //Atributos com static (é somente da classe)
    private static int qtdeCarros;
    private static double total;

    /**
     * : incrementa a quantidade de carros e incrementa o total com o valor
     * do metodo doTotal() do objeto obj
     * @param obj do tipo Veiculo
     */

    //Metodos
    public void doAdd(Veiculo obj){
        qtdeCarros += 1;
        total += obj.doTotal();
    }

    public String doGerarRelatorio(){
        return "A quantidade de carro é: " + qtdeCarros + "\nO total é R$" + total;
    }
}
