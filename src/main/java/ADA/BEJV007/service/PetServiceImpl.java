package ADA.BEJV007.service;

import ADA.BEJV007.dto.PetDTO;
import ADA.BEJV007.dto.PetSaveDTO;
import ADA.BEJV007.mapper.PetMapper;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.exceptions.PetNotFoundException;
import ADA.BEJV007.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {


    @Autowired
    private PetMapper mapper;

    private final PetRepository repository;

    @Override
    public List<Pet> list() {
        return (List<Pet>) repository.findAll();
    }

    @Override
    public Pet save(PetSaveDTO dto) {
        Pet pet = mapper.pet(dto);
        if(repository.existsById(pet.getId())){
            PetService petServiceImpl = new PetServiceImpl(repository);
            return petServiceImpl.update(pet.getId(), pet);
        }
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
