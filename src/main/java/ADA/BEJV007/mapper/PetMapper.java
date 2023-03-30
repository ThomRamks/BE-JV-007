package ADA.BEJV007.mapper;

import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetDTO;
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

//    public SaidaFilmeDto saidaFilmeDto(Filme filme) {
//        return mapper.map(filme, SaidaFilmeDto.class);
//    }
//
//    public void filme(EntradaFilmeDto entradaDto, Filme filme) {
//        mapper.map(entradaDto, filme);
//    }
//
//    public Page<SaidaFilmeDto> listSaidaFilmeDto(Page<Filme> list) {
//        Page<SaidaFilmeDto> map = list.map(f -> saidaFilmeDto(f));
//
//        return map;
//    }
}
