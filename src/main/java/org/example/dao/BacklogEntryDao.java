package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.BacklogEntry;
import org.example.model.User;

import java.util.List;

public interface BacklogEntryDao {

    BacklogEntry getBacklogEntryById(int backlogId) throws DaoException;

    List<BacklogEntry> getBacklogEntries() throws DaoException;

    List<BacklogEntry> getBacklogEntriesByUserId(int userId) throws DaoException;

    int getBacklogIdByUserId(int userId);

    BacklogEntry createBacklogEntry(int userId, String progress, int priority) throws DaoException;

    BacklogEntry updateBacklogEntry(BacklogEntry BacklogEntry) throws DaoException;

    int deleteBacklogEntry(int backlogId) throws DaoException;

}
