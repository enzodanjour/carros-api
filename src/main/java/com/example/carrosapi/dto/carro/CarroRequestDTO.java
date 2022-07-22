package com.example.carrosapi.dto.carro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroRequestDTO {
    String modelo;
    String montadora;
}
