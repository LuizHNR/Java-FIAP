package models;

public class LivroAudio extends Livro{
    @Override
    public double aplicarDesconto() {
        return 0;
    }

    @Override
    public double getPreco() {
        return super.valor;
    }
}