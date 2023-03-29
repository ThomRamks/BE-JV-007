package ADA.BEJV007.service;

import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.repository.ONGRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ONGServiceImpl implements ONGService {
    private final ONGRepository repository;

    @Override
    public List<Pet> list() {
        return (List<Pet>) repository.findAllPets();
    }
}
