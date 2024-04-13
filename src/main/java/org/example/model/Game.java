package org.example.model;

public class Game {
    private int gameId;
    private String title;
    private String releaseDate;
    private String developers;
    private String summary;
    private String platforms;
    private String genres;
    private double rating;
    private String plays;
    private String playing;
    private String backlogs;
    private String wishlist;
    private String lists;
    private String reviews;

    public Game() {

    }

    public Game(int gameId, String title, String releaseDate, String developers, String summary, String platforms, String genres, double rating, String plays, String playing, String backlogs, String wishlist, String lists, String reviews) {
        this.gameId = gameId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.developers = developers;
        this.summary = summary;
        this.platforms = platforms;
        this.genres = genres;
        this.rating = rating;
        this.plays = plays;
        this.playing = playing;
        this.backlogs = backlogs;
        this.wishlist = wishlist;
        this.lists = lists;
        this.reviews = reviews;
    }

    public int getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDevelopers() {
        return developers;
    }

    public String getSummary() {
        return summary;
    }

    public String getPlatforms() {
        return platforms;
    }

    public String getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public String getPlays() {
        return plays;
    }

    public String getPlaying() {
        return playing;
    }

    public String getBacklogs() {
        return backlogs;
    }

    public String getWishlist() {
        return wishlist;
    }

    public String getLists() {
        return lists;
    }

    public String getReviews() {
        return reviews;
    }
}
