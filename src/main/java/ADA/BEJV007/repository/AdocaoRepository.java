package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Adocao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends CrudRepository<Adocao, Long> {
    boolean existsByIdDono_Id(Long id);
    boolean existsByIdPet_Id(Long id);
    Adocao findByIdDono_Id(Long id);
    Adocao findByIdPet_Id(Long id);

}


