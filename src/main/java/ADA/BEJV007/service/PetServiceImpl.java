package ADA.BEJV007.service;

import ADA.BEJV007.exceptions.NotFoundException;
import ADA.BEJV007.mapper.PetMapper;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements GeneralService <Pet> {

    @Autowired
    private PetMapper mapper;

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
    public Pet saveHtml(Pet pet) {
        repository.save(pet);
        return pet;
    }

    @Override
    public Pet findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Pet"));
    }

    @Override
    public Pet update(Long id, Pet pet) {
        if(repository.existsById(id)){
            pet.setId(id);
            return repository.save(pet);
        }
        throw new NotFoundException("Pet");
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("Pet");
        }
        repository.deleteById(id);
    }
}
