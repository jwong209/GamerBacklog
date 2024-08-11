package com.techelevator.model;

public class CollectionGame {
    private int collectionId;
    private int gameId;
    private String status;
    private String format;
    private String platform;
    private int rating;
    private String notes;

    public CollectionGame() {
    }

    public CollectionGame(int collectionId, int gameId, String status, String format, String platform, int rating, String notes) {
        this.collectionId = collectionId;
        this.gameId = gameId;
        this.status = status;
        this.format = format;
        this.platform = platform;
        this.rating = rating;
        this.notes = notes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
