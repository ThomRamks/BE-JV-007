package ADA.BEJV007.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetSaveDTO;
import ADA.BEJV007.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {
    private final PetService petService;

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