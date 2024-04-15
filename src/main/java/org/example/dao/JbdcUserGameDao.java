package org.example.dao;

import org.example.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JbdcUserGameDao implements UserGameDao{

    private JdbcTemplate jdbcTemplate;

    public JbdcUserGameDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void linkUserGame(int userId, int gameId) {
        String sql = "INSERT INTO user_game (userId, gameId) " +
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

        String sql = "SELECT user_id, game_id " +
                "FROM game " +
                "JOIN user_game ON game.game_id = user_game.game_id " +
                "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            games.add(mapRowToGame(results));
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
