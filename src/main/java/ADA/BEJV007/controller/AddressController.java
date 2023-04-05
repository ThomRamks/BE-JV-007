package ADA.BEJV007.controller;

import ADA.BEJV007.mapper.AddressMapper;
import ADA.BEJV007.service.GeneralService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.dto.AddressSaveDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("enderecos")
@RestController
public class AddressController {
    @Autowired
    private GeneralService<Address> addressService;
    @Autowired
    private AddressMapper mapper;

    @GetMapping
    public List<Address> enderecos(){
        return addressService.list();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@Valid @RequestBody AddressSaveDTO dto) throws Exception {
        URL url = new URL("https://viacep.com.br/ws/" +dto.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        while((cep = br.readLine()) != null){
            jsonCep.append(cep);
        }
        AddressSaveDTO adressAux = new Gson().fromJson(jsonCep.toString(), AddressSaveDTO.class);
        adressAux.setNumero(dto.getNumero());
        adressAux.setAdicional(dto.getAdicional());

        Address address = mapper.address(adressAux);
        return addressService.save(address);
    }

    @PutMapping("{id}")
    public Address update(@PathVariable Long id, @Valid @RequestBody AddressSaveDTO dto){
        Address address = mapper.address(dto);
        return addressService.update(id, address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        addressService.delete(id);
    }

}
