package br.com.fiap.web.dto;

import br.com.fiap.web.model.Produto;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoRequestDto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoRequestDto convertToDto(Produto produto) {
        ProdutoRequestDto produtoRequestDto = new ProdutoRequestDto();
        produtoRequestDto.setCodigo(produto.getCodigo());
        produtoRequestDto.setNome(produto.getNome());
        produtoRequestDto.setPreco(produto.getPreco());
        produtoRequestDto.setQuantidade(produto.getQuantidade());
        return produtoRequestDto;
    }

    public Produto convert(ProdutoRequestDto produtoRequestDto){
        Produto produto = new Produto();
        produto.setCodigo(produtoRequestDto.getCodigo());
        produto.setNome(produtoRequestDto.getNome());
        produto.setPreco(produtoRequestDto.getPreco());
        produto.setQuantidade(produtoRequestDto.getQuantidade());
        return produto;
    }
}
