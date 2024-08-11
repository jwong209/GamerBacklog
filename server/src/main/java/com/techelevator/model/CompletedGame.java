package com.techelevator.model;

import java.time.Duration;
import java.time.LocalDate;

public class CompletedGame {

    private int userId;
    private int gameId;
    private LocalDate completionDate;
    private Duration totalPlaytime;

    public CompletedGame() {
    }

    public CompletedGame(int userId, int gameId, LocalDate completionDate, Duration totalPlaytime) {
        this.userId = userId;
        this.gameId = gameId;
        this.completionDate = completionDate;
        this.totalPlaytime = totalPlaytime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public Duration getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(Duration totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }
}
