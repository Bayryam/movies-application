package com.learningspringboot.webmovieslibrary.moviesapplication.elements;

import java.util.ArrayList;

public class Season
{
    private int number;
    private ArrayList<Episode> episodes;

    public Season(int number, ArrayList<Episode> episodes) {
        this.number = number;
        this.episodes = episodes;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "Season{" +
                "number=" + number +
                ", episodes=" + episodes +
                '}';
    }
}
