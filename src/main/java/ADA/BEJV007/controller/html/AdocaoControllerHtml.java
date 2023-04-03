package ADA.BEJV007.controller.html;


import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.domain.enums.TiposPet;
import ADA.BEJV007.service.GeneralService;
import ADA.BEJV007.service.ProfileServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("adocao_html")
@RestController
public class AdocaoControllerHtml {
    @Autowired
    private GeneralService<Pet> petService;
    @Autowired
    private GeneralService<Profile> profileService;


    private ModelAndView form(Pet model, String sucesso, String erro) {
        return new ModelAndView("adocao/form")
                .addObject("model", model)
                .addObject("tipos", TiposPet.values())
                .addObject("statuspets", StatusPet.values())
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form1(List<Pet> lista, String sucesso, String erro) {
        return new ModelAndView("adocao/cardAdot")
                .addObject("lista", lista)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form2(List<Pet> lista, String sucesso, String erro) {
        return new ModelAndView("adocao/cardDisp")
                .addObject("lista", lista)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        return form(petService.findById(id), null, null);
    }

    @GetMapping("listardisp")
    public ModelAndView listarDisponiveis() {
        return form2(petService.list().stream().filter(pet -> pet.getStatus().equals(StatusPet.DISPONIVEL)).toList(), null, null);
    }

    @GetMapping("listaradotados")
    public ModelAndView listarAdotados() {
        return form1(petService.list().stream().filter(pet -> pet.getStatus().equals(StatusPet.ADOTADO)).toList(), null, null);
    }

    @PostMapping("form")
    public ModelAndView savehtml(@Valid @ModelAttribute("model") Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return listarDisponiveis();
        }
        Profile dono = profileService.findById(pet.getDono().getId());
        pet.setStatus(StatusPet.ADOTADO);
        petService.saveHtml(pet);
        return listarAdotados();
    }
}
