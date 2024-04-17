package org.example.controller;

import org.example.dao.BacklogEntryDao;
import org.example.dao.JdbcBacklogEntryDao;
import org.example.exception.DaoException;
import org.example.model.BacklogEntry;

import java.util.List;

public class BacklogEntryController {

    private BacklogEntryDao backlogEntryDao;

    public BacklogEntryController(BacklogEntryDao backlogEntryDao) {
        this.backlogEntryDao = backlogEntryDao;
    }

    public List<BacklogEntry> getBacklogEntryByUserId(int userId) {
        return backlogEntryDao.getBacklogEntriesByUserId(userId);
    }

    public int getBacklogIdByUserId(int userId) {
        return backlogEntryDao.getBacklogIdByUserId(userId);
    }

    public List<BacklogEntry> getBacklogEntries() {
        return backlogEntryDao.getBacklogEntries();
    }

    public BacklogEntry createBacklogEntry(int userId, String progress, int priority) {
        return backlogEntryDao.createBacklogEntry(userId, progress, priority);
    }
}
