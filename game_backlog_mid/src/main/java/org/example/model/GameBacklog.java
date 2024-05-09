package org.example.model;

public class GameBacklog {
    private int gameId;
    private int backlogId;

    public GameBacklog() {
    }

    public GameBacklog(int gameId, int backlogId) {
        this.gameId = gameId;
        this.backlogId = backlogId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
    }
}
