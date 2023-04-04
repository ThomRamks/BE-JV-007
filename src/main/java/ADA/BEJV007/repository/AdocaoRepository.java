package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Adocao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends CrudRepository<Adocao, Long> {
    boolean existsByDono_Id(Long id);
    boolean existsByPet_Id(Long id);
    Adocao findByDono_Id(Long id);
    Adocao findByPet_Id(Long id);

}


