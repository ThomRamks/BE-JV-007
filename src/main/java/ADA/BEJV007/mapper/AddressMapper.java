package ADA.BEJV007.mapper;

import ADA.BEJV007.domain.Address;
import ADA.BEJV007.dto.AddressSaveDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    @Autowired
    private ModelMapper mapper;

    public Address address(AddressSaveDTO entradaDto){
        return mapper.map(entradaDto, Address.class);
    }

    public void address(AddressSaveDTO entradaDto, Address address){
        mapper.map(entradaDto, address);
    }

}
