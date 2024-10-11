package br.com.fiap.web.service;

import br.com.fiap.web.dao.ProdutoDao;
import br.com.fiap.web.dto.ProdutoRequestDto;
import br.com.fiap.web.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService {

    private ProdutoDao produtoDao = new ProdutoDao();

    public List<ProdutoRequestDto> listar(){
        List<Produto> produtos = produtoDao.listar();
        return produtos.stream()
                .map(produto -> {
                    ProdutoRequestDto produtoDto = new ProdutoRequestDto();
                    produtoDto.setCodigo(produto.getCodigo());
                    produtoDto.setNome(produto.getNome());
                    produtoDto.setPreco(produto.getPreco());
                    produtoDto.setQuantidade(produto.getQuantidade());
                    return produtoDto;
                })
                .collect(Collectors.toList());
    }

    //Retornar um único produto -> buscarPorId
    public ProdutoRequestDto buscarPorId(int codigo){
         Produto produto = produtoDao.buscarPorId(codigo);
         ProdutoRequestDto produtoRequestDto = new ProdutoRequestDto();
        return produtoRequestDto.convertToDto(produto);
    }

    public void cadastrar(ProdutoRequestDto produtoDto){
        Produto produto = produtoDto.convert(produtoDto);
        produtoDao.inserir(produto);
    }

    public void atualizar(ProdutoRequestDto produtoDto){
        Produto produto = produtoDto.convert(produtoDto);
        produtoDao.alterar(produto);
    }

    public void deletar(int id){
        produtoDao.excluir(id);
    }

}
