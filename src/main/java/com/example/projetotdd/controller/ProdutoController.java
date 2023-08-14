package com.example.projetotdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos() throws Exception {

        List<Produto> produtos = produtoService.obterTodos();

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable Long id) {

        Optional<Produto> produto = produtoService.obterPorId(id);

        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {

        Produto adicionado = produtoService.adicionar(produto);

        return new ResponseEntity<>(adicionado, HttpStatus.CREATED);
    }
}
