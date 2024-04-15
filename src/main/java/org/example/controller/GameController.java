package org.example.controller;

import org.example.dao.GameDao;
import org.example.model.Game;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public List<Game> searchGameByPlatform(String platforms) {
        List<Game> foundGames = gameDao.searchGamesByPlatform(platforms);
        return foundGames;
    }

    public List<Game> searchGamesByRating(String rating) {
        List<Game> foundGames = gameDao.searchGamesByRating(rating);
        return foundGames;
    }

    public List<Game> searchGamesByTitleRating(String title, String rating) {
        List<Game> foundGames = gameDao.searchGamesByTitleRating(title, rating);
        return foundGames;
    }

    public List<Game> searchGamesByGenre(String genre) {
        List<Game> foundGames = gameDao.searchGamesByGenre(genre);
        return foundGames;
    }

    public List<Game> searchGamesByPlatformGenreRatingTitle(String platform, String genre, String rating, String title) {
        List<Game> foundGames = gameDao.searchGamesByPlatformGenreRatingTitle(platform, genre, rating, title);
        return foundGames;
    }
}
