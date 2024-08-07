package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CollectionGame;
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

//    @Override
//    public void linkCollectionGame(int collectionId, int gameId) {
//        String sql = "INSERT INTO collection_game (collection_id, game_id) " +
//                "VALUES (?, ?);";
//
//        try {
//            jdbcTemplate.update(sql, collectionId, gameId);
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//    }

    @Override
    public void linkCollectionGame(CollectionGame collectionGame) {
        int collectionId = collectionGame.getCollectionId();
        int gameId = collectionGame.getGameId();
        String status = collectionGame.getStatus();
        String format = collectionGame.getFormat();
        String platform = collectionGame.getPlatform();
        int rating = collectionGame.getRating();
        String notes = collectionGame.getNotes();

        String sql = "INSERT INTO collection_game (collection_id, game_id, status, format, platform, rating, notes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            jdbcTemplate.update(sql, collectionId, gameId, status, format, platform, rating, notes);
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

    @Override
    public CollectionGame getCollectionGame(int collectionId, int gameId) {
        CollectionGame collectionGame = null;

        String sql = "SELECT * " +
                "FROM collection_game " +
                "WHERE collection_id = ? AND game_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId, gameId);
            if (results.next()) {
                collectionGame = mapRowToCollectionGame(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Error occurred: " + e);
        }

        return collectionGame;
    }

    @Override
    public CollectionGame updateCollectionGame(CollectionGame collectionGame) {
        CollectionGame updatedCollectionGame = null;

        String sql = "UPDATE collection_game SET status = ?, format = ?, platform = ?, rating = ?, notes = ? " +
                "WHERE collection_id = ? AND game_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, collectionGame.getStatus(), collectionGame.getFormat(), collectionGame.getPlatform(), collectionGame.getRating(), collectionGame.getNotes(), collectionGame.getCollectionId(), collectionGame.getGameId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                // retrieve updated to get any updated fields
                updatedCollectionGame = getCollectionGame(collectionGame.getCollectionId(), collectionGame.getGameId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedCollectionGame;
    }


    private CollectionGame mapRowToCollectionGame(SqlRowSet results) {
        CollectionGame collectionGame = new CollectionGame();
        collectionGame.setCollectionId(results.getInt("collection_id"));
        collectionGame.setGameId(results.getInt("game_id"));
        collectionGame.setStatus(results.getString("status"));
        collectionGame.setFormat(results.getString("format"));
        collectionGame.setPlatform(results.getString("platform"));
        collectionGame.setRating(results.getInt("rating"));
        collectionGame.setNotes(results.getString("notes"));
        return collectionGame;
    }
}
