package com.itb.inf2dm.pizzaria.services;

import com.itb.inf2dm.pizzaria.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto salvarProduto(Produto produto);
    public boolean deletarProduto(Long id);
    public Produto listarProdutoPorId(Long id);
    public List<Produto> listarTodosProdutos();
    public Produto atualizarProduto(Produto produto, Long id);

}
