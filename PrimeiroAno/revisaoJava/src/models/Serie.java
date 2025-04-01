package models;

public class Serie extends Titulo{

    private int temporadas;
    private boolean ativo;
    private int epPorTemp;
    private int minPorEp;

    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getEpPorTemp() {
        return epPorTemp;
    }
    public void setEpPorTemp(int epPorTemp) {
        this.epPorTemp = epPorTemp;
    }

    public int getMinPorEp() {
        return minPorEp;
    }
    public void setMinPorEp(int minPorEp) {
        this.minPorEp = minPorEp;
    }

    @Override
    public void exibirFichaTecnica() {
        super.exibirFichaTecnica();
        System.out.println("Número de temporadas: " + temporadas);
        System.out.println("Quantidade de episódios por temporada: " + epPorTemp);
        System.out.println("Tempo de episódio por minuto: " + minPorEp);

        if (ativo == true) {
            System.out.println("A série ainda não foi finalizada");
        }else {
            System.out.println("A série já foi finalizada aproveite para maratonar");
        }
    }

    @Override
    public void somarAvaliacoes(double nota) {
        somaAvaliacao += nota;
    }
}
