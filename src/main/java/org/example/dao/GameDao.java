package org.example.dao;

import org.example.model.Game;

import java.util.List;

public interface GameDao {

    Game getGameById(int gameId);

    List<Game> getGames();



}
