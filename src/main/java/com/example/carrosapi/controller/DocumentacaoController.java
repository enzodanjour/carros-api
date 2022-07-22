package com.example.carrosapi.controller;

import com.example.carrosapi.domain.Documentacao;
import com.example.carrosapi.service.DocumentacaoService;
import com.example.carrosapi.dto.documentacao.DocumentacaoRequestDTO;
import com.example.carrosapi.dto.documentacao.DocumentacaoResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentacao")
@CrossOrigin(origins = "*")
public class DocumentacaoController {

    DocumentacaoService service;
    ModelMapper modelMapper = new ModelMapper();


    public DocumentacaoController(DocumentacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Documentacao> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<DocumentacaoResponseDTO> findById(@PathVariable Long id){
        Optional<Documentacao> c  = service.findById(id);
        if (c.isPresent()){
            Documentacao Documentacao = c.get();
            DocumentacaoResponseDTO DocumentacaoResponseDto = modelMapper.map(Documentacao, DocumentacaoResponseDTO.class);
            DocumentacaoResponseDto.addHateoasLinks(Documentacao.getNumeroDocumento());

            return ResponseEntity.ok().body(DocumentacaoResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Documentacao> insert(@RequestBody DocumentacaoRequestDTO c) throws URISyntaxException {


        Documentacao novo = modelMapper.map(c, Documentacao.class);



        service.create(novo);

        //Documentacao novo = service.create(c);
        URI uri = new URI("/Documentacaos/" + novo.getNumeroDocumento());
        return ResponseEntity.created(uri).build();
    }




    @PutMapping("/{id}")
    public ResponseEntity<Documentacao> update (@PathVariable Long id, @RequestBody Documentacao c){
        if (service.findById(id).isPresent()){
            Documentacao atualizado = service.update(c);
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
