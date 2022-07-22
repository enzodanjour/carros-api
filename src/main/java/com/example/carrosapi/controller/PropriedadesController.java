package com.example.carrosapi.controller;

import com.example.carrosapi.domain.Documentacao;
import com.example.carrosapi.domain.Propriedades;
import com.example.carrosapi.dto.documentacao.DocumentacaoRequestDTO;
import com.example.carrosapi.dto.documentacao.DocumentacaoResponseDTO;
import com.example.carrosapi.dto.propriedades.PropriedadesRequestDTO;
import com.example.carrosapi.service.DocumentacaoService;
import com.example.carrosapi.service.PropriedadesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propriedades")
@CrossOrigin(origins = "*")
public class PropriedadesController {
    PropriedadesService service;
    ModelMapper modelMapper = new ModelMapper();


    public PropriedadesController(PropriedadesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Propriedades> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<DocumentacaoResponseDTO> findById(@PathVariable Long id){
        Optional<Propriedades> c  = service.findById(id);
        if (c.isPresent()){
            Propriedades Documentacao = c.get();
            DocumentacaoResponseDTO DocumentacaoResponseDto = modelMapper.map(Documentacao, DocumentacaoResponseDTO.class);
            DocumentacaoResponseDto.addHateoasLinks(Documentacao.getId());

            return ResponseEntity.ok().body(DocumentacaoResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Documentacao> insert(@RequestBody PropriedadesRequestDTO c) throws URISyntaxException {


        Propriedades novo = modelMapper.map(c, Propriedades.class);



        service.create(novo);

        //Documentacao novo = service.create(c);
        URI uri = new URI("/Documentacaos/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }




    @PutMapping("/{id}")
    public ResponseEntity<Propriedades> update (@PathVariable Long id, @RequestBody Propriedades c){
        if (service.findById(id).isPresent()){
            Propriedades atualizado = service.update(c);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



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
