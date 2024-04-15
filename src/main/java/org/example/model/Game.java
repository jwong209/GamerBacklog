package org.example.model;

import java.util.List;

public class Game {
    private int gameId;
    private String title;
    private String releaseDate;
    private String developers;
    private String summary;
    private String platforms;
    private String genres;
    private String rating;
    private String plays;
    private String playing;
    private String backlogs;
    private String wishlist;
    private String lists;
    private String reviews;

    public Game() {
    }

    public Game(int gameId, String title, String releaseDate, String developers, String summary, String platforms, String genres, String rating, String plays, String playing, String backlogs, String wishlist, String lists, String reviews) {
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

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlays() {
        return plays;
    }

    public void setPlays(String plays) {
        this.plays = plays;
    }

    public String getPlaying() {
        return playing;
    }

    public void setPlaying(String playing) {
        this.playing = playing;
    }

    public String getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(String backlogs) {
        this.backlogs = backlogs;
    }

    public String getWishlist() {
        return wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public String getLists() {
        return lists;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s,%s, %s)", getTitle(), getReleaseDate(), getDevelopers(), getPlatforms(), getGenres(), getRating());

    }
}
