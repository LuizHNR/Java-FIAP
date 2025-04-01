package tests;

import models.Editora;
import models.LivroDigital;
import models.LivroFisico;
import models.RegistroVendas;
import models.enums.TipoCapaEnum;

import java.io.IOException;

//Classe de execução => main
public class CriarLivros {
    public static void main(String[] args) throws IOException {
        //Instanciando um objeto => criar o objeto na memória
        // tipoObjeto nomeObjeto = operadorInstanciação  construtor;
        //   models.Livro      favorito =       new               models.Livro();
        //Instanciar editora
        Editora editora = new Editora();
        editora.nome = "Harper Collins";
        editora.representante = "Joao";
        LivroFisico favorito = new LivroFisico("O Hobbit");
        //favorito.titulo = "O Hobbit";
        favorito.setAutor("J. R. R. Talkien");
        favorito.setValor(37.27);
        favorito.setEditora(editora);
        favorito.setResumo("Bilbo era um dos ...");
        favorito.setTipoCapa(TipoCapaEnum.COMUM);

        System.out.println("Meu livro favorito é:" +
        favorito.getTitulo() + "\nSeu autor é: " + favorito.getAutor() +
        " preço: R$ " + favorito.getValor());
        System.out.println(favorito.exibirDados());

        LivroFisico meuLivro = new LivroFisico("UML 2.0",5.0);
        //meuLivro.titulo = "UML 2.0";
        meuLivro.setValor(58.98);
        meuLivro.setEditora(editora);
        //System.out.println("\n\nTitulo: " + meuLivro.titulo);
        //System.out.println("Autor: " + meuLivro.autor);
        System.out.println(meuLivro.exibirDados());

        LivroDigital livroDigital = new LivroDigital("Teste");
        livroDigital.setTitulo("Senhor dos anéis");
        //livroDigital.

        RegistroVendas carrinho = new RegistroVendas();
        carrinho.adicionar(favorito);
        carrinho.adicionar(meuLivro);
        carrinho.adicionar(livroDigital);
        String path = "D:\\1TDSPM\\LuizH\\java\\fiap-livraria\\Cupom.txt";
        carrinho.ImprimirCupom(path);

    }
}
