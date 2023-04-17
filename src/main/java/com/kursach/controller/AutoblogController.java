package com.kursach.controller;

import com.kursach.entity.Autoblog;
import com.kursach.repository.AutoblogRepository;
import com.kursach.service.AutoblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autoblog")
public class AutoblogController {
    @Autowired
    private AutoblogService autoblogService;

    private final AutoblogRepository autoblog;

    AutoblogController(AutoblogRepository autoblogRepository){
        this.autoblog = autoblogRepository;
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAuthority('MANAGER')")
    public HttpStatus Create(Autoblog autoblog){
        return autoblogService.Create(autoblog);
    }

    @PostMapping(path = "/update")
    @PreAuthorize("hasAuthority('MANAGER')")
    public HttpStatus Update(Autoblog autoblog){
        return autoblogService.Update(autoblog);
    }

    @PostMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('MANAGER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id){
        return autoblogService.Delete(id);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Autoblog> GetById(@PathVariable(name="id") Long id){
        return this.autoblog.findById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Autoblog> GetAll(){
        return this.autoblog.findAll();
    }
}
