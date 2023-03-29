package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.domain.ONG;
import org.example.domain.Pet;
import org.example.dto.PetSaveDTO;
import org.example.repository.ONGRepository;
import org.example.service.PetService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets")
@RestController
public class PetController {
    private final PetService petService;

    @GetMapping("{id}")
    public Pet getById(@PathVariable Long id){
        return petService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet save(@RequestBody PetSaveDTO dto){
        Pet pet = Pet.builder()
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .nascimento(dto.getNascimento())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .build();
        return petService.save(pet);
    }

    @PutMapping("{id}")
    public Pet update (@PathVariable Long id, @RequestBody PetSaveDTO dto){
        Pet pet = Pet.builder()
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .nascimento(dto.getNascimento())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .build();
        return petService.update(id, pet);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        petService.delete(id);
    }




}
