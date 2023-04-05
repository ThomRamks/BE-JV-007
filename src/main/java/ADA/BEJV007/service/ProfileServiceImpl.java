package ADA.BEJV007.service;

import ADA.BEJV007.domain.Adocao;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.domain.enums.StatusPet;
import ADA.BEJV007.exceptions.NotFoundException;
import ADA.BEJV007.repository.AdocaoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.exceptions.SameCpfException;
import ADA.BEJV007.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class ProfileServiceImpl implements GeneralService <Profile> {

    @Autowired
    private ProfileRepository repository;
    @Autowired
    private AdocaoRepository adocaoRepository;
    @Autowired
    private AdocaoServiceImpl adocaoService;

    public List<Profile> listar() {
        return (List<Profile>) repository.findAll(Sort.by(Sort.Direction.ASC, "nome", "sobrenome"));
    }

    @Override
    public List<Profile> list() {
        return (List<Profile>) repository.findAll();
    }

    @Override
    public Profile save(Profile profile) {
        if(repository.existsByCpf(profile.getCpf())){
            throw new SameCpfException();
        }
        return repository.save(profile);
    }

    @Override
    public Profile saveHtml(Profile profile) {
        if(list().stream().anyMatch(usuario -> usuario.getCpf().equals(profile.getCpf()) && !usuario.getId().equals(profile.getId()))){
            throw new SameCpfException();
        }
        return repository.save(profile);
    }

    @Override
    public Profile findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário"));
    }

    @Override
    public Profile update(Long id, Profile profile) {
        if(repository.existsById(id)){
            profile.setId(id);
            return repository.save(profile);
        }
        throw new NotFoundException("Usuário");

    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("Perfil");
        }
        List<Adocao> adocaoProfile = adocaoRepository.findAllByDono_Id(id);
        if(adocaoProfile != null){
            adocaoProfile.forEach(adocao -> adocaoService.delete(adocao.getId()));
        }

        repository.deleteById(id);
    }
}
