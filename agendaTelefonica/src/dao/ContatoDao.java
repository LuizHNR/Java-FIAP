package dao;
import models.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//É a classe responsavel por manipular os dados no BD
//Implementando o CRUD( cadastros, consultas, alterações e exclusões)

public class ContatoDao {
    private Connection conexao;

    public void cadastrarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into tbl_contato(ID_CONTATO,NOME_CONTATO,CELULAR_CONTATO,EMAIL_CONTATO,INSTAGRAM,TIPO) values (?,?,?,?,?,?)";
            //O preparedStatement peo o comendo sql e executa no servidor oracle
            //usando a conexão q foi configurada
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1,contato.getCodigo());
            comandoSQL.setString(2,contato.getNome());
            comandoSQL.setString(3,contato.getTelefone());
            comandoSQL.setString(4,contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipoContato().toString());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
