package com.kursach.service;


import com.kursach.entity.Movie;
import com.kursach.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public HttpStatus Save(Movie movie) {
        movieRepository.save(movie);
        return HttpStatus.OK;
    }

    public HttpStatus Delete(Long bookId) {
        if (movieRepository.findById(bookId).isPresent()) {
            movieRepository.deleteById(bookId);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
