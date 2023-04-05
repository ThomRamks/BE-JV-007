package ADA.BEJV007.controller;

import ADA.BEJV007.mapper.PetMapper;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {

    @Autowired
    private GeneralService<Pet> petService;

    @Autowired
    private PetMapper mapper;

    @GetMapping("{id}")
    public Pet getById(@PathVariable Long id){
        return petService.findById(id);
    }

    @GetMapping()
    public List<Pet> listar(){
        return petService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet save(@Valid @RequestBody PetSaveDTO dto){
        Pet pet = mapper.pet(dto);
        return petService.save(pet);
    }

    @PutMapping("{id}")
    public Pet update (@PathVariable Long id, @Valid @RequestBody PetSaveDTO dto){
        Pet pet = mapper.pet(dto);
        return petService.update(id, pet);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        petService.delete(id);
    }
}