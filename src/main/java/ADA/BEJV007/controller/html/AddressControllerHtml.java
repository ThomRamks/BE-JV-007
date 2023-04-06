package ADA.BEJV007.controller.html;

import ADA.BEJV007.controller.ProfileController;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.dto.AddressSaveDTO;
import ADA.BEJV007.mapper.ProfileMapper;
import ADA.BEJV007.service.GeneralService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RequiredArgsConstructor
@RequestMapping("enderecos_html")
@RestController
public class AddressControllerHtml {

    @Autowired
    private GeneralService<Address>addressService;
    @Autowired
    private ProfileControllerHtml profileControllerHtml;

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
    public ModelAndView cephtml(@Valid @ModelAttribute("model") Address address, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return form(address, null, "Erro ao encontrar Endereço");
        }
        URL url = new URL("https://viacep.com.br/ws/" +address.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        while((cep = br.readLine()) != null){
            jsonCep.append(cep);
        }
        Address addressAux = new Gson().fromJson(jsonCep.toString(), Address.class);
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