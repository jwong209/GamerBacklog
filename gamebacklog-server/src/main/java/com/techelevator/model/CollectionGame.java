package com.techelevator.model;

public class CollectionGame {
    private int collectionId;
    private int gameId;

    public CollectionGame() {
    }

    public CollectionGame(int collectionId, int gameId) {
        this.collectionId = collectionId;
        this.gameId = gameId;
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
}
