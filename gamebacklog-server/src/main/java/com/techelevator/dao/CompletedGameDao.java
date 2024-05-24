package com.techelevator.dao;

import com.techelevator.model.CompletedGame;

import java.util.List;

public interface CompletedGameDao {


    void addGameToCompleted(CompletedGame completedGame);
    void deleteGameFromCompleted(int userId, int gameId);

    List<Integer> getGameIdsInCompleted(int userId);

}
