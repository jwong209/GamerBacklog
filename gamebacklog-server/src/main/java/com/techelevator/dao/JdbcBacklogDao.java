package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Backlog;
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
public class JdbcBacklogDao implements BacklogDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcBacklogDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

// ----- Read -----
    @Override
    public int getBacklogIdByUserId(int userId) throws DaoException {
        Backlog backlog = null;

        String sql = "SELECT * FROM backlog " +
                "WHERE user_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                backlog = mapRowToBacklog(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        int backlogId = backlog.getBacklogId();
        return backlogId;
    }

    @Override
    public Backlog getBacklogById(int backlogId) {
        Backlog backlog = null;

        String sql = "SELECT backlog_id, user_id, progress, priority " +
                "FROM backlog " +
                "WHERE backlog_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, backlogId);
        if (results.next()) {
            backlog = mapRowToBacklog(results);
        }
        return backlog;
    }

    @Override
    public List<Backlog> getBacklogsByUserId(int userId) {
        List<Backlog> backlogEntries = new ArrayList<>();

        String sql = "SELECT backlog_id, progress, priority " +
                "FROM backlog " +
                "WHERE user_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
            while (results.next()) {
                backlogEntries.add(mapRowToBacklog(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return backlogEntries;
    }

// ----- Create -----
    @Override
    public Backlog createBacklog(int userId) throws DaoException {
        Backlog newBacklog = null;
        String sql = "INSERT INTO backlog (user_id) " +
                "VALUES (?) RETURNING backlog_id;";

        try {
            Integer newBacklogId = jdbcTemplate.queryForObject(sql, Integer.class, userId);
            newBacklog = getBacklogById(newBacklogId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newBacklog;
    }

// ----- Update -----
    @Override
    public Backlog updateBacklog(Backlog backlog) throws DaoException {
        Backlog updatedBacklog = null;
        String sql = "UPDATE backlog SET progress = ?, priority = ? " +
                "WHERE backlog_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, backlog.getProgress(), backlog.getPriority());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedBacklog = getBacklogById(backlog.getBacklogId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedBacklog;
    }

// ----- Delete -----
    @Override
    public int deleteBacklog(int backlogId) throws DaoException {
        int numberOfRows = 0;
        String sql = "DELETE FROM backlog WHERE backlog_id = ?;";

        try {
            numberOfRows = jdbcTemplate.update(sql, backlogId);
        }   catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;

    }

    private Backlog mapRowToBacklog(SqlRowSet results) {
        Backlog backlog = new Backlog();
        backlog.setBacklogId(results.getInt("backlog_id"));
        backlog.setUserId(results.getInt("user_id"));
//        backlog.setProgress(results.getString("progress"));
//        backlog.setPriority(results.getInt("priority"));
        return backlog;
    }
}
