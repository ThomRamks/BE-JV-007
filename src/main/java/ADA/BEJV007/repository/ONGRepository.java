package org.example.repository;

import org.example.domain.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ONGRepository extends CrudRepository <Pet, Long> {
    @Query("SELECT * from PETS p INNER JOIN ONG o WHERE o.ID_PET = p.ID")
    List<Pet> findAllPets();
}
