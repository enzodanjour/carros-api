package com.example.carrosapi.dto.documentacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentacaoRequestDTO {
    
    private String chassi;
    private String placa;
    private int qtdMultas;
}
