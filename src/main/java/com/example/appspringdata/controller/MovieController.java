package com.example.appspringdata.controller;

import com.example.appspringdata.domain.Movie;
import com.example.appspringdata.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
     this.movieRepository   = movieRepository;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam(value = "title", required = false) String title) {
        if (title != null) {
            return ResponseEntity.ok(movieRepository.findByTitle(title));
        }
        return ResponseEntity.ok(movieRepository.findAll());
    }

    @GetMapping(value = "/movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovie(@PathVariable String id) {
        return ResponseEntity.ok(movieRepository.findById(id));
    }

    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
       return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
        movieRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/movies/{id}/updateVotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateVoted(@PathVariable String id) {
       return ResponseEntity.ok(movieRepository.updateMovieVotes(id));
    }
}
