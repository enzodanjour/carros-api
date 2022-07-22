package com.example.carrosapi.repository;

import com.example.carrosapi.domain.Documentacao;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DocumentacaoRepository extends JpaRepository<Documentacao,Long> {
}
