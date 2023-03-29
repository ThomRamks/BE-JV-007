package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Profile;
import org.example.exceptions.ProfileNotFoundException;
import org.example.exceptions.SameCpfException;
import org.example.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    @Override
    public List<Profile> list() {
        return (List<Profile>) repository.findAll();
    }

    @Override
    public Profile save(Profile profile) {
        if(list().stream().anyMatch(dono1 -> dono1.getCpf().equals(profile.getCpf()))){
            throw new SameCpfException();
        }
        return repository.save(profile);
    }

    @Override
    public Profile findById(Long id) {
        return repository.findById(id).orElseThrow(ProfileNotFoundException::new);
    }

    @Override
    public Profile update(Long id, Profile profile) {
        if(repository.existsById(id)){
            profile.setId(id);
            return repository.save(profile);
        }
        throw new ProfileNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ProfileNotFoundException();
        }
        repository.deleteById(id);
    }
}
