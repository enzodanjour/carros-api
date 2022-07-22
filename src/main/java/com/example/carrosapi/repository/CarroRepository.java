package com.example.carrosapi.repository;

import com.example.carrosapi.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarroRepository extends JpaRepository<Carro,Long> {

}
