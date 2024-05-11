package com.techelevator.model;

import java.util.List;

public class Game {
    private int id;
    private String name;
    private String release;
    private Double rating;
    private int playtime;

    public Game() {
    }

    public Game(int id, String name, String release, Double rating, int playtime) {
        this.id = id;
        this.name = name;
        this.release = release;
        this.rating = rating;
        this.playtime = playtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

}
