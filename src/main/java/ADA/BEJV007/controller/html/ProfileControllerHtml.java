package ADA.BEJV007.controller.html;

import ADA.BEJV007.domain.Address;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.mapper.ProfileMapper;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("profile_html")
@RestController
public class ProfileControllerHtml {

    @Autowired
    private GeneralService<Profile> profileService;
    @Autowired
    private GeneralService<Address>addressService;
    @Autowired
    private ProfileMapper mapper;

    protected ModelAndView form(Profile model, Address address, String sucesso, String erro) {
        return new ModelAndView("profile/form")
                .addObject("model", model)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    private ModelAndView form(List<Profile> lista, String sucesso, String erro) {
        return new ModelAndView("profile/table")
                .addObject("lista", lista)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    @GetMapping("listar")
    public ModelAndView listar() {
        return form(profileService.list(), null, null);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        return form(id != null ? profileService.findById(id) : new Profile(), new Address(),null, null);
    }

    @PostMapping("form")
    public ModelAndView savehtml(@Valid @ModelAttribute("model") Profile profile,Address address, BindingResult result){
        if (result.hasErrors()) {
            return form(profile, address, null, "Erro ao salvar Usuário");
        }
        profile.setEndereco(address);
        profileService.saveHtml(profile);
        return form(new Profile(), address, "Usuario salvo com sucesso", null);
    }

    @GetMapping("excluir")
    public ModelAndView excluir(@RequestParam(value = "id") Long id) {
        profileService.delete(id);
        return form(profileService.list(), "Perfil excluido com sucesso", null);
    }
}