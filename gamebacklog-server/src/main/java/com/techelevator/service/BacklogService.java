package com.techelevator.service;


import com.techelevator.dao.BacklogDao;
import com.techelevator.dao.BacklogGameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.BacklogGame;
import com.techelevator.model.Game;
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

    public boolean removeGameFromBacklog(int backlogId, int gameId, Principal principal) {
        boolean gameRemoved = false;

        User user = getUser(principal);
        if (user != null) {
            int deleteCount = backlogGameDao.unlinkBacklogGame(backlogId, gameId);
            gameRemoved = (deleteCount != 0);
        }

        return gameRemoved;
    }

    public BacklogGame getBacklogGame(int backlogId, int gameId, Principal principal) {
        BacklogGame backlogGame = null;

        User user = getUser(principal);
        if (user != null) {
            backlogGame = backlogGameDao.getBacklogGame(backlogId, gameId);
        }

        return backlogGame;
    }

    public BacklogGame updateBacklogGame(BacklogGame modifiedBacklogGame, Principal principal) {
        BacklogGame backlogGame = null;

        User user = getUser(principal);
        if (user != null) {
            backlogGame = backlogGameDao.updateBacklogGame(modifiedBacklogGame);
        }

        return backlogGame;
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
