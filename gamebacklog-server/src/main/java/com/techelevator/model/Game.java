package com.techelevator.model;

public class Game extends RawgEntity {
    private String released;
    private Double rating;
    private int metacritic;
    private int playtime;

    public Game() {
    }

    public Game(int id, String slug, String name, String released, Double rating, int metacritic, int playtime) {
        super(id, slug, name);
        this.released = released;
        this.rating = rating;
        this.metacritic = metacritic;
        this.playtime = playtime;
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
