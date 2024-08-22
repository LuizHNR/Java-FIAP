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

}
