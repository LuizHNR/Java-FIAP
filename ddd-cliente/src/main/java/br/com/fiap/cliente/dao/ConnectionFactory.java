package br.com.fiap.cliente.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection obterConexao(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "Usuario", "senha");
        }catch (SQLException erro){
            erro.printStackTrace();
        }
        return conexao;
    }

    public static Connection getConnection(){
        Properties properties = new Properties();
        try {
            FileInputStream fileConfig = new FileInputStream("src/main/config.properties");
            properties.load(fileConfig);

            String url = properties.getProperty("URL");
            String user = properties.getProperty("USERNAME");
            String password = properties.getProperty("PASSWORD");

            return DriverManager.getConnection(url,user, password);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
