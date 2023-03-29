package ADA.BEJV007.repository;

import ADA.BEJV007.domain.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ONGRepository extends CrudRepository <Pet, Long> {
    @Query("SELECT p.nome, p.tipo, p.descricao, p.nascimento, p.status from Pet p INNER JOIN ONG o WHERE o.pets = p")
    List<Pet> findAllPets();
}
