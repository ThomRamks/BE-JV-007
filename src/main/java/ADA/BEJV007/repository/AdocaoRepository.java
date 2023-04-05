package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Adocao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdocaoRepository extends CrudRepository<Adocao, Long> {
    boolean existsByDono_Id(Long id);
    boolean existsByPet_Id(Long id);
    Adocao findByDono_Id(Long id);
    Adocao findByPet_Id(Long id);
    List<Adocao> findAllByDono_Id(Long id);

}


