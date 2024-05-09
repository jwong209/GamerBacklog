package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.JdbcUserDao;
import org.example.dao.UserDao;
import org.example.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest extends BaseDaoTests{
    private UserDao userDao;

    private final int INVALID_USER_ID = -1;
    private static final User USER_1 = new User(1, "dannyRand", "ironFist@gmail.com");
    private static final User NEW_USER = new User(4, "newestUser", "newOne@gmail.com");

    @Before
    public void setup() {
        userDao = new JdbcUserDao(dataSource);
    }

    @Test
    public void getUserById_returns_correct_user() {
        User user = userDao.getUserById(1);

        assertUsersMatch(USER_1, user);
    }

    @Test
    public void getUserById_with_invalid_userId_returns_null() {
        User user = userDao.getUserById(INVALID_USER_ID);

        Assert.assertNull(user);
    }

    @Test
    public void getUsers_returns_correct_number_of_user() {
        List<User> allUsers = userDao.getUsers();
        int actual = allUsers.size();

        Assert.assertEquals(3, actual);
    }

    @Test
    public void createUser_successfully_creates_a_user() {
        User newUser = userDao.createUser("newestUser", "newOne@gmail.com");

        assertUsersMatch(NEW_USER, newUser);
    }

    @Test
    public void updateUser_successfully_updates_user() {
        User userToUpdate = userDao.getUserById(1);
        userToUpdate.setPassword("newPassword");

        User updatedUser = userDao.updateUser(userToUpdate);
        User retrievedUser = userDao.getUserById(updatedUser.getUserId());

        Assert.assertEquals(updatedUser.getPassword(), retrievedUser.getPassword());
    }

//    @Test
//    public void updateUser_with_invalid_user_object_returns_null() {
//        User userWithInvalidId = new User(INVALID_USER_ID, "John", "nopassword");
//
//        User updatedUser = userDao.updateUser(userWithInvalidId);
//
//        Assert.assertNull(updatedUser);
//    }

    @Test
    public void deleteUserById_deletes_user() {
        int rowsAffected = userDao.deleteUserById(1);

        Assert.assertEquals(6, rowsAffected);

        User retrivedUser = userDao.getUserById(1);
        Assert.assertNull(retrivedUser);
    }

    private void assertUsersMatch(User expected, User actual) {
        Assert.assertEquals(expected.getUserName(), actual.getUserName());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
    }
}
