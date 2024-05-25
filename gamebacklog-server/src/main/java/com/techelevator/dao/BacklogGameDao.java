package com.techelevator.dao;

import com.techelevator.model.BacklogGame;

import java.util.List;

public interface BacklogGameDao {

    void linkBacklogGame(BacklogGame backlogGame);

    int unlinkBacklogGame(int backlog_id, int game_id);

    List<Integer> getGameIdsInBacklog(int userId);

}
