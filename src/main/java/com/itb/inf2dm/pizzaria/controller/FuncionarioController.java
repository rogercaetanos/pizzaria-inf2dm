package com.itb.inf2dm.pizzaria.controller;

// @Controller :    Exclusivo para sistemas WEB
// @RestController:  Exclusivo para API´S


import com.itb.inf2dm.pizzaria.model.Categoria;
import com.itb.inf2dm.pizzaria.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario") // Representa a url principal
public class FuncionarioController {

   private final CategoriaService categoriaService;

    public FuncionarioController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // @GetMapping:     complementação da url principal, utilizados exclusivamente em CONSULTAS
    // ResponseEntity:  Representa a resposta de qualquer tipo de modelo ( Entidade ). Listas ou Objetos

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {

        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }


}
