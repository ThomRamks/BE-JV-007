package ADA.BEJV007.service;

import ADA.BEJV007.exceptions.NotFoundException;
import ADA.BEJV007.mapper.PetMapper;
import ADA.BEJV007.repository.AdocaoRepository;
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
    private final AdocaoRepository adocaoRepository;

    @Override
    public List<Pet> list() {
        return (List<Pet>) repository.findAll();
    }

    @Override
    public Pet save(Pet pet) {
//        if(pet.getDono() != null){
//            pet.setStatus(StatusPet.ADOTADO);
//        }
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
//            if(pet.getDono() != null){
//                pet.setStatus(StatusPet.ADOTADO);
//            }
            return repository.save(pet);
        }
        throw new NotFoundException("Pet");
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("Pet");
        }
        if(adocaoRepository.existsByPet_Id(id)){
            adocaoRepository.findByPet_Id(id).setPet(null);
            if(adocaoRepository.findByPet_Id(id).getPet() == null && adocaoRepository.findByPet_Id(id).getDono() == null){
                adocaoRepository.deleteById(adocaoRepository.findByPet_Id(id).getId());
            }
        }
        repository.deleteById(id);
    }

}
