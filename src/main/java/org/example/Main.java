package org.example;

import org.example.controller.*;
import org.example.dao.*;
import org.apache.commons.dbcp2.BasicDataSource; // import Apache BasicDataSource
import org.example.model.BacklogEntry;
import org.example.model.Game;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        View view = new View();                  // how to employ Singleton?
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

        int currentUserId = 0;

    // Identification; Ask user for username & password; Search user table for user_id that matches
        while (true) {
            try {
                int loginSelection = view.displayLoginMenu();;

                if (loginSelection == 1) {
                    currentUserId = userController.authenticateUser();
                    break;
                } else if (loginSelection == 2) {
                    // method to create new user in user table;   (UserController)
                    userController.createNewUser();  // don't break so it loops to login?
                }
            } catch (NumberFormatException e) {
                System.out.print("\n[!] Invalid input. Please enter a number: ");
            }
        }

    // After identification, Main menu display and prompts
        while (true) {
            try {
                int menuSelection = view.displayMainMenu();

            // 1) View all games user owns (from user_game table)
                if (menuSelection == 1) {
                    List<Game> userCollection = userGameController.getAllGamesByUserId(currentUserId);
                    System.out.println("\n>> Found " + userCollection.size() + " game(s) in COLLECTION. ");
                    view.displayPaginatedGames(userCollection);
            // 2) Add game to collection (user_game)
                } else if (menuSelection == 2) {
                    userGameController.searchGameAddToCollection(currentUserId);
            // 3) View all games in user's backlog
                } else if (menuSelection == 3) {
                    List<Game> userBacklog = gameBacklogController.getAllGamesInBacklogByUserId(currentUserId);
                    System.out.println("\n>> Found " + userBacklog.size() + " game(s) in BACKLOG");
                    view.displayPaginatedGames(userBacklog);
            // 4)  Add game from collection to backlog
                } else if (menuSelection == 4) {
                // Get gameId from selected game in user's collection; create temporary list to paginate; use that selected Game object and retrieve the gameId which accurately mirrors the number for game_id in the database
                    System.out.println("\n>> Displaying games from COLLECTION...");
                    List<Game> userCollection = userGameController.getAllGamesByUserId(currentUserId);
                    view.displayPaginatedGames(userCollection);

                    int selectedGameIndex = view.promptForGameSelection();
                    Game selectedGame = userCollection.get(selectedGameIndex - 1);

                    System.out.println("Selected game: " + selectedGame);
                    int gameId = selectedGame.getGameId();
//                    System.out.println("Selected gamedId: " + gameId);

                // Prompt for extra parameters to construct BacklogEntry object
                    String progress = view.promptForProgress();
                    int priority = view.promptForPriority();

                // create backlog entry
                    BacklogEntry newBacklogEntry = backlogEntryController.createBacklogEntry(currentUserId, progress, priority);
                    int newBacklogId = newBacklogEntry.getBacklogId();

//                    System.out.println(gameId);
//                    System.out.println(newBacklogId);

                // updates game_backlog
                    gameBacklogController.linkGameBacklog(gameId, newBacklogId);
                    Game gameAddedToBacklog = gameController.getGameById(gameId);
                    System.out.println(">> Game added to BACKLOG: " + gameAddedToBacklog);
            // 0) Exit program
                } else if (menuSelection == 0) {
                    System.out.println("Exiting program...");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("\n[!] Invalid input. Please enter a number: ");
            }

        }
    }

}