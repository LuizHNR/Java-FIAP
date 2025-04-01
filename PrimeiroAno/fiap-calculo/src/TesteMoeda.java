import java.util.Scanner;

public class TesteMoeda {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorText = new Scanner(System.in);
        Moeda moeda = new Moeda();
        System.out.println("Informe o valor em reais: R$ ");
        moeda.valorReal = leitor.nextDouble();
        System.out.println("Informe a cotação do dólar de hoje: ");
        moeda.cotacaoDolar = leitor.nextDouble();
        moeda.calcularConversao();
        System.out.println(moeda.quantidadeDolar);
        //System.out.println(moeda.retornarCalculoConversao());

        System.out.println(moeda.comprarDolar("468817618", "Luiz"));

        Moeda moeda2 = new Moeda();
        String nome, cpf;
        System.out.println("informe o nome do cliente: ");
        nome = leitorText.nextLine();
        System.out.println("informe o cpf do cliente: ");
        cpf = leitorText.nextLine();
        System.out.println("Informe a cotação do dolar de hoje: ");
        moeda2.cotacaoDolar = leitorText.nextDouble();
        moeda2.calcularConversao();

        System.out.println(moeda2.comprarDolar(cpf, nome));
    }
}
