package org.example;

import org.example.controller.*;
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
        View view = new View();
//        Scanner userInput = view.getScanner();

        // Create the datasource used by all the DAOs
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/createDatabase");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("postgres1");

    // Create the DAOs needed by the controller
        UserDao userDao = new JdbcUserDao(basicDataSource);
        GameDao gameDao = new JdbcGameDao(basicDataSource);
        BacklogEntryDao backlogEntryDao = new JdbcBacklogEntryDao(basicDataSource);
        UserGameDao userGameDao = new JbdcUserGameDao(basicDataSource);
        GameBacklogDao gameBacklogDao = new JdbcGameBacklogDao(basicDataSource);

    // Create controllers to handle operations
        UserController userController = new UserController(userDao, view);
        GameController gameController = new GameController(gameDao);
        BacklogEntryController backlogEntryController = new BacklogEntryController(backlogEntryDao);
        UserGameController userGameController = new UserGameController(userGameDao, view, gameController);
        GameBacklogController gameBacklogController = new GameBacklogController(gameBacklogDao);


//       List<BacklogEntry> list = backlogEntryDao.getBacklogEntries();
//       for (BacklogEntry backlogEntry: list) {
//           System.out.println(backlogEntry);
//       }

    //  Identification; Ask user for username & password; Search user table for user_id that matches
        int currentUserId = userController.authenticateUser();

    // After identification, Main menu display and prompt
        while (true) {
            try {
                int menuSelection = view.displayMainMenu();

            // Picks 1 View all games user owns (from user_game table)
                if (menuSelection == 1) {
                    List<Game> userCollection = userGameController.getAllGamesByUserId(currentUserId);
                    System.out.println("\n[ Games owned. Found " + userCollection.size() + " games in collection. ]");
                    view.displayPaginatedGames(userCollection);
            // Picks 2 Add game to collection (user_game)
                } else if (menuSelection == 2) {
                    userGameController.searchGameAddToCollection(currentUserId);
            // Picks 3 View all games in user's backlog
                } else if (menuSelection == 3) {
                    List<Game> userBacklog = gameBacklogController.getAllGamesInBacklogByUserId(currentUserId);
                    view.displayPaginatedGames(userBacklog);
            // Picks 4  Add game from collection to backlog
                } else if (menuSelection == 4) {
                // Get gameId from selected game in user's collection
                    List<Game> userCollection = userGameController.getAllGamesByUserId(currentUserId);
                    view.displayPaginatedGames(userCollection);
                    int gameId = view.promptForGameSelection();

                // Get backlogId from the current user's id
                    int backlogId = backlogEntryController.getBacklogIdByUserId(currentUserId);
                    System.out.println("backlogId: " + backlogId);  // testing output view in console

                    String progress = view.promptForProgress();
                    int priority = view.promptForPriority();

                //create backlog entry
                    BacklogEntry newBacklogEntry = backlogEntryController.createBacklogEntry(currentUserId, progress, priority);
                    int newBacklogId = newBacklogEntry.getBacklogId();

                // updates game_backlog
                    gameBacklogController.linkGameBacklog(gameId, newBacklogId);
            // Picks 0 Exit
                } else if (menuSelection == 0) {
                    System.out.println("Exiting program...");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("\n[!] Invalid input. Please enter a number: ");
            }

        }




// ----- User can add a game to their games owned (collection)  -----
        // Display prompts for search criteria
//        String platform = view.promptForPlatform();
//        String genre = view.promptForGenre();
//        String rating = view.promptForRating();
//        String title = view.promptForTitle();
//
//        //  Search game by criteria
//        List<Game> games = gameController.searchGamesByPlatformGenreRatingTitle(platform, genre, rating, title);
//        System.out.println("Search found " + games.size() + " results.");
//
//        // Paginate search results for user selection
//        view.displayPaginatedGames(games);
//
//        int selectedGameIndex = view.promptForGameSelection();
//        Game selectedGame = games.get(selectedGameIndex - 1);
//
//        System.out.println(selectedGame);
//
//        int selectedGameId = selectedGame.getGameId();
//        userGameController.addGameToUserGame(currentUserId, selectedGameId);



//        // Search user_game table with matches of user_id
//        List<Game> ownedGames = userGameController.getAllGamesByUserId(currentUserId);



        // Reference user_id in backlog table to get backlog_id


        // Create backlogEntry object from userId, progress, priority
//        String progress = view.promptForProgress();
//
//        int priority = view.promptForPriority();
//        BacklogEntry newBacklogEntry = backlogEntryController.createBacklogEntry(currentUserId, progress, priority);
//        System.out.println(newBacklogEntry);




        // Testing
//        List<Game> games = gameController.searchGamesByTitleRating(title, rating);
//        List<Game> games = gameController.searchGameByPlatform(platform);
//        List<Game> games = gameController.searchGamesByRating(rating);
//        List<Game> games = gameController.searchGamesByGenre(genre);
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