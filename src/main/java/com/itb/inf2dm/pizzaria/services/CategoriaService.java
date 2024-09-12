package com.itb.inf2dm.pizzaria.services;

import com.itb.inf2dm.pizzaria.model.Categoria;
import java.util.List;

public interface CategoriaService {

    public Categoria salvarCategoria(Categoria categoria);
    public boolean deletarCategoria(Long id);
    public Categoria listarCategoriaPorId(Long id);
    public List<Categoria> listarTodasCategorias();
    public Categoria atualizarCategoria(Categoria categoria, Long id);

}
