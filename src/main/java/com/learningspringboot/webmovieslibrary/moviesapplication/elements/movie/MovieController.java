package com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie;

import com.learningspringboot.webmovieslibrary.moviesapplication.elements.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/show-browse-movies/{title}")
    public List<Movie> browseMoviesAndShows(@PathVariable String title){
        return movieService.findByTitle(title);
    }

    @GetMapping (path = "/show-all-movies")
    public List<Movie> showAllMovies(){
        return movieService.listAllMovies();
    }

    @DeleteMapping (path = "movies/{imdbId}")
    public void deleteMovie(@PathVariable int imdbId){
        movieService.deleteByImdbId(imdbId);
    }

    @PostMapping(path = "/movies")
    public void addNewMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie.getTitle(),movie.getDescription(),movie.getRating(),
                movie.getReleaseDate(),movie.getDirector(),movie.getWriter(),movie.getStars(),
                movie.getDuration(), movie.getImdbId(),movie.getYear(),movie.getGenre());

    }
}
