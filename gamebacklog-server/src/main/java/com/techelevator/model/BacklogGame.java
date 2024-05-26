package com.techelevator.model;

import jakarta.validation.constraints.NotBlank;

public class BacklogGame {
    private int backlogId;
    private int gameId;
    private int priority;
    private String progress;

    public BacklogGame() {
    }

    public BacklogGame(int backlogId, int gameId, int priority, String progress) {
        this.backlogId = backlogId;
        this.gameId = gameId;
        this.priority = priority;
        this.progress = progress;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

}
