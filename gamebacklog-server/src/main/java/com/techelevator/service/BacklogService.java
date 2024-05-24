package com.techelevator.service;


import com.techelevator.dao.BacklogDao;
import com.techelevator.dao.BacklogGameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BacklogGame;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BacklogService {

    private final BacklogDao backlogDao;

    private final UserDao userDao;

    private final BacklogGameDao backlogGameDao;


    public BacklogService(BacklogDao backlogDao, UserDao userDao, BacklogGameDao backlogGameDao) {
        this.backlogDao = backlogDao;
        this.userDao = userDao;
        this.backlogGameDao = backlogGameDao;
    }

    public int getBacklogIdByUserId(Principal principal) {
        int backlogId = 0;
        User user = getUser(principal);

        backlogId = backlogDao.getBacklogIdByUserId(user.getId());
        return backlogId;
    }

    public List<Integer> getGameIdsInBacklog(Principal principal) {
        List<Integer> results = new ArrayList<>();

        User user = getUser(principal);
        if (user != null) {
            results = backlogGameDao.getGameIdsInBacklog(user.getId());
        }

        return results;
    }

    public void addGameToBacklog(BacklogGame backlogGame, Principal principal) {
        User user = getUser(principal);
        if (user != null) {
            backlogGameDao.linkBacklogGame(backlogGame);
        }
    }



    /*
     * Helper method to get the User object from the Principal.
     */
    private User getUser(Principal principal) {
        String username = principal.getName();
        User user = userDao.getUserByUsername(username);
        return user;
    }

}
