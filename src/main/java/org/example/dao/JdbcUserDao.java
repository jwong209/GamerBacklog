package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

// ----- Read -----
    @Override
    public User getUserById(int userId) {
        User user = null;

        String sql = "SELECT user_id, username, password " +
                "FROM \"user\" " +
                "WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            user = mapRowToUser(results);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT user_id, username, password " +
                "FROM \"user\"";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            users.add(mapRowToUser(results));
        }

        return users;
    }
    @Override
    public int getUserIdByUsernamePassword(String username, String password) throws DaoException {
        Integer userId = -1;  // non-existent
        String sql = "SELECT user_id " +
                "FROM \"user\" " +
                "WHERE username = ? " +
                "AND password = ?;";
        try {
            userId = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return userId;
    }
// ----- Create -----
    @Override
    public User createUser(String username, String password) throws DaoException {
        User newUser = null;
        String sql = "INSERT INTO \"user\" (username, password) " +
                "VALUES (?, ?) RETURNING user_id;";

        try {
            Integer newUserId = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

            newUser = getUserById(newUserId);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newUser;
    }
// ----- Update -----

    @Override
    public User updateUser(User user) throws DaoException {
        User updatedUser = null;
        String sql = "UPDATE \"user\" SET username = ?, password = ? " +
                "WHERE user_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, user.getUserName(), user.getPassword(), user.getUserId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedUser = getUserById(user.getUserId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedUser;
    }
// ----- Delete -----

    @Override
    public int deleteUserById(int userId) throws DaoException {
        int numberOfRows = 0;
        String gameBacklogSql = "DELETE FROM game_backlog WHERE backlog_id IN (SELECT backlog_id FROM backlog WHERE user_id = ?);";
        String userBacklogSql = "DELETE FROM backlog WHERE user_id = ?;";
        String userGamerSql = "DELETE FROM user_game WHERE user_id = ?;";
        String userSql = "DELETE FROM \"user\" WHERE user_id = ?;";

        try {
            numberOfRows += jdbcTemplate.update(gameBacklogSql, userId);
            numberOfRows += jdbcTemplate.update(userBacklogSql, userId);
            numberOfRows += jdbcTemplate.update(userGamerSql, userId);
            numberOfRows += jdbcTemplate.update(userSql, userId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    private User mapRowToUser(SqlRowSet results) {
        User user = new User();
        user.setUserId(results.getInt("user_id"));
        user.setUserName(results.getString("username"));
        user.setPassword(results.getString("password"));

        return user;
    }
}
