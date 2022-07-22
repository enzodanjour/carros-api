package com.example.carrosapi.dto.documentacao;

import com.example.carrosapi.controller.DocumentacaoController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class DocumentacaoResponseDTO extends RepresentationModel<DocumentacaoResponseDTO> {
    String chassi;
    String placa;
    int qtdMultas;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(DocumentacaoController.class).slash(id).withSelfRel());
        this.add(linkTo(DocumentacaoController.class).withRel("GET"));
        this.add(linkTo(DocumentacaoController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(DocumentacaoController.class).slash(id).withRel("PUT"));
        this.add(linkTo(DocumentacaoController.class).withRel("POST"));

    }
}

