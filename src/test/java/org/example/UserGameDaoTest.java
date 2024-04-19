package org.example;

import org.example.dao.JbdcUserGameDao;
import org.example.dao.UserGameDao;
import org.junit.Before;

public class UserGameDaoTest extends BaseDaoTests{
    private UserGameDao userGameDao;

    @Before
    public void setup() {
        userGameDao = new JbdcUserGameDao(dataSource);
    }

}
