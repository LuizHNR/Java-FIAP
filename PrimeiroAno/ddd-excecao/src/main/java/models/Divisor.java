package models;

public class Divisor {
    private int numero1;
    private int numero2;

    public void calcular(){
        double resultado = numero1 / numero2;
        System.out.println("Resultado: " + resultado);
    }


    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
}
