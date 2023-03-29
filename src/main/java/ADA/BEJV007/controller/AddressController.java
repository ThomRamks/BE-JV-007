package ADA.BEJV007.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.dto.AddressSaveDTO;
import ADA.BEJV007.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("enderecos")
@RestController
public class AddressController {
    private final AddressService addressService;

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
    public Address save(@Valid @RequestBody AddressSaveDTO dto){
        Address address = Address.builder()
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .bairro(dto.getBairro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .build();
        return addressService.save(address);
    }

    @PutMapping("{id}")
    public Address update(@PathVariable Long id, @RequestBody AddressSaveDTO dto){
        Address address = Address.builder()
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .bairro(dto.getBairro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .build();
        return addressService.update(id, address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        addressService.delete(id);
    }

}
