package com.example.carrosapi.service;

import com.example.carrosapi.domain.Propriedades;
import com.example.carrosapi.repository.PropriedadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropriedadesService {
    PropriedadesRepository repository;

    public PropriedadesService(PropriedadesRepository repository){
        this.repository = repository;
    }

    public Propriedades create(Propriedades c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Propriedades update(Propriedades c){
        return repository.saveAndFlush(c);
    }

    public Optional<Propriedades> findById(Long id){
        return repository.findById(id);
    }

    public List<Propriedades> findAll(){
        return repository.findAll();
    }
}
