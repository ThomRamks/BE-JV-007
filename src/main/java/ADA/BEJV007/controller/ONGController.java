package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Pet;
import org.example.service.ONGService;
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
