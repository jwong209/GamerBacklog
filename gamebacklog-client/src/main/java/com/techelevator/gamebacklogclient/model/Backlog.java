package com.techelevator.gamebacklogclient.model;

public class Backlog {

    private int backlogId;
    private int gameId;

    public Backlog() {
    }

    public Backlog(int backlogId, int gameId) {
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
