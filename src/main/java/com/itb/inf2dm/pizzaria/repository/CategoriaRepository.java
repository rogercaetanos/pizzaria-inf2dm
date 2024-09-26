package com.itb.inf2dm.pizzaria.repository;

import com.itb.inf2dm.pizzaria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

    @Query(value = "SELECT * FROM Categoria c WHERE c.cod_status = '1'", nativeQuery = true)
    public List<Categoria> listarTodasCategoriasAtivas();

    @Query(value = "SELECT * FROM Categoria c WHERE c.id = ?1 AND c.cod_status = '1'", nativeQuery = true)
    public Categoria listarCategoriaPorIdAtiva(Long id);

}

