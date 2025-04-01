package tests;

import exception.SalarioInvalidoExcpetion;
import models.Funcionario;

public class TesteFuncionario {
    public static void main(String[] args) {
        try{
            Funcionario f1 = new Funcionario();
            f1.setSalario(-5000.0);
        }
        catch (SalarioInvalidoExcpetion ex){
            System.out.println(ex.getMessage());
        }


    }
}
