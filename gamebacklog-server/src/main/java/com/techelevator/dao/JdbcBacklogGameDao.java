package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BacklogGame;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcBacklogGameDao implements BacklogGameDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcBacklogGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void linkBacklogGame(BacklogGame backlogGame) {
        int backlogId = backlogGame.getBacklogId();
        int gameId = backlogGame.getGameId();
        int priority = backlogGame.getPriority();
        String progress = backlogGame.getProgress();

        String sql = "INSERT INTO backlog_game (backlog_id, game_id, priority, progress) " +
                "VALUES (?, ?, ?, ?);";

        try {
            jdbcTemplate.update(sql, backlogId, gameId, priority, progress);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void unlinkBacklogGame(int backlogId, int gameId) {
        String sql = "DELETE FROM backlog_game " +
                "WHERE backlog_id = ? AND game_id = ?;";

        try {
            jdbcTemplate.update(sql, backlogId, gameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public List<Integer> getGameIdsInBacklog(int userId) {
        List<Integer> gameIds = new ArrayList<>();

        String sql = "SELECT bg.game_id FROM backlog_game AS bg " +
                "JOIN backlog AS b ON bg.backlog_id = b.backlog_id " +
                "WHERE user_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                gameIds.add(results.getInt("game_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return gameIds;
    }

}
