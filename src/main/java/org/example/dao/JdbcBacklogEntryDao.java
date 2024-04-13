package org.example.dao;

import org.example.model.BacklogEntry;

import java.util.List;

public class JdbcBacklogEntryDao implements BacklogEntryDao{


    @Override
    public BacklogEntry getBacklogEntryById(int backlogId) {
        return null;
    }

    @Override
    public List<BacklogEntry> getBacklogEntries() {
        return null;
    }

    @Override
    public List<BacklogEntry> getBacklogEntryByUserId(int userId) {
        return null;
    }

    @Override
    public BacklogEntry updateBacklogEntry(BacklogEntry updatedBacklogEntry) {
        return null;
    }
}
