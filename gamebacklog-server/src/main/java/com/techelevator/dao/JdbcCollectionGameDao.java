package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Game;
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
public class JdbcCollectionGameDao implements CollectionGameDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void linkCollectionGame(int collectionId, int gameId) {
        String sql = "INSERT INTO collection_game (collection_id, game_id) " +
                "VALUES (?, ?);";

        try {
            jdbcTemplate.update(sql, collectionId, gameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public int unlinkCollectionGame(int collectionId, int gameId) {
        int count;

        String sql = "DELETE FROM collection_game " +
                "WHERE collection_id = ? AND game_id = ?;";

        try {
            count = jdbcTemplate.update(sql, collectionId, gameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return count;
    }

    @Override
    public List<Integer> getGameIdsInCollection(int userId) {
        List<Integer> gameIds = new ArrayList<>();

        String sql = "SELECT cg.game_id FROM collection_game AS cg " +
                "JOIN collection AS c ON cg.collection_id = c.collection_id " +
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
