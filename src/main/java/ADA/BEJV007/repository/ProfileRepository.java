package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    boolean existsByCpf(String cpf);
    List<Profile> findAll(Sort by);
    Profile findByEndereco_Id(Long id);
    boolean existsByEndereco_Id(Long id);
}
