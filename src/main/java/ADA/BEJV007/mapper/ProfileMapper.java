package ADA.BEJV007.mapper;

import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.dto.ProfileSaveDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    @Autowired
    private ModelMapper mapper;

    public Profile profile (ProfileSaveDTO entradaDTO){
        return mapper.map(entradaDTO, Profile.class);
    }

    public void profile (ProfileSaveDTO entradaDTO, Profile profile){
        mapper.map(entradaDTO, profile);
    }

}
