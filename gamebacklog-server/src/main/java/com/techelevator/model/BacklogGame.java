package com.techelevator.model;

public class BacklogGame {
    private int backlogId;
    private int gameId;

    public BacklogGame() {
    }

    public BacklogGame(int backlogId, int gameId) {
        this.backlogId = backlogId;
        this.gameId = gameId;
    }

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
