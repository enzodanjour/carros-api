package com.example.carrosapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String modelo;
    String montadora;
    String preco;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn
    Documentacao documentacao;

    @OneToMany(mappedBy = "carro", fetch = FetchType.LAZY)
    private Set<Propriedades> propriedades;
}
