package org.example.dao;

import org.example.model.Game;

import java.util.List;

public interface UserGameDao {

    void linkUserGame(int userId, int gameId);
    void unlinkUserGame(int userId, int gameId);

    List<Game> getAllGamesByUserId(int userId);

}
