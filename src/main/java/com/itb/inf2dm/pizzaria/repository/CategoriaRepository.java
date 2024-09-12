package com.itb.inf2dm.pizzaria.repository;

import com.itb.inf2dm.pizzaria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
}

