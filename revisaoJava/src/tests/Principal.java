package tests;
import models.Filme;
import models.Serie;
import models.Titulo;



public class Principal {
    public static void main(String[] args) {
        Serie novaSerie = new Serie();
        novaSerie.setNome("Naruto");
        novaSerie.setAnoLancamento(2004);
        novaSerie.setDuracaoMinutos(500000);
        novaSerie.setAtivo(false);
        novaSerie.setTemporadas(18);
        novaSerie.setEpPorTemp(20);
        novaSerie.setMinPorEp(24);
        novaSerie.exibirFichaTecnica();

        Filme novoFilme = new Filme();
        novoFilme.setNome("Sem memória");

    }
}
