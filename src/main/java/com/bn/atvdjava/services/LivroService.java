package com.bn.atvdjava.services;

import com.bn.atvdjava.models.LivroModel;
import com.bn.atvdjava.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroModel criarLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public List<LivroModel> listarLivros() {
        return livroRepository.findAll();
    }

    public LivroModel procurarPorId(Long id) {
        return livroRepository.findById(id).get();
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

}