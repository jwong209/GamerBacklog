package com.techelevator.dao;

import com.techelevator.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

//    User createUser(User newUser);

    User createUser(String username, String password, String role);
}
