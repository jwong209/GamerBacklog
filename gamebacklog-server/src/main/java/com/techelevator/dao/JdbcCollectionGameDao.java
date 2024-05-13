package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionGameDao implements CollectionGameDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionGameDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void linkCollectionGame(int collectionId, int gameId) {
        String sql = "INSERT INTO collection_game (collection_id, game_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, collectionId, gameId);
    }

    @Override
    public void unlinkCollectionGame(int collectionId, int gameId) {
        String sql = "DELETE FROM collection_game " +
                "WHERE collection_id = ? AND game_id = ?;";
        jdbcTemplate.update(sql, collectionId, gameId);
    }

    @Override
    public List<Integer> getGameIdsInCollection(int userId) {
        List<Integer> gameIds = new ArrayList<>();

        String sql = "SELECT cg.game_id FROM collection_game AS cg " +
                "JOIN collection AS c ON cg.collection_id = c.collection_id " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            gameIds.add(results.getInt("game_id"));
        }

        return gameIds;
    }


}
