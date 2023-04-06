package ADA.BEJV007.controller.html;

import ADA.BEJV007.domain.Address;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.service.APIConsumer;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RequiredArgsConstructor
@RequestMapping("enderecos_html")
@RestController
public class AddressControllerHtml {

    @Autowired
    private GeneralService<Address>addressService;
    @Autowired
    private ProfileControllerHtml profileControllerHtml;
    private final APIConsumer consumer;

    private ModelAndView form(Address model, String sucesso, String erro) {
        return new ModelAndView("adress/form")
                .addObject("model", model)
                .addObject("sucesso", sucesso)
                .addObject("erro", erro);
    }

    @GetMapping("form")
    public ModelAndView pegar(@RequestParam(value = "id", required = false) Long id) {
        return form(id != null ? addressService.findById(id) : new Address(), null, null);
    }

    @PostMapping("form/cep")
    public ModelAndView cephtml(@Valid @ModelAttribute("model") Address address, BindingResult result)  {
        if (result.hasErrors()) {
            return form(address, null, "Erro ao encontrar Endereço");
        }
        Address addressAux = consumer.apiAddress(address);
        addressAux.setNumero(address.getNumero());
        addressAux.setAdicional(address.getAdicional());
        Address address1 = addressService.saveHtml(addressAux);
        return form(addressService.findById(address1.getId()), "CEP encontrado", null);
    }

    @PostMapping("form")
    public ModelAndView savehtml(@Valid @ModelAttribute("model") Address address, BindingResult result){
        if (result.hasErrors()) {
           return form(address, null, "Erro ao salvar Endereço");
        }
        Address address1 = addressService.saveHtml(address);
        return profileControllerHtml.form(new Profile(), address1, "Endereco salvo com sucesso", null);
    }

    @GetMapping("excluir")
    public ModelAndView excluir(@RequestParam(value = "id") Long id) {
        addressService.delete(id);
        return form(new Address(), "Perfil excluido com sucesso", null);
    }
}