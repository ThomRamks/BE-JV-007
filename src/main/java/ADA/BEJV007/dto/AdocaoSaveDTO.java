package ADA.BEJV007.dto;

import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdocaoSaveDTO {
    private Profile dono;
    private Pet pet;
}
