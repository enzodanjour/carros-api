package com.example.carrosapi.controller;

import com.example.carrosapi.domain.Carro;
import com.example.carrosapi.dto.carro.CarroRequestDTO;
import com.example.carrosapi.dto.carro.CarroResponseDTO;
import com.example.carrosapi.service.CarroService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "*")
public class CarroController {

    CarroService service;
    ModelMapper modelMapper = new ModelMapper();


    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carro> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CarroResponseDTO> findById(@PathVariable Long id){
        Optional<Carro> c  = service.findById(id);
        if (c.isPresent()){
            Carro Carro = c.get();
            CarroResponseDTO CarroResponseDto = modelMapper.map(Carro, CarroResponseDTO.class);
            CarroResponseDto.addHateoasLinks(Carro.getId());
            /*
            Carro.add(linkTo(CarroController.class).slash(Carro.getId()).withSelfRel());
            Carro.add(linkTo(CarroController.class).withRel("GET"));
            Carro.add(linkTo(CarroController.class).slash(Carro.getId()).withRel("DELETE"));
            Carro.add(linkTo(CarroController.class).slash(Carro.getId()).withRel("PUT"));
            Carro.add(linkTo(CarroController.class).withRel("POST"));

            Carro.getEndereco().add(linkTo(EnderecoController.class).slash(Carro.getEndereco().getId()).withSelfRel());
            Carro.getEndereco().add(linkTo(EnderecoController.class).withRel("allEnderecos"));
            Carro.getEndereco().add(linkTo(EnderecoController.class).slash(Carro.getEndereco().getId()).withRel("delete"));

             */
            return ResponseEntity.ok().body(CarroResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carro> insert(@RequestBody CarroRequestDTO c) throws URISyntaxException {


        Carro novo = modelMapper.map(c, Carro.class);

        /*
        Carro novo = new Carro();
        novo.setNome(c.getNome());
        novo.setEndereco(c.getEndereco());
         */

        service.create(novo);

        //Carro novo = service.create(c);
        URI uri = new URI("/Carros/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }

    /*
    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Carro insert(@RequestBody Carro c) {
        return service.create(c);
    }*/


    @PutMapping("/{id}")
    public ResponseEntity<Carro> update (@PathVariable Long id, @RequestBody Carro c){
        if (service.findById(id).isPresent()){
            Carro atualizado = service.update(c);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Carro> update (@PathVariable Long id, @RequestBody Carro c){
        return service
                .findById(id)
                .map( record -> {
                    Carro atualizado = service.update(c);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }*/

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if (service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
