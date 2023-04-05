package ADA.BEJV007.service;

import ADA.BEJV007.domain.Adocao;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.exceptions.NotFoundException;
import ADA.BEJV007.repository.AdocaoRepository;
import ADA.BEJV007.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdocaoServiceImpl implements GeneralService<Adocao> {
    @Autowired
    private AdocaoRepository repository;
    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Adocao> list() {
        return (List<Adocao>) repository.findAll();
    }

    @Override
    public Adocao save(Adocao adocao) {
        adocao.getPet().setStatus(StatusPet.ADOTADO);
        return repository.save(adocao);
    }

    @Override
    public Adocao saveHtml(Adocao adocao) {
        adocao.getPet().setStatus(StatusPet.ADOTADO);
        return repository.save(adocao);
    }

    @Override
    public Adocao findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Adoção"));
    }

    @Override
    public Adocao update(Long id, Adocao adocao) {
        if (repository.existsById(id)) {
            adocao.setId(id);
            return repository.save(adocao);
        }
        throw new NotFoundException("Adoção");
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Adoção");
        }

        Adocao adocao = repository.findById(id).get();
        adocao.getPet().setStatus(StatusPet.DISPONIVEL);

        repository.deleteById(id);
    }
}
