package com.bn.atvdjava.services;

import com.bn.atvdjava.models.LivroModel;
import com.bn.atvdjava.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroModel criarLivros(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public List<LivroModel> listarLivros() {
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroModel atualizarLivro(Long id, LivroModel pordutoModel) {
        LivroModel newLivroModel = livroRepository.findById(id).get();
        newLivroModel.setTitulo(pordutoModel.getTitulo());
        newLivroModel.setAutor(pordutoModel.getAutor());
        newLivroModel.setAnoPublicacao(pordutoModel.getAnoPublicacao());
        return livroRepository.save(newLivroModel);
    }
}