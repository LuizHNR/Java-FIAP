package models;

import java.sql.PreparedStatement;

public class Conversor {
    private String valor;

    public void converter(){
        int resultado = Integer.parseInt(valor);
        System.out.println("Valor Convertido: " + resultado);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
