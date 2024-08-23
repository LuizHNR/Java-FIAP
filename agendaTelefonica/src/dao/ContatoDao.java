package dao;
import enums.TipoContatoEnum;
import models.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Contato buscarPorId(int id) throws SQLException{
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        Contato contato = new Contato();
        try{
            String sql = "select * from tbl_contato where id_contato = ?";
            comandoSql.setInt(1, id);
            ResultSet rs = comandoSql.executeQuery();

            if(rs.next()){
                contato.setCodigo(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipoContato(TipoContatoEnum.valueOf(rs.getString(6)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            comandoSql.close();
            conexao.close();
        }

        return contato;
    }
}
