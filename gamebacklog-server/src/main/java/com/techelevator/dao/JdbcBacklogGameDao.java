package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcBacklogGameDao implements BacklogGameDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcBacklogGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void linkBacklogGame(int backlogId, int gameId) {
        String sql = "INSERT INTO backlog_game (backlog_id, game_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, backlogId, gameId);
    }

    @Override
    public void unlinkBacklogGame(int backlogId, int gameId) {
        String sql = "DELETE FROM backlog_game " +
                "WHERE backlog_id = ? AND game_id = ?;";
        jdbcTemplate.update(sql, backlogId, gameId);
    }

    @Override
    public List<Integer> getGameIdsInBacklog(int userId) {
        List<Integer> gameIds = new ArrayList<>();

        String sql = "SELECT bg.game_id FROM backlog_game AS bg " +
                "JOIN backlog AS b ON bg.backlog_id = b.backlog_id " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            gameIds.add(results.getInt("game_id"));
        }

        return gameIds;
    }

}
