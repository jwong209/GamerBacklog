package org.example.dao;

import org.example.exception.DaoException;
import org.example.model.User;

import java.util.List;

public interface UserDao {

    User getUserById(int userId) throws DaoException;

    List<User> getUsers() throws DaoException;

    User createUser(String username, String password) throws DaoException;

    User updateUser(User user) throws DaoException;

    int deleteUserById(int userId) throws DaoException;

    int getUserIdByUsernamePassword(String username, String password);
}
