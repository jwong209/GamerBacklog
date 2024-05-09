package org.example;

import org.example.dao.BacklogEntryDao;
import org.example.dao.JdbcBacklogEntryDao;
import org.example.model.BacklogEntry;
import org.junit.Before;

public class BacklogEntryDaoTest extends BaseDaoTests{

    private BacklogEntryDao backlogEntryDao;

    @Before
    public void setup() {
        backlogEntryDao = new JdbcBacklogEntryDao(dataSource);
    }

}
