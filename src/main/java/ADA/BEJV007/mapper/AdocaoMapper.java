package ADA.BEJV007.mapper;

import ADA.BEJV007.domain.Adocao;
import ADA.BEJV007.dto.AdocaoSaveDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoMapper {

    @Autowired
    private ModelMapper mapper;

    public Adocao adocao (AdocaoSaveDTO entradaDto){
        return mapper.map(entradaDto, Adocao.class);
    }
    public void adocao (AdocaoSaveDTO entradaDto, Adocao adocao){
        mapper.map(entradaDto, adocao);
    }
}
