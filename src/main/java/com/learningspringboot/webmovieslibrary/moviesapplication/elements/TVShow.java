package com.learningspringboot.webmovieslibrary.moviesapplication.elements;

import com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie.Movie;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.ArrayList;

//@Entity
public class TVShow extends Movie
{
    private ArrayList<Season> seasons;

    public TVShow(String title, String description, int rating,
                  LocalDate releaseDate, String director, String writer,
                  int stars, long duration, int imdbId, int year, String genre,
                  ArrayList<Season> seasons) {
        super(title, description, rating, releaseDate, director, writer, stars, duration, imdbId, year, genre);
        this.seasons = seasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "seasons=" + seasons +
                '}';
    }
}
