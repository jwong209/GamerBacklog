package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDao(BasicDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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

    @Override
    public User createUser(User newUser) {
        return null;
    }

    @Override
    public User updateUser(User updatedUser) {
        return null;
    }

    private User mapRowToUser(SqlRowSet results) {
        User user = new User();
        user.setUserId(results.getInt("user_id"));
        user.setUserName(results.getString("username"));
        user.setPassword(results.getString("password"));

        return user;
    }
}
