package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.exception.DaoException;
import org.example.model.BacklogEntry;
import org.example.model.User;

import java.util.List;

public interface BacklogEntryDao {

    BacklogEntry getBacklogEntryById(int backlogId) throws DaoException;

    List<BacklogEntry> getBacklogEntries() throws DaoException;

    List<BacklogEntry> getBacklogEntryByUserId(int userId) throws DaoException;

    BacklogEntry createBacklogEntry(BacklogEntry backlogEntry) throws DaoException;

    BacklogEntry updateBacklogEntry(BacklogEntry BacklogEntry) throws DaoException;

    int deleteBacklogEntry(int backlogId) throws DaoException;

}
