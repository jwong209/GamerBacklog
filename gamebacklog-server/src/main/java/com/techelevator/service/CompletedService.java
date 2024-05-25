package com.techelevator.service;


import com.techelevator.dao.CompletedGameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CompletedGame;
import com.techelevator.model.Game;
import com.techelevator.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompletedService {

    private final CompletedGameDao completedGameDao;
    private final UserDao userDao;

    public CompletedService(CompletedGameDao completedGameDao, UserDao userDao) {
        this.completedGameDao = completedGameDao;
        this.userDao = userDao;
    }

    public List<Integer> getGameIdsInCompleted(Principal principal) {
        List<Integer> gameIds = new ArrayList<>();

        User user = getUser(principal);
        if (user != null) {
            gameIds = completedGameDao.getGameIdsInCompleted(user.getId());
        }

        return gameIds;
    }

    public void addGameToCompleted(CompletedGame completedGame, Principal principal) {
        User user = getUser(principal);
        if (user != null) {
            completedGameDao.addGameToCompleted(completedGame);
        }

    }

//    public boolean removeGameFromCompleted(CompletedGame completedGame, Principal principal) {
//        boolean gameRemoved = false;
//
//
//
//        User user = getUser(principal);
//        if (user != null) {
//            completedGameDao.deleteGameFromCompleted(completedGame);
//        }
//    }

    /*
     * Helper method to get the User object from the Principal.
     */
    private User getUser(Principal principal) {
        String username = principal.getName();
        User user = userDao.getUserByUsername(username);
        return user;
    }

}
