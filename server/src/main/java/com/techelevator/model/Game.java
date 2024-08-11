package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

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
    private List<PlatformWrapper> platforms;
    private List<Developer> developers;
    private List<Genre> genres;
    private List<Publisher> publishers;
    @JsonProperty("esrb_rating")
    private Esrb esrbRating;
    private String website;
    @JsonProperty("description_raw")
    private String description;

    public Game() {
    }

    public Game(int id, String name, String released, String backgroundImage, Double rating, int metacritic, int playtime, List<PlatformWrapper> platforms, List<Developer> developers, List<Genre> genres, List<Publisher> publishers, Esrb esrbRating, String website, String description) {
        this.id = id;
        this.name = name;
        this.released = released;
        this.backgroundImage = backgroundImage;
        this.rating = rating;
        this.metacritic = metacritic;
        this.playtime = playtime;
        this.platforms = platforms;
        this.developers = developers;
        this.genres = genres;
        this.publishers = publishers;
        this.esrbRating = esrbRating;
        this.website = website;
        this.description = description;
    }

    public List<PlatformWrapper> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<PlatformWrapper> platforms) {
        this.platforms = platforms;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Esrb getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(Esrb esrbRating) {
        this.esrbRating = esrbRating;
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
