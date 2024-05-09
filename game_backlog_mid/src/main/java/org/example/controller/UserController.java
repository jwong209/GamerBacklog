package org.example.controller;

import org.example.View;
import org.example.dao.UserDao;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserDao userDao;
    private View view;
//    private List<Game> gamesOwned = new ArrayList<>();

    public UserController(UserDao userDao, View view) {
        this.userDao = userDao;
        this.view = view;
    }

    public int authenticateUser() {
    // prompt for username and password
        String username = view.promptForUsername();
        String password = view.promptForPassword();
    // search for user_id in user table based on those criteria, get userId
        int userId = userDao.getUserIdByUsernamePassword(username, password);

        if (userId == -1) {
            System.out.println("User information not found. Reenter username and password.");
        } else {
            System.out.println(">> User found. Logging in...");
        }
        return userId;
    }

    public int createNewUser() {
        String username = view.promptForUsername();
        String password = view.promptForPassword();

        User newUser = userDao.createUser(username, password);
        int newUserId = newUser.getUserId();
        return newUserId;
    }


}
