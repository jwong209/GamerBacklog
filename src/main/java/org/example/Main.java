package org.example;

import org.example.dao.*;
import org.apache.commons.dbcp2.BasicDataSource; // import Apache BasicDataSource
import org.example.model.BacklogEntry;
import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;


public class Main {

    public static void main(String[] args) {
        // Create the datasource used by all the DAOs
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/createDatabase");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("postgres1");

        // Create the DAOs needed by the controller
        UserDao userDao = new JdbcUserDao(basicDataSource);
        GameDao gameDao = new JdbcGameDao(basicDataSource);
        BacklogEntry backlogEntryDao = null;


        for (User user : userDao.getUsers()) {
            System.out.println("username: " + user.getUserName() + ", password: " + user.getPassword());
        }


    }

}