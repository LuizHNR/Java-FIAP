package models;

import enums.TipoContatoEnum;

import java.util.UUID;

public class Contato {

    /* Obrigatoriedades:
        1 codigo
        1 atributo que categorize o objeto
    * */
    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    private String instagram;
    private TipoContatoEnum tipoContato;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public TipoContatoEnum getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContatoEnum tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", instagram='" + instagram + '\'' +
                ", tipoContato=" + tipoContato +
                '}';
    }
}
