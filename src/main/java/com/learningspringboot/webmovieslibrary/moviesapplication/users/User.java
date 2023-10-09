package com.learningspringboot.webmovieslibrary.moviesapplication.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.webmovieslibrary.moviesapplication.elements.movie.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User
{
    @Id
    @GeneratedValue
private Integer id;
private String name;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<Movie> movies;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
