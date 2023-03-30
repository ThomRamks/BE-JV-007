package ADA.BEJV007.service;

import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetDTO;
import ADA.BEJV007.dto.PetSaveDTO;

import java.util.List;

public interface PetService {
    List<Pet> list();
    Pet save(PetSaveDTO pet);
    Pet findById(Long id);
    Pet update (Long id, Pet pet);
    void delete (Long id);

}
