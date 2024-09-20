package com.itb.inf2dm.pizzaria.controller;

// @Controller :    Exclusivo para sistemas WEB
// @RestController:  Exclusivo para API´S


import com.itb.inf2dm.pizzaria.exceptions.BadRequest;
import com.itb.inf2dm.pizzaria.model.Categoria;
import com.itb.inf2dm.pizzaria.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario") // Representa a url principal
public class FuncionarioController {

   private final CategoriaService categoriaService;

    public FuncionarioController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // @GetMapping:     complementação da url principal, utilizado exclusivamente em CONSULTAS
    // @PostMapping:    complementação da url principal, utilizado exclusivamente para CADASTRO (INSERT)
    // @PutMapping:     complementação da url principal, utilizado exclusivamente para ATUALIZAR (UPDATE)
    // ResponseEntity:  Representa a resposta de qualquer tipo de modelo ( Entidade ). Listas ou Objetos
    // @RequestBody:    Representa o objeto recebido do front-end

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {

        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }


    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.listarCategoriaPorId(Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, fornceça um valor inteiro, como 10");
        }

    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());

        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable (value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.atualizarCategoria(categoria, Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, fornceça um valor inteiro, como 10");
        }

    }






}
