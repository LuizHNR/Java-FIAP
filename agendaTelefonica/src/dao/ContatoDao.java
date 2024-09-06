package dao;

import enums.TipoContatoEnum;
import models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//É a classe responsável por manipular os dados no BD
//Implementando o CRUD (cadastro, consultas, alterações e exclusão de dados)
public class ContatoDao {
    private Connection conexao;

    public void cadastrarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try{
            String sql = "insert into tbl_contato(ID_CONTATO, NOME_CONTATO, CELULAR_CONTATO, EMAIL_CONTATO," +
                    "INSTAGRAM, TIPO) values (?,?,?,?,?,?)";
            //O preparedStatement pega o comando sql e executa no servidor oracle
            //usando a conexao que foi configurada
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, contato.getCodigo());
            comandoSQL.setString(2, contato.getNome());
            comandoSQL.setString(3, contato.getTelefone());
            comandoSQL.setString(4, contato.getEmail());
            comandoSQL.setString(5, contato.getInstagram());
            comandoSQL.setString(6, contato.getTipoContato().toString());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void  alterarContato(Contato contato){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "update tbl_contato set nome_contato = ?, celular_contato = ?, email_contato = ?, " +
                    "instagram = ?, tipo = ? where id_contato = ?";
            comandoSql =  conexao.prepareStatement(sql);
            comandoSql.setString(1, contato.getNome());
            comandoSql.setString(2, contato.getTelefone());
            comandoSql.setString(3, contato.getEmail());
            comandoSql.setString(4, contato.getInstagram());
            comandoSql.setString(5, contato.getTipoContato().toString());
            comandoSql.setInt(6, contato.getCodigo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Contato buscarPorId(int id) throws SQLException {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        Contato contato = new Contato();
        try{
            String sql = "select * from tbl_contato where id_contato = ?";
            comandoSql = conexao.prepareStatement(sql);
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
            //comandoSql.close();
            //conexao.close();
        }
        return contato;
    }

    //Método para buscar um conjunto de contatos
    //BuscarTodosContatos
    public List<Contato> listarContatos(){
        List<Contato> contatos = new ArrayList<>();
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("select * from tbl_contato order by id_contato");
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Contato contato = new Contato();
                contato.setCodigo(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipoContato(TipoContatoEnum.valueOf(rs.getString(6)));
                contatos.add(contato);
            }
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contatos;
    }

    //Método que exiba todos os contatos por tipo de contato
    public List<Contato> buscarPorTipo(String tipo){
        List<Contato> contatos = new ArrayList<>();
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("select * from tbl_contato where tipo = ? order by id_contato");
            comandoSql.setString(1, tipo);
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Contato contato = new Contato();
                contato.setCodigo(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setInstagram(rs.getString(5));
                contato.setTipoContato(TipoContatoEnum.valueOf(rs.getString(6)));
                contatos.add(contato);
            }
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contatos;
    }

    public void deletarContato (int id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;

        try{
            String sql = "delete from tbl_contato where id_contato = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
