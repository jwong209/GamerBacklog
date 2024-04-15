package org.example.dao;

import org.example.exception.DaoException;
import org.example.model.Game;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface GameDao {

    Game getGameById(int gameId) throws DaoException;

    List<Game> getGames() throws DaoException;

    List<Game> searchGamesByPlatformGenreRatingTitle(String platform, String genre, String rating, String title);

    List<Game> searchGamesByGenre(String genres);

    List<Game> searchGamesByTitle(String title);

    List<Game> searchGamesByRating(String rating);

    List<Game> searchGamesByPlatform(String platform);

    List<Game> searchGamesByTitleRating(String title, String rating);

    Game createGame(Game game) throws DaoException;

    Game updateGame(Game game) throws DaoException;

    int deleteGameById(int gameId) throws DaoException;

    void linkGameBacklog(int gameId, int backlogId) throws DaoException;

    void unlinkGameBacklog(int gameId, int backlogId) throws DaoException;

    }



