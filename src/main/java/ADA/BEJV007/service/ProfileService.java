package org.example.service;

import org.example.domain.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> list();
    Profile save (Profile profile);
    Profile findById (Long id);
    Profile update(Long id, Profile profile);
    void delete (Long id);

}
