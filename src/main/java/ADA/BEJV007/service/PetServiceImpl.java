package ADA.BEJV007.service;

import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.exceptions.PetNotFoundException;
import ADA.BEJV007.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository repository;

    @Override
    public List<Pet> list() {
        return (List<Pet>) repository.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow(PetNotFoundException::new);
    }

    @Override
    public Pet update(Long id, Pet pet) {
        if(repository.existsById(id)){
            pet.setId(id);
            return repository.save(pet);
        }
        throw new PetNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new PetNotFoundException();
        }
        repository.deleteById(id);
    }
}
