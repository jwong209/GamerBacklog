package org.example.dao;

import org.example.model.Game;
import org.example.model.User;

import java.util.List;

public interface GameBacklogDao {

    List<Game> getAllGamesInBacklogByUserId(int userId);

    void linkGameBacklog(int gameId, int backlogId);
    void unlinkGameBacklog(int gameId, int backlogId);

}
