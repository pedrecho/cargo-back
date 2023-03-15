package com.kursach.controller;


import com.kursach.entity.Performance;
import com.kursach.repository.PerformanceRepository;
import com.kursach.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    private final PerformanceRepository performance;

    PerformanceController(PerformanceRepository performance) {
        this.performance = performance;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Performance> GetById(@PathVariable(name = "id") Long id) {
        return this.performance.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return performanceService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Performance> GetAll() {
        return this.performance.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Performance performance) {
        return performanceService.Save(performance);
    }
}