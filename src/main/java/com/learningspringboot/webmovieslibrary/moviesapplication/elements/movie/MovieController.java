package com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie;

import com.learningspringboot.webmovieslibrary.moviesapplication.elements.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("show-browse-movies")
    public String browseMoviesAndShows(String title, ModelMap model){
        List<Movie> list = movieService.findByTitle(title);
        model.addAttribute("movies",list);
        return "showBrowseMovies";
    }

    @RequestMapping("show-all-movies")
    public String showAllMovies(ModelMap model){
        List<Movie> list = movieService.listAllMovies();
        model.addAttribute("movies",list);
        return "showAllMovies";
    }

    @RequestMapping("delete-movie")
    public String deleteMovie(@RequestParam int imdbId){
        movieService.deleteByImdbId(imdbId);
        return "redirect:show-all-movies";
    }

    @GetMapping("add-movie")
    public String showNewMoviePage(ModelMap model) {
        //String username = getLoggedInUsername(model);
        Movie movie = new Movie("","",
                0, LocalDate.now().plusYears(1),"",
                "",0,0,0,0,"");
        model.put("movie", movie);
        return "movie";

    }

    @PostMapping("add-movie")
    public String addNewMovie(ModelMap model, Movie movie) {

        //String username = getLoggedInUsername(model);
        movieService.addMovie(movie.getTitle(),movie.getDescription(),movie.getRating(),
                movie.getReleaseDate(),movie.getDirector(),movie.getWriter(),movie.getStars(),
                movie.getDuration(),movie.getImdbId(),movie.getYear(),movie.getGenre());
        return "redirect:show-all-movies";

    }
}
