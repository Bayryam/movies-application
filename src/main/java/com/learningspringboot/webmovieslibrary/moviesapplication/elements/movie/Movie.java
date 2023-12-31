package com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.webmovieslibrary.moviesapplication.users.User;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
@Entity
public class Movie
{
    private String title;
    private String description;
    private int rating;
    private LocalDate releaseDate;
    private String director;
    private String writer;
    private int stars;
    private long duration;
    @Id
    @GeneratedValue
    private int imdbId;
    private int year;
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Movie(String title, String description, int rating,
                 LocalDate releaseDate, String director, String writer,
                 int stars, long duration, int imdbId, int year, String genre) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.director = director;
        this.writer = writer;
        this.stars = stars;
        this.duration = duration;
        this.imdbId = imdbId;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public int getStars() {
        return stars;
    }

    public long getDuration() {
        return duration;
    }

    public int getImdbId() {
        return imdbId;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", stars=" + stars +
                ", duration=" + duration +
                ", imdbId=" + imdbId +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
