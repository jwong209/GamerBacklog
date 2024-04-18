package org.example.controller;

import org.example.dao.GameDao;
import org.example.model.Game;
import java.util.List;

public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public List<Game> searchGameByPlatform(String platforms) {
        return gameDao.searchGamesByPlatform(platforms);
    }

    public List<Game> searchGamesByRating(String rating) {
        return gameDao.searchGamesByRating(rating);
    }

    public List<Game> searchGamesByTitleRating(String title, String rating) {
        return gameDao.searchGamesByTitleRating(title, rating);
    }

    public List<Game> searchGamesByGenre(String genre) {
        return gameDao.searchGamesByGenre(genre);
    }

    public List<Game> searchGamesByPlatformGenreRatingTitle(String platform, String genre, String rating, String title) {
        return gameDao.searchGamesByPlatformGenreRatingTitle(platform, genre, rating, title);
    }
}
