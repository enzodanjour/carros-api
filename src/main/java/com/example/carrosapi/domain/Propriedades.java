package com.example.carrosapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Propriedades {
    @Id
    @GeneratedValue
    private Long id;

    String motor;
    String aroRodas;
    boolean selfDriving;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
}
