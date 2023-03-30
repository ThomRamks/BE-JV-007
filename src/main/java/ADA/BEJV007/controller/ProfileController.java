package ADA.BEJV007.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Profile;
import ADA.BEJV007.dto.ProfileSaveDTO;
import ADA.BEJV007.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("usuarios")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

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
        ZoneId zoneId = ZoneId.systemDefault();
        Profile profile = Profile.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .endereco(dto.getEndereco())
                .registro(LocalDate.ofInstant(Instant.now(), zoneId))
                .build();
        return profileService.save(profile);
    }

    @PutMapping("{id}")
    public Profile update(@PathVariable Long id, @RequestBody ProfileSaveDTO dto){
        Profile profile = Profile.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .endereco(dto.getEndereco())
                .build();
        return profileService.update(id, profile);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        profileService.delete(id);
    }

}
