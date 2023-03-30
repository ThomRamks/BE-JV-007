package ADA.BEJV007.controller;

import ADA.BEJV007.dto.PetDTO;
import ADA.BEJV007.mapper.PetMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetSaveDTO;
import ADA.BEJV007.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets")
@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetMapper mapper;

    @GetMapping
    public List<Pet>listar(){
        return petService.list();
    }

    @GetMapping("{id}")
    public Pet getById(@PathVariable Long id){
        return petService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet save(@Valid @RequestBody PetSaveDTO dto){
        return petService.save(dto);
    }

    @PutMapping("{id}")
    public Pet update (@PathVariable Long id, @RequestBody PetSaveDTO dto){
        Pet pet = mapper.pet(dto);
        return petService.update(id, pet);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        petService.delete(id);
    }
}