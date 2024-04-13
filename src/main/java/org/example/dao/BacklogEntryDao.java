package org.example.dao;

import org.example.model.BacklogEntry;

import java.util.List;

public interface BacklogEntryDao {

    BacklogEntry getBacklogEntryById(int backlogId);

    List<BacklogEntry> getBacklogEntries();

    List<BacklogEntry> getBacklogEntryByUserId(int userId);

    BacklogEntry updateBacklogEntry(BacklogEntry updatedBacklogEntry);

}
