package org.example;

import org.example.dao.GameBacklogDao;
import org.example.dao.JdbcGameBacklogDao;
import org.junit.Before;

public class GameBacklogDaoTest extends BaseDaoTests{

    private GameBacklogDao gameBacklogDao;

    @Before
    private void setup() {
        gameBacklogDao = new JdbcGameBacklogDao(dataSource);
    }
}
