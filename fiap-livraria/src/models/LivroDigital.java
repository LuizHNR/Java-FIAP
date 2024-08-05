package models;

public class LivroDigital extends Livro {
    private String marcaDagua;
    public String getMarcaDagua() {
        return marcaDagua;
    }
    public void setMarcaDagua(String marcaDagua) {
        this.marcaDagua = marcaDagua;
    }

    public LivroDigital(String marcaDagua) {
        this.marcaDagua = marcaDagua;
    }



    public LivroDigital(String titulo, String autor,
                        double valor, Editora editora,
                        int paginas, String resumo,
                        String marcaDagua) {
        super(titulo, autor, valor, editora, paginas, resumo);
        this.marcaDagua = marcaDagua;
    }

    @Override
    public double getPreco() {
        return super.valor;
    }

    @Override
    public String exibirDados(){
        return super.exibirDados() +
                "\nMarca D'Agua:" + this.marcaDagua +
                "\n---------------" ;
    }
    @Override
    public double aplicarDesconto(){
        //setValor(getValor() * 0.8);
        return getValor() * 0.80;
    }
}