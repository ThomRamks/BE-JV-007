package ADA.BEJV007.controller;

import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Pet;
import ADA.BEJV007.service.ONGService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ONGController {

    private final ONGService ongService;

    @GetMapping
    public List<Pet> list() {
        return ongService.list();
    }
}
