package br.com.fiap.c2.dto;

import br.com.fiap.c2.model.Genero;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

public class JogoRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150,
            message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;
    @NotNull(message = "A data de Lançamento é obrigatório")
    private LocalDate dataLancamento;
    @NotNull(message = "O genero é obrigatório")
    private Genero genero;

    public JogoRequest() {
    }

    public JogoRequest(String nome, LocalDate dataLancamento, Genero genero) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.genero = genero;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
