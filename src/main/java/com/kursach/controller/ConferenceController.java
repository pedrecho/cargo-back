package com.kursach.controller;


import com.kursach.entity.Conference;
import com.kursach.repository.ConferenceRepository;
import com.kursach.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    private final ConferenceRepository conference;

    ConferenceController(ConferenceRepository conference) {
        this.conference = conference;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Conference> GetById(@PathVariable(name = "id") Long id) {
        return this.conference.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return conferenceService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Conference> GetAll() {
        return this.conference.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Conference conference) {
        return conferenceService.Save(conference);
    }
}