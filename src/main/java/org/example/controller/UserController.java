package org.example.controller;

import org.example.dao.UserDao;
import org.example.model.Game;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserDao userDao;
    private List<Game> gamesOwned = new ArrayList<>();

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    public void addGameToGamesOwned(User user, Game game) {
        gamesOwned.add(game);
    }


}
