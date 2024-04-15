package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(BasicDataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

// ----- Read -----
    @Override
    public User getUserById(int userId) {
        User user = null;

        String sql = "SELECT user_id, username, password " +
                "FROM user " +
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
                "FROM public.user";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            users.add(mapRowToUser(results));
        }

        return users;
    }
// ----- Create -----
    @Override
    public User createUser(User user) {
        User newUser = null;
        String sql = "INSERT INTO user (username, password) " +
                "VALUES (?, ?) RETURNING user_id;";

        try {
            Integer newUserId = jdbcTemplate.queryForObject(sql, Integer.class, user.getUserName(), user.getPassword());

            newUser = getUserById(newUserId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newUser;
    }

// ----- Update -----
    @Override
    public User updateUser(User user) {
        User updatedUser = null;
        String sql = "UPDATE user SET username = ?, password = ? " +
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
    public int deleteUserById(int userId) {
        int numberOfRows = 0;
        String userBacklogSql = "DELETE FROM backlog WHERE user_id = ?;";
        String userSql = "DELETE FROM user WHERE user_id = ?;";

        try {
            numberOfRows += jdbcTemplate.update(userBacklogSql, userId);
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
