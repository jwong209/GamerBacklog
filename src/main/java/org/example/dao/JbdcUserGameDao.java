package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.Game;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JbdcUserGameDao implements UserGameDao{

    private JdbcTemplate jdbcTemplate;

    public JbdcUserGameDao(BasicDataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    @Override
    public void linkUserGame(int userId, int gameId) {
        String sql = "INSERT INTO user_game (user_id, game_id) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, gameId);
    }

    @Override
    public void unlinkUserGame(int userId, int gameId) {
        String sql = "DELETE FROM user_game " +
                "WHERE user_id = ? AND game_id = ?;";
        jdbcTemplate.update(sql, userId, gameId);
    }

    @Override
    public List<Game> getAllGamesByUserId(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT g.* " +
                "FROM game AS g " +
                "JOIN user_game AS ug ON g.game_id = ug.game_id " +
                "WHERE ug.user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                games.add(mapRowToGame(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return games;
    }

    private Game mapRowToGame(SqlRowSet results) {
        Game game = new Game();
        game.setGameId(results.getInt("game_id"));
        game.setTitle(results.getString("title"));
        game.setReleaseDate(results.getString("release_date"));
        game.setDevelopers(results.getString("developers"));
        game.setSummary(results.getString("summary"));
        game.setPlatforms(results.getString("platforms"));
        game.setGenres(results.getString("genres"));
        game.setRating(results.getString("rating"));
        game.setPlays(results.getString("plays"));
        game.setPlaying(results.getString("playing"));
        game.setBacklogs(results.getString("backlogs"));
        game.setWishlist(results.getString("wishlist"));
        game.setLists(results.getString("lists"));
        game.setReviews(results.getString("reviews"));

        return game;
    }
}
