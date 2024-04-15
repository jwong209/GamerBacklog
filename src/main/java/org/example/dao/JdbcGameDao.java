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

public class JdbcGameDao implements GameDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcGameDao(BasicDataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

// ----- Read -----
    @Override
    public Game getGameById(int gameId) {
        Game game = null;

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE game_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId);
        if (results.next()) {
            game = mapRowToGame(results);
        }

        return game;
    }

    @Override
    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByPlatformGenreRatingTitle(String platform, String genre, String rating, String title) {
        List<Game> games = new ArrayList<>();
        platform = '%' + platform + '%';
        genre = '%' + genre + '%';
        title = '%' + title + '%';
        rating = rating + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE platforms ILIKE ? " +
                "AND genres ILIKE ? " +
                "AND rating LIKE ? " +
                "AND title ILIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, platform, genre, rating, title);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByTitle(String title) {
        List<Game> games = new ArrayList<>();
        title = '%' + title + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE title ILIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByTitleRating(String title, String rating) {
        List<Game> games = new ArrayList<>();
        title = '%' + title + '%';
        rating = rating + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE title ILIKE ? " +
                "AND rating LIKE ?" +
                "ORDER BY title;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title, rating);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByRating(String rating) {
        List<Game> games = new ArrayList<>();
        rating = rating + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE rating LIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, rating);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByPlatform(String platform) {
        List<Game> games = new ArrayList<>();
        platform = '%' + platform + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE platforms LIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, platform);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

    @Override
    public List<Game> searchGamesByGenre(String genre) {
        List<Game> games = new ArrayList<>();
        genre = '%' + genre + '%';

        String sql = "SELECT game_id, title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews " +
                "FROM game " +
                "WHERE genres LIKE ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre);
        while(results.next()) {
            games.add(mapRowToGame(results));
        }

        return games;
    }

// ----- Create -----
    @Override
    public Game createGame(Game game) {
        Game newGame = null;

        String sql = "INSERT INTO game (title, release_date, developers, summary, platforms, genres, rating, plays, playing, backlogs, wishlist, lists, reviews) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING game_id;";

        try {
            Integer newGameId = jdbcTemplate.queryForObject(sql, int.class, game.getTitle(), game.getReleaseDate(), game.getDevelopers(), game.getSummary(), game.getPlatforms(), game.getGenres(), game.getRating(), game.getPlays(), game.getPlaying(), game.getBacklogs(), game.getWishlist(), game.getLists(), game.getReviews());

            newGame = getGameById(newGameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newGame;
    }


    @Override
    public void linkGameBacklog(int gameId, int backlogId) throws DaoException {
        String sql = "INSERT INTO game_backlog (game_id, backlog_id) VALUES (?, ?);";

        try {
            jdbcTemplate.update(sql, gameId, backlogId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

// ----- Update -----
    @Override
    public Game updateGame(Game game) {
        Game updatedGame = null;
        String sql = "UPDATE game SET title = ?, release_date = ?, developers = ?, summary = ?, platforms = ?, genres = ?, rating = ?, plays = ?, playing = ?, backlogs = ?, wishlist = ?, lists = ?, reviews = ? " +
                "WHERE game_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, game.getTitle(), game.getReleaseDate(), game.getDevelopers(), game.getSummary(), game.getPlatforms(), game.getGenres(), game.getRating(), game.getPlays(), game.getPlaying(), game.getBacklogs(), game.getWishlist(), game.getLists(), game.getReviews(), game.getGameId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedGame = getGameById(game.getGameId());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedGame;
    }

// ----- Delete -----
    @Override
    public int deleteGameById(int gameId) {
        int numberOfRows = 0;
        String gameBacklogSql = "DELETE FROM game_backlog WHERE game_id = ?;";
        String gameSql = "DELETE FROM game WHERE game_id = ?;";

        try {
            numberOfRows += jdbcTemplate.update(gameBacklogSql, gameId);
            numberOfRows += jdbcTemplate.update(gameSql, gameId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    @Override
    public void unlinkGameBacklog(int gameId, int backlogId) throws DaoException {
        String sql = "DELETE FROM game_backlog WHERE game_id = ? AND backlog_id = ?;";
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
