package com.kursach.controller;


import com.kursach.entity.BarberClient;
import com.kursach.repository.BarberClientRepository;
import com.kursach.service.BarberClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barbershop")
public class BarberClientController {

    @Autowired
    private BarberClientService barberCLientService;

    private final BarberClientRepository barberClient;

    BarberClientController(BarberClientRepository barberClient) {
        this.barberClient = barberClient;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<BarberClient> GetById(@PathVariable(name = "id") Long id) {
        return this.barberClient.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return barberCLientService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<BarberClient> GetAll() {
        return this.barberClient.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(BarberClient barberClient) {
        return barberCLientService.Save(barberClient);
    }
}