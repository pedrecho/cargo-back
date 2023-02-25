package com.kursach.controller;


import com.kursach.entity.Movie;
import com.kursach.repository.MovieRepository;
import com.kursach.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private final MovieRepository movie;

    MovieController(MovieRepository movie) {
        this.movie = movie;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Movie> GetById(@PathVariable(name = "id") Long id) {
        return this.movie.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return movieService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Movie> GetAll() {
        return this.movie.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Movie movie) {
        return movieService.Save(movie);
    }
}