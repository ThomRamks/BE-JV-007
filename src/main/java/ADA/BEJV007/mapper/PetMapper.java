package ADA.BEJV007.mapper;

import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetSaveDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    @Autowired
    private ModelMapper mapper;

    public Pet pet(PetSaveDTO entradaDto) {
        return mapper.map(entradaDto, Pet.class);
    }
    public void pet(PetSaveDTO entradaDto, Pet pet){
        mapper.map(entradaDto, pet);
    }
}
