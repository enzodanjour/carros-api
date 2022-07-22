package com.example.carrosapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Documentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numeroDocumento;

    String chassi;
    String placa;
    int qtdMultas;
}
