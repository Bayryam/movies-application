package com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie;

import com.learningspringboot.webmovieslibrary.moviesapplication.elements.Season;
import com.learningspringboot.webmovieslibrary.moviesapplication.elements.TVShow;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class MovieService
{
    private final static List<Movie> movies = new ArrayList<Movie>();

    static{
        movies.add(new Movie("Titanic","Tragic accident in the ocean",
                5,LocalDate.now().plusYears(5),"James Parker",
                "Antony Klassen",8,2,456,2012,"Tragedy"));
        movies.add(new Movie("Avatar","Extraterrestrial organisms",
                3,LocalDate.now().plusYears(4),"James Pride",
                "Antony Rogering",3,1,342,2019,"Fantasy"));
        movies.add(new Movie("Harry Potter","Magical world of wizards",
                7,LocalDate.now().plusYears(3),"ross Jakap",
                "Ron Mitchel",4,3,232,2020,"Fiction"));
    }

    public List<Movie> listAllMovies(){
        return movies;
    }
    public List<Movie> findByTitle(String title){
        Predicate<? super Movie> predicate = movie -> movie.getTitle().contains(title);
        return movies.stream().filter(predicate).toList();
    }

    public void addMovie(String title, String description, int rating,
                         LocalDate releaseDate, String director, String writer,
                         int stars, long duration, int imdbId, int year, String genre){
        Movie movie = new Movie(title,description,rating,releaseDate,director,writer,stars,duration,imdbId,year,genre);
        movies.add(movie);
    }

    public void addTvShow(String title, String description, int rating,
                          LocalDate releaseDate, String director, String writer,
                          int stars, long duration, int imdbId, int year, String genre,
                          ArrayList<Season> seasons){
        TVShow tvShow = new TVShow(title,description,rating,releaseDate,director,writer,stars,duration,imdbId,year,genre,seasons);
        movies.add(tvShow);
    }

    public void deleteByImdbId(int imdbId){
        Predicate<? super Movie> predicate = movie ->movie.getImdbId() == imdbId;
        movies.removeIf(predicate);
    }

}
