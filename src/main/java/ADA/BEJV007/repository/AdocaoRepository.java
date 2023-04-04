package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Adocao;

import ADA.BEJV007.domain.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends CrudRepository<Adocao, Long > {
    Adocao findByIdPet(Long id);
}


