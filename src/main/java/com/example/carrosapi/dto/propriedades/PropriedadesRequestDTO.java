package com.example.carrosapi.dto.propriedades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropriedadesRequestDTO{
    String motor;
    String aroRodas;
    boolean selfDriving;
}