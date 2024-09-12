package com.itb.inf2dm.pizzaria.services;


import com.itb.inf2dm.pizzaria.exceptions.BadRequest;
import com.itb.inf2dm.pizzaria.exceptions.NotFound;
import com.itb.inf2dm.pizzaria.model.Produto;
import com.itb.inf2dm.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

     //@Autowired   // Injeção de dependencia : Não é recomendável
    // private ProdutoRepository produtoRepository;
    // final : atributo que uma vez atribuído não pode ser alterado
    private final ProdutoRepository produtoRepository;

    // Injeção de Dependência utilizando o construtor da classe

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto salvarProduto(Produto produto) {
        if(!produto.validarProduto()){
            throw new BadRequest(produto.getMensagemErro());
        }
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public boolean deletarProduto(Long id) {
        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }else {
           throw new NotFound("Produto não encontrado com o id " + id);
        }
    }

    // try    -> Tente realizar o código corretamente
    // catch  -> Executado quando o código contido em try apresenta problemas
    @Override
    public Produto listarProdutoPorId(Long id) {
        try{
            return produtoRepository.findById(id).get();
        }catch (Exception ex ){
             throw new NotFound("Produto não encontrado com o id " + id);
        }
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    @Transactional
    public Produto atualizarProduto(Produto produto, Long id) {
        try {
            if(!produto.validarProduto()) {
                throw new BadRequest(produto.getMensagemErro());
            }
           Produto produtoDb = produtoRepository.findById(id).get();
           produtoDb.setNome(produto.getNome());
           produtoDb.setTipo(produto.getTipo());
           produtoDb.setDescricao(produto.getDescricao());
           produtoDb.setValorVenda(produto.getValorVenda());
           return produtoRepository.save(produtoDb);  // save: Atualiza quando já temos o objeto no banco
        } catch (Exception ex){
            throw new NotFound("Produto não encontrado com o id " + id);
        }

    }
}
