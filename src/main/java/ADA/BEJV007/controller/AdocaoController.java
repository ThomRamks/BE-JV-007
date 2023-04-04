package ADA.BEJV007.controller;


import ADA.BEJV007.domain.Adocao;
import ADA.BEJV007.dto.AdocaoSaveDTO;
import ADA.BEJV007.mapper.AdocaoMapper;
import ADA.BEJV007.service.GeneralService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("adocoes")
@RestController
public class AdocaoController {
    @Autowired
    private GeneralService<Adocao> adocaoService;
    @Autowired
    private AdocaoMapper mapper;

    @GetMapping("{id}")
    public Adocao getById(@PathVariable Long id) {
        return adocaoService.findById(id);
    }

    @GetMapping()
    public List<Adocao> listar() {
        return adocaoService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Adocao save(@Valid @RequestBody AdocaoSaveDTO dto) {
        Adocao adocao = mapper.adocao(dto);
        return adocaoService.save(adocao);
    }

    @PutMapping("{id}")
    public Adocao update(@PathVariable Long id, @RequestBody AdocaoSaveDTO dto) {
        Adocao adocao = mapper.adocao(dto);
        return adocaoService.update(id, adocao);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        adocaoService.delete(id);
    }
}
