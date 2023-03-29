package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Pet;
import org.example.repository.ONGRepository;
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
