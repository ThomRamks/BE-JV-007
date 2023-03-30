package ADA.BEJV007.controller.html;


import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import ADA.BEJV007.dto.PetSaveDTO;
import ADA.BEJV007.mapper.PetMapper;
import ADA.BEJV007.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("pets_html")
@RestController
public class PetControllerHtml {

    @Autowired
    private PetService petService;

    @Autowired
    private PetMapper mapper;

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
        return form(petService.list(), null, null);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        return form(id != null ? petService.findById(id) : new Pet(), null, null);
    }

//    @PostMapping("form")
//    public ModelAndView save(@Valid @ModelAttribute("model") Pet pet, BindingResult result){
//        if (result.hasErrors()) {
//            return form(pet, null, "Erro ao salvar Pet"); // devolve os dados preenchidos
//        }
//
//         petService.save(pet);
//
//        return form(new Pet(), "Pet salvo com sucesso", null);
//    }

    @GetMapping("excluir")
    public ModelAndView excluir(@RequestParam(value = "id") Integer id) {
        petService.delete(Long.valueOf(id));
        return form(petService.list(), "Pet excluido com sucesso", null);
    }

}
