package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.BacklogEntry;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcBacklogEntryDao implements BacklogEntryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBacklogEntryDao(BasicDataSource basicDataSource) {
        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

// ----- Read -----
    @Override
    public BacklogEntry getBacklogEntryById(int backlogId) {
        BacklogEntry backlogEntry = null;

        String sql = "SELECT backlog_id, user_id, progress, priority " +
             "FROM backlog " +
             "WHERE backlog_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, backlogId);
        if (results.next()) {
            backlogEntry = mapRowToBacklogEntry(results);
        }

        return backlogEntry;
    }

    @Override
    public List<BacklogEntry> getBacklogEntries() {
        List<BacklogEntry> backlogEntries = new ArrayList<>();

        String sql = "SELECT backlog_id, progress, priority " +
                "FROM backlog";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            backlogEntries.add(mapRowToBacklogEntry(results));
        }

        return backlogEntries;
    }

    @Override
    public List<BacklogEntry> getBacklogEntriesByUserId(int userId) {
        List<BacklogEntry> backlogEntries = new ArrayList<>();

        String sql = "SELECT backlog_id, progress, priority " +
                "FROM backlog " +
                "WHERE user_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
            while (results.next()) {
                backlogEntries.add(mapRowToBacklogEntry(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return backlogEntries;
    }

    @Override
    public int getBacklogIdByUserId(int userId) {
        int backlogId = -1;
        String sql = "SELECT backlog_id " +
                "FROM backlog " +
                "WHERE user_id = ? " +
                "LIMIT 1";

        backlogId = jdbcTemplate.queryForObject(sql, Integer.class, userId);

        return backlogId;
    }


    // ----- Create -----
    @Override
    public BacklogEntry createBacklogEntry(int userId, String progress, int priority) throws DaoException {
        BacklogEntry newBacklogEntry = null;
        String sql = "INSERT INTO backlog (user_id, progress, priority) " +
                "VALUES (?, ?, ?) RETURNING backlog_id;";

        try {
            Integer newBacklogEntryId = jdbcTemplate.queryForObject(sql, Integer.class, userId, progress, priority);

            newBacklogEntry = getBacklogEntryById(newBacklogEntryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newBacklogEntry;
    }

// ----- Update -----
    @Override
    public BacklogEntry updateBacklogEntry(BacklogEntry backlogEntry) {
        BacklogEntry updatedBacklogEntry = null;
        String sql = "UPDATE backlog SET progress = ?, priority = ? " +
                "WHERE backlog_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, backlogEntry.getProgress(), backlogEntry.getPriority());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedBacklogEntry = getBacklogEntryById(backlogEntry.getBacklogId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedBacklogEntry;
    }

    // ----- Delete -----
    @Override
    public int deleteBacklogEntry(int backlogId) throws DaoException {
        int numberOfRows = 0;
        String sql = "DELETE FROM backlog WHERE backlog_id = ?;";
        try {
            numberOfRows = jdbcTemplate.update(sql, backlogId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }


    private BacklogEntry mapRowToBacklogEntry(SqlRowSet results) {
        BacklogEntry backlogEntry = new BacklogEntry();
        backlogEntry.setBacklogId(results.getInt("backlog_id"));
        backlogEntry.setProgress(results.getString("progress"));
        backlogEntry.setPriority(results.getInt("priority"));

        return backlogEntry;
    }
}
