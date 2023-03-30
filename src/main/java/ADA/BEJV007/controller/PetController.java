package ADA.BEJV007.controller;


import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetSaveDTO;
import ADA.BEJV007.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets")
@RestController
public class PetController {
    private final PetService petService;

    private ModelAndView form(Pet model, String sucesso, String erro) {
        return new ModelAndView("pet/form")
                .addObject("model", model)
                .addObject("tipos", TiposPet.values())
                .addObject("statuspets", StatusPet.values())
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form(List<Pet> lista, String sucesso, String erro) {
        return new ModelAndView("pet/table")
                .addObject("lista", lista)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    @GetMapping("listar")
    public ModelAndView listar() {
        return form(petService.listar(), null, null);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        return form(id != null ? petService.findById(id) : new Pet(), null, null);
    }

    @GetMapping("{id}")
    public Pet getById(@PathVariable Long id){
        return petService.findById(id);
    }

    @PostMapping("form")
    public ModelAndView save(@Valid @ModelAttribute("model") PetSaveDTO dto, BindingResult result){
        Pet pet = Pet.builder()
                .nome(dto.getNome())
                .tipo(dto.getTipo())
                .nascimento(dto.getNascimento())
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .build();
        if (result.hasErrors()) {
            return form(pet, null, "Erro ao salvar Pet"); // devolve os dados preenchidos
        }

         petService.save(pet);

        return form(new Pet(), "Pet salvo com sucesso", null);
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
