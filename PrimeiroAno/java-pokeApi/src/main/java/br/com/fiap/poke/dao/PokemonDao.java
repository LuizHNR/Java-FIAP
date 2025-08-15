package br.com.fiap.poke.dao;

import br.com.fiap.poke.model.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDao {

    private Connection conexao;

    public PokemonDao() {
        this.conexao = ConnectionFactory.obterConexao();
    }

    public void Cadastrar(Pokemon pokemon){
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into pokemon(num_pokedex, nome_poke)" +
                    " values(?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, pokemon.getId());
            comandoSql.setString(2, pokemon.getNome());

            comandoSql.executeUpdate();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon buscarPorNum(int numPoke){
        Pokemon pokemon = new Pokemon();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM pokemon WHERE num_pokedex = ?");
            comandoSql.setInt(1, numPoke);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                pokemon.setId(rs.getInt(1));
                pokemon.setNome(rs.getString(2));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pokemon;
    }

    public Pokemon buscarPorNom(String nomPok){
        Pokemon pokemon = new Pokemon();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM pokemon WHERE nome_poke = ?");
            comandoSql.setString(1, nomPok);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                pokemon.setId(rs.getInt(1));
                pokemon.setNome(rs.getString(2));
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pokemon;
    }

    public List<Pokemon> listar(){
        List<Pokemon> listaPokemon = new ArrayList<>();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM pokemon");
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt(1));
                pokemon.setNome(rs.getString(2));
                listaPokemon.add(pokemon);
            }
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPokemon;
    }
}
