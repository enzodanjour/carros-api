package com.example.carrosapi.service;

import com.example.carrosapi.domain.Carro;
import com.example.carrosapi.domain.Documentacao;
import com.example.carrosapi.repository.CarroRepository;
import com.example.carrosapi.repository.DocumentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentacaoService {
    DocumentacaoRepository repository;

    public DocumentacaoService(DocumentacaoRepository repository){
        this.repository = repository;
    }

    public Documentacao create(Documentacao c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Documentacao update(Documentacao c){
        return repository.saveAndFlush(c);
    }

    public Optional<Documentacao> findById(Long id){
        return repository.findById(id);
    }

    public List<Documentacao> findAll(){
        return repository.findAll();
    }
}
