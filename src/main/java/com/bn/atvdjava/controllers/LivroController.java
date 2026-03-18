package com.bn.atvdjava.controllers;

import com.bn.atvdjava.models.LivroModel;
import com.bn.atvdjava.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroModel salvar(@RequestBody LivroModel livroModel) {
        return livroService.criarLivro(livroModel);
    }

    @GetMapping
    public List<LivroModel> listarLivros() {
        return  livroService.listarLivros();
    }

    @PutMapping("/{id}")
    public LivroModel atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel) {
        return livroService.atualizarLivro(id,livroModel);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}