package org.example.controller;

import org.example.dao.GameBacklogDao;
import org.example.model.Game;

import java.util.List;

public class GameBacklogController {

    private GameBacklogDao gameBacklogDao;

    public GameBacklogController(GameBacklogDao gameBacklogDao) {
        this.gameBacklogDao = gameBacklogDao;
    }

    public List<Game> getAllGamesInBacklogByUserId(int userId) {
        return gameBacklogDao.getAllGamesInBacklogByUserId(userId);
    }

    public void linkGameBacklog(int gameId, int backlogId) {
        gameBacklogDao.linkGameBacklog(gameId, backlogId);
    }

    public void unlinkGameBacklog(int gameId, int backlogId) {
        gameBacklogDao.unlinkGameBacklog(gameId, backlogId);
    }

}
