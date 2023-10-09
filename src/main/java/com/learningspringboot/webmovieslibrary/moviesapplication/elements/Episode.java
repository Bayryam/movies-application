package com.learningspringboot.webmovieslibrary.moviesapplication.elements;

import com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Episode extends Movie {
    @Id
    private int number;

    public Episode(String title, String description, int rating,
                   LocalDate releaseDate, String director, String writer,
                   int stars, long duration, int imdbId, int year, int number) {
        super(title, description, rating, releaseDate, director, writer, stars, duration, imdbId, year, null);
        this.number = number;
    }
}
