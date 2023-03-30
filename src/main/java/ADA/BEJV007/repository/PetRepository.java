package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.dto.PetDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findAll(Sort by);
}
