package com.techelevator.dao;

import java.util.List;

public interface BacklogGameDao {

    void linkBacklogGame(int backlog_id, int game_id);

    void unlinkBacklogGame(int backlog_id, int game_id);

    List<Integer> getGameIdsInBacklog(int userId);
}
