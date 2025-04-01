package tests;

import dao.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Teste de conexão com banco de dados");
        if(ConnectionFactory.obterConexao() == null){
            System.out.println("Erro ao estabelecer conexão");
        }else{
            System.out.println("Conexão estabelecida com sucesso!");
        }
    }
}
