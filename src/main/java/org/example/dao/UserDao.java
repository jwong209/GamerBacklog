package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    User getUserById(int userId);

    List<User> getUsers();

    User createUser(User newUser);

    User updateUser(User updatedUser);

}
