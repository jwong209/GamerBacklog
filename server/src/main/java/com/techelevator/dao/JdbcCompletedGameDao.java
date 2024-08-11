package com.techelevator.dao;


import com.techelevator.exception.DaoException;
import com.techelevator.model.CompletedGame;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcCompletedGameDao implements CompletedGameDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCompletedGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Integer> getGameIdsInCompleted(int userId) {
        List<Integer> gameIds = new ArrayList<>();

        String sql = "SELECT game_id FROM completed_game " +
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

    @Override
    public void addGameToCompleted(CompletedGame completedGame) {
        int userId = completedGame.getUserId();
        int gameId = completedGame.getGameId();
        LocalDate completionDate = completedGame.getCompletionDate();
        Duration totalPlaytime = completedGame.getTotalPlaytime();

        String sql = "INSERT INTO completed_game (user_id, game_id, completionDate, totalPlaytime) " +
                "VALUES (?, ?, ?, ?);";

        try {
            jdbcTemplate.update(sql, userId,gameId,completionDate, totalPlaytime);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void deleteGameFromCompleted(int userId, int gameId) {
        String sql = "DELETE FROM completed_game " +
                "WHERE user_id = ? AND game_id = ?;";

        try {
            jdbcTemplate.update(sql, userId, gameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

}
