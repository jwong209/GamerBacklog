package com.techelevator.gamebacklogclient.model;

public class Game {

    private int id;
    private String name;
    private String released;
    private Double rating;
    private int metacritic;
    private int playtime;

    public Game() {
    }

    public Game(int id, String name, String released, Double rating, int metacritic, int playtime) {
        this.id = id;
        this.name = name;
        this.released = released;
        this.rating = rating;
        this.metacritic = metacritic;
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

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

}
