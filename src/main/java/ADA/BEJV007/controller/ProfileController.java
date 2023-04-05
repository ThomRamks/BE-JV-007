package ADA.BEJV007.controller;

import ADA.BEJV007.domain.Address;
import ADA.BEJV007.dto.AddressSaveDTO;
import ADA.BEJV007.mapper.AddressMapper;
import ADA.BEJV007.mapper.ProfileMapper;
import ADA.BEJV007.service.GeneralService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.dto.ProfileSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("usuarios")
@RestController
public class ProfileController {

    @Autowired
    private GeneralService<Profile> profileService;
    @Autowired
    private ProfileMapper mapper;
    @Autowired
    private AddressMapper mapperAdress;
    @Autowired
    private GeneralService<Address> adocaoService;

    @GetMapping
    public List<Profile> list(){
        return profileService.list();
    }

    @GetMapping("{id}")
    public Profile getById(@PathVariable Long id){
        return profileService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile save(@Valid @RequestBody ProfileSaveDTO dto) throws IOException {
        if(dto.getEndereco() != null){
            URL url = new URL("https://viacep.com.br/ws/" +dto.getEndereco().getCep()+"/json/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String cep = "";
            StringBuilder jsonCep = new StringBuilder();
            while((cep = br.readLine()) != null){
                jsonCep.append(cep);
            }
            AddressSaveDTO adressAux = new Gson().fromJson(jsonCep.toString(), AddressSaveDTO.class);
            adressAux.setNumero(dto.getEndereco().getNumero());
            adressAux.setAdicional(dto.getEndereco().getAdicional());

            Address address = mapperAdress.address(adressAux);
            adocaoService.save(address);
        }
        Profile profile = mapper.profile(dto);
        return profileService.save(profile);
    }

    @PutMapping("{id}")
    public Profile update(@PathVariable Long id, @Valid @RequestBody ProfileSaveDTO dto){
        Profile profile = mapper.profile(dto);
        return profileService.update(id, profile);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        profileService.delete(id);
    }

}
