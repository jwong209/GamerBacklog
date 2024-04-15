package org.example.controller;

import org.example.dao.BacklogEntryDao;
import org.example.dao.JdbcBacklogEntryDao;

public class BacklogEntryController {

    private BacklogEntryDao backlogEntryDao;

    public BacklogEntryController(BacklogEntryDao backlogEntryDao) {
        this.backlogEntryDao = backlogEntryDao;
    }


}
