package models;

public class Banco {
    private double saldo;
    public void saca(double valor) {
        if (this.saldo < valor) {
            throw new IllegalArgumentException();
        } else {
            this.saldo-=valor;
        }

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
