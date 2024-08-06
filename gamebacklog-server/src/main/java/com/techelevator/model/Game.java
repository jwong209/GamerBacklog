package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class Game {
    private int id;
    @NotBlank( message = "The field 'name' is required.")
    private String name;
    private String released;
    @JsonProperty("background_image")
    private String backgroundImage;
    private Double rating;
    private int metacritic;
    private int playtime;
    private String website;
    @JsonProperty("description_raw")
    private String description;

    public Game() {
    }

    public Game(int id, String name, String released, String backgroundImage,Double rating, int metacritic, int playtime) {
        this.id = id;
        this.name = name;
        this.released = released;
        this.backgroundImage = backgroundImage;
        this.rating = rating;
        this.metacritic = metacritic;
        this.playtime = playtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
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
