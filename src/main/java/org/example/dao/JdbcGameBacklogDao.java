package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.Game;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcGameBacklogDao implements GameBacklogDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcGameBacklogDao(BasicDataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    @Override
    public List<Game> getAllGamesInBacklogByUserId(int userId) {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT g.* " +
                "FROM game AS g " +
                "JOIN game_backlog AS gb ON g.game_id = gb.game_id " +
                "JOIN backlog AS b ON b.backlog_id = gb.backlog_id " +
                "WHERE b.user_id = ?;";
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

    @Override
    public void linkGameBacklog(int gameId, int backlogId) {
        String sql = "INSERT INTO game_backlog (game_id, backlog_id) " +
                "VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, gameId, backlogId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void unlinkGameBacklog(int gameId, int backlogId) {
        String sql = "DELETE FROM game_backlog " +
                "WHERE game_id = ? AND backlog_id = ?;";
        try {
            jdbcTemplate.update(sql, gameId, backlogId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
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
