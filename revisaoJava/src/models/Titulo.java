package models;

public abstract class Titulo {
    //Atributos -> Caraterísticas
    private String nome;
    private int anoLancamento;
    private int duracaoMinutos;
    protected double somaAvaliacao;
    protected int totalAvaliacoes;

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }


    //Métodos
    public void exibirFichaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anoLancamento);
    }
    //Método abstrato
    public abstract void somarAvaliacoes(double nota);
}
