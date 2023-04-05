package ADA.BEJV007.controller;

import ADA.BEJV007.mapper.AddressMapper;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.dto.AddressSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Address save(@Valid @RequestBody AddressSaveDTO dto){
        Address address = mapper.address(dto);
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
