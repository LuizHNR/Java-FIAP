package br.com.fiap.cliente.dao;

import br.com.fiap.cliente.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {
    private Connection conexao;

    public EnderecoDao() {
        this.conexao = ConnectionFactory.getConnection();
    }
    /*insert into tbl_endereco(idEndereco, cep, rua, complemento, bairro, cidade, uf, numero)
     values(1,"01310914","AV. PAULISTA", "4 ANDAR","BELA VISTA","SÃO PAULO", "SP", "1001")*/

    public void inserir(Endereco endereco){
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into tbl_endereco(idEndereco, cep, rua, complemento, bairro, cidade, uf, numero)" +
                    " values(?,?,?,?,?,?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, endereco.getId());
            comandoSql.setString(2, endereco.getCep());
            comandoSql.setString(3, endereco.getLogradouro());
            comandoSql.setString(4, endereco.getComplemento());
            comandoSql.setString(5, endereco.getBairro());
            comandoSql.setString(6, endereco.getLocalidade());
            comandoSql.setString(7, endereco.getUf());
            comandoSql.setString(8, endereco.getNumero());
            comandoSql.executeUpdate();
            //conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Buscar por id => SELECT * FROM TBL_ENDERECO WHERE IDENDERECO = ?
    public Endereco buscarPorId(int id){
        Endereco endereco = new Endereco();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM TBL_ENDERECO WHERE IDENDERECO = ?");
            comandoSql.setInt(1, id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                endereco.setId(rs.getInt(1));
                endereco.setCep(rs.getString(2));
                endereco.setLogradouro(rs.getString(3));
                endereco.setComplemento(rs.getString(4));
                endereco.setBairro(rs.getString(5));
                endereco.setLocalidade(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    //Listar => SELECT * FROM TBL_ENDERECO
    public List<Endereco> listar(){
        List<Endereco> enderecos = new ArrayList<>();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM TBL_ENDERECO");
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt(1));
                endereco.setCep(rs.getString(2));
                endereco.setLogradouro(rs.getString(3));
                endereco.setComplemento(rs.getString(4));
                endereco.setBairro(rs.getString(5));
                endereco.setLocalidade(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
                enderecos.add(endereco);
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;
    }
}
