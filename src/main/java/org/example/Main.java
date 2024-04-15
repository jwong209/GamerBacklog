package org.example;

import org.example.controller.BacklogEntryController;
import org.example.controller.GameController;
import org.example.controller.UserController;
import org.example.dao.*;
import org.apache.commons.dbcp2.BasicDataSource; // import Apache BasicDataSource
import org.example.model.BacklogEntry;
import org.example.model.Game;
import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        View view = new View();

        // Create the datasource used by all the DAOs
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/createDatabase");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("postgres1");

    // Create the DAOs needed by the controller
        UserDao userDao = new JdbcUserDao(basicDataSource);
        GameDao gameDao = new JdbcGameDao(basicDataSource);
        BacklogEntryDao backlogEntryDao = new JdbcBacklogEntryDao(basicDataSource);

    // Create controllers to handle operations
        UserController userController = new UserController(userDao);
        GameController gameController = new GameController(gameDao);
        BacklogEntryController backlogEntryController = new BacklogEntryController(backlogEntryDao);

        // Testing rough basic flow
//        List<Game> games = gameController.searchGamesByTitleRating(title, rating);
//        List<Game> games = gameController.searchGameByPlatform(platform);
//        List<Game> games = gameController.searchGamesByRating(rating);
//        List<Game> games = gameController.searchGamesByGenre(genre);

    // Display prompts to search by criteria
        String platform = view.promptForPlatform();
        String genre = view.promptForGenre();
        String rating = view.promptForRating();
        String title = view.promptForTitle();
        List<Game> games = gameController.searchGamesByPlatformGenreRatingTitle(platform, genre, rating, title);
        System.out.println("gamelist size: " + games.size());

    // Paginate search results for user selection
        view.displayPaginatedGames(games);

        int selectedGameInt = view.promptForGameSelection();  // selected game --> game_id
        Game selectedGame = games.get(selectedGameInt - 1);

        System.out.println(selectedGame);

        //  Testing user table is synced
//        for (User user : userDao.getUsers()) {
//            System.out.println("username: " + user.getUserName() + ", password: " + user.getPassword());
//        }
        //  Testing game table is synced
//        List<Game> games = new ArrayList<>();
//        games = gameDao.searchGamesByPlatforms("Nintendo Switch");
//        games = gameDao.searchGamesByTitleRating("star wars", "3");
//        System.out.println(games.size());
//        view.displayPaginatedGames(games);
    }

}