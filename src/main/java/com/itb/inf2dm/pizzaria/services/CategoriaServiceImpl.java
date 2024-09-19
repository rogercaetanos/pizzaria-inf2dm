package com.itb.inf2dm.pizzaria.services;


import com.itb.inf2dm.pizzaria.exceptions.BadRequest;
import com.itb.inf2dm.pizzaria.exceptions.NotFound;
import com.itb.inf2dm.pizzaria.model.Categoria;
import com.itb.inf2dm.pizzaria.model.Produto;
import com.itb.inf2dm.pizzaria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        categoria.setCodStatus(true);
        if(!categoria.validarCategoria()){
            throw new BadRequest(categoria.getMensagemErro());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean deletarCategoria(Long id) {
        if(categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }else {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }

    @Override
    public Categoria listarCategoriaPorId(Long id) {
        try{
            return categoriaRepository.findById(id).get();
        }catch (Exception ex ){
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }

    @Override
    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria, Long id) {
        try {
            if(!categoria.validarCategoria()) {
                throw new BadRequest(categoria.getMensagemErro());
            }
            Categoria categoriaDb = categoriaRepository.findById(id).get();
            categoriaDb.setNome(categoria.getNome());
            categoriaDb.setDescricao(categoria.getDescricao());
            return categoriaRepository.save(categoriaDb);  // save: Atualiza quando já temos o objeto no banco
        } catch (Exception ex){
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }
}
