package ADA.BEJV007.service;

import ADA.BEJV007.domain.Pet;

import java.util.List;

public interface PetService {
    List<Pet> list();
    Pet save(Pet pet);
    Pet findById(Long id);
    Pet update (Long id, Pet pet);
    void delete (Long id);

    List<Pet> listar();
}
