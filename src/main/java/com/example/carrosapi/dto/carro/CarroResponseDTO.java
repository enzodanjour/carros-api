package com.example.carrosapi.dto.carro;

import com.example.carrosapi.controller.CarroController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class CarroResponseDTO extends RepresentationModel<CarroResponseDTO> {
    String modelo;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(CarroController.class).slash(id).withSelfRel());
        this.add(linkTo(CarroController.class).withRel("GET"));
        this.add(linkTo(CarroController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(CarroController.class).slash(id).withRel("PUT"));
        this.add(linkTo(CarroController.class).withRel("POST"));

    }
}

