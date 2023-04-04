package ADA.BEJV007.controller.html;


import ADA.BEJV007.domain.Adocao;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.mapper.PetMapper;
import ADA.BEJV007.repository.AdocaoRepository;
import ADA.BEJV007.repository.ProfileRepository;
import ADA.BEJV007.service.GeneralService;
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
    private GeneralService<Adocao> adocaoService;
    @Autowired
    private GeneralService<Pet> petService;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AdocaoRepository adocaoRepository;
    @Autowired
    private PetMapper petMapper;


    private ModelAndView form(Pet pet, Adocao adocao, String sucesso, String erro) {
        adocao.setIdPet(pet);
        return new ModelAndView("adocao/form")
                .addObject("model", adocao)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form1(List<Adocao> listaAdocao, String sucesso, String erro) {
        return new ModelAndView("adocao/cardAdot")
                .addObject("listaAdocao", listaAdocao)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form2(List<Pet> listaPets, String sucesso, String erro) {
        return new ModelAndView("adocao/cardDisp")
                .addObject("listaPets", listaPets)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        Adocao adocao = new Adocao();
        return form(id != null ? petService.findById(id) : new Pet(), adocao, null, null);
    }

    @GetMapping("listardisp")
    public ModelAndView listarDisponiveis() {
        return form2(petService.list().stream().filter(pet -> pet.getStatus().equals(StatusPet.DISPONIVEL)).toList(), null, null);
    }

    @GetMapping("listaradotados")
    public ModelAndView listarAdotados() {
        return form1(adocaoService.list(), null, null);
    }

    @PostMapping("form")
    public ModelAndView savehtml(@Valid @ModelAttribute("model") Adocao adocao, BindingResult result) {
        if (result.hasErrors()) {
            return listarDisponiveis();
        }
        adocaoService.saveHtml(adocao);
        return listarAdotados();
    }
}