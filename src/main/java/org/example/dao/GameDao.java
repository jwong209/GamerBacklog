package org.example.dao;

import org.example.exception.DaoException;
import org.example.model.Game;

import java.util.List;

public interface GameDao {

    Game getGameById(int gameId) throws DaoException;

    List<Game> getGames() throws DaoException;

    Game createGame(Game game) throws DaoException;

    Game updateGame(Game game) throws DaoException;
    int deleteGameById(int gameId) throws DaoException;

    void linkGameBacklog(int gameId, int backlogId) throws DaoException;

    void unlinkGameBacklog(int gameId, int backlogId) throws DaoException;
}
