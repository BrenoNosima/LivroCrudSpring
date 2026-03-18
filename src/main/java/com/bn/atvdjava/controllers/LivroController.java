package com.bn.atvdjava.controllers;

import com.bn.atvdjava.models.LivroModel;
import com.bn.atvdjava.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroModel> salvar(@RequestBody LivroModel livroModel) {
        LivroModel request = livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> listarLivros() {
        List<LivroModel> request = livroService.listarLivros();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> procurarPorId(@PathVariable Long id) {
        LivroModel request = livroService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}