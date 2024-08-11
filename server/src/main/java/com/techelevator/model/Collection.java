package com.techelevator.model;

public class Collection {
    private int collectionId;
    private int userId;

    public Collection() {
    }

    public Collection(int collectionId, int gameId) {
        this.collectionId = collectionId;
        this.userId = gameId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
