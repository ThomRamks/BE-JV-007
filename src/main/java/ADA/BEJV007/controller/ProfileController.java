package ADA.BEJV007.controller;

import ADA.BEJV007.mapper.ProfileMapper;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.dto.ProfileSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("usuarios")
@RestController
public class ProfileController {

    @Autowired
    private GeneralService<Profile> profileService;
    @Autowired
    private ProfileMapper mapper;

    @GetMapping
    public List<Profile> list(){
        return profileService.list();
    }

    @GetMapping("{id}")
    public Profile getById(@PathVariable Long id){
        return profileService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile save(@Valid @RequestBody ProfileSaveDTO dto){
        Profile profile = mapper.profile(dto);
        return profileService.save(profile);
    }

    @PutMapping("{id}")
    public Profile update(@PathVariable Long id, @Valid @RequestBody ProfileSaveDTO dto){
        Profile profile = mapper.profile(dto);
        return profileService.update(id, profile);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        profileService.delete(id);
    }

}
