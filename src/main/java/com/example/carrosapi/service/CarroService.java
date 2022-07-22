package com.example.carrosapi.service;

import com.example.carrosapi.domain.Carro;
import com.example.carrosapi.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    CarroRepository repository;

    public CarroService(CarroRepository repository){
        this.repository = repository;
    }

    public Carro create(Carro c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Carro update(Carro c){
        return repository.saveAndFlush(c);
    }

    public Optional<Carro> findById(Long id){
        return repository.findById(id);
    }

    public List<Carro> findAll(){
        return repository.findAll();
    }
}
