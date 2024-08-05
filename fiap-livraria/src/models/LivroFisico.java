package models;

import models.enums.TipoCapaEnum;

public class LivroFisico extends Livro{

    private TipoCapaEnum tipoCapa;
    public LivroFisico(String titulo) {
        super(titulo);
    }

    public LivroFisico(String titulo, double preco) {
        super(titulo, preco);
    }

    public double getTaxaImpressao(){
        return valor * 0.05;
    }

    @Override
    public double getPreco() {
        return super.valor;
    }

    public String exibirDados(){
        return super.exibirDados() +
                "\nTaxa de Impressão:" + this.getTaxaImpressao() +
                "\n---------------" ;
    }
    @Override
    public double aplicarDesconto(){
        if(tipoCapa.equals(TipoCapaEnum.COMUM))
            return valor * 0.95;
        return 0;
    }
    public TipoCapaEnum getTipoCapa() {
        return tipoCapa;
    }

    public void setTipoCapa(TipoCapaEnum tipoCapa) {
        this.tipoCapa = tipoCapa;
    }
}