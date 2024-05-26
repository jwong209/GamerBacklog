package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.*;
import com.techelevator.gamebacklogclient.service.*;
import com.techelevator.gamebacklogclient.util.BasicLogger;

public class BacklogAppController {
    private final AuthenticationService authService;
    private GameService gameService;
    private CollectionService collectionService;
    private BacklogService backlogService;
    private PlatformService platformService;
    private GenreService genreService;
    private CollectionController collectionController;
    private BacklogController backlogController;
    private GameController gameController;
    private View view;
    private AuthenticatedUser currentUser;  // The currently logged-in user, or null if no login


    public BacklogAppController(String apiBaseUrl) {
        view = new View();
        authService = new AuthenticationService(apiBaseUrl);
        gameService = new GameService(apiBaseUrl);
        collectionService = new CollectionService(apiBaseUrl);
        backlogService = new BacklogService(apiBaseUrl);
        platformService = new PlatformService(apiBaseUrl);
        genreService = new GenreService(apiBaseUrl);
        collectionController = new CollectionController(view, collectionService);
        gameController = new GameController(view, gameService, platformService,genreService);
        backlogController = new BacklogController(view, backlogService);
    }

    public void run() {

        try {
            boolean finished = false;

            while (!finished) {
                if (currentUser == null) {
                    handleLogin();
                } else {
                    view.displayMainMenu();

                    int menuSelection = view.promptForInt("Please enter a number: ");
                    if (menuSelection == 1) {               // 1) Browse GAME LIBRARY
                        gameController.searchForGame();
                    } else if (menuSelection == 2) {        // 2) Manage COLLECTION
                        showCollectionSubmenu();
                    } else if (menuSelection == 3) {        // 3) Manage BACKLOG
                        showBacklogSubmenu();
                    } else if (menuSelection == 4) {        // 4) Manage COMPLETED
                        showCompletedSubmenu();
                    } else if (menuSelection == 0) {        // 0) Exit program
                        System.out.println("Exiting program...");
                        finished = true;
                    }
                }
            }
        }  catch (Exception e) {
            System.out.println("An unexpected error has occurred. See the log file for details.");
            BasicLogger.log(e);
        }

    }

    public void handleLogin() {
        UserCredentials credentials = view.promptForCredentials();
        currentUser = authService.login(credentials);

        if (currentUser == null) {
            System.out.println("Login failed.");
        } else {
            System.out.println("Login successful");
            String token = currentUser.getToken();
            gameService.setAuthToken(token);
            collectionService.setAuthToken(token);
            backlogService.setAuthToken(token);
        }

    }

    public void showCollectionSubmenu() {
        boolean showSubMenu = true;
        while (showSubMenu) {
            view.displayCollectionMenu();

            int gameId = 0;
            int subMenuSelection = view.promptForInt("Enter a number: ");

            if (subMenuSelection == 1) {
                System.out.println("\n>> Displaying games from COLLECTION...");
                collectionController.getGamesInCollection();
            } else if (subMenuSelection == 2) {
                gameController.searchForGame();
                gameId = view.promptForInt("Enter game's id: ");
                collectionController.addGameToCollection(gameId);
                System.out.println("Game with id (" + gameId + ") was added to COLLECTION.");
            } else if (subMenuSelection == 3) {
                System.out.println("\n>> Displaying games from COLLECTION...");
                collectionController.getGamesInCollection();
                gameId = view.promptForInt("Enter game's id: ");
                collectionController.removeGameFromCollection(gameId);
            } else if (subMenuSelection == 0) {
                showSubMenu = false;
            }
        }
    }

    public void showBacklogSubmenu() {
        boolean showSubMenu = true;
        while (showSubMenu) {
            view.displayBacklogMenu();

            int gameId = 0;
            int subMenuSelection = view.promptForInt("Enter a number: ");

            if (subMenuSelection == 1) {
                System.out.println("\n>> Displaying games from BACKLOG...");
                backlogController.getGamesInBacklog();
            } else if (subMenuSelection == 2) {
                System.out.println("\n>> Displaying games from COLLECTION...");
                collectionController.getGamesInCollection();
                gameId = view.promptForInt("Enter game's id: ");
                int priority = view.promptForInt("Enter priority [Lowest (1) - Highest (5)]: ");
                String progress = view.promptForString("Enter progress: ");
                backlogController.addGameToBacklog(gameId, priority, progress);
                System.out.println("Game with id (" + gameId + ") was added to BACKLOG.");
            } else if (subMenuSelection == 3) {
                System.out.println("\n>> Displaying games from BACKLOG...");
                backlogController.getGamesInBacklog();
                gameId = view.promptForInt("Enter game's id: ");
                backlogController.removeGameFromBacklog(gameId);
            } else if (subMenuSelection == 0) {
                showSubMenu = false;
            }
        }
    }

    public void showCompletedSubmenu() {
        boolean showSubMenu = true;
        while (showSubMenu) {
            view.displayCompletedMenu();

            int gameId = 0;
            int subMenuSelection = view.promptForInt("Enter a number: ");

            if (subMenuSelection == 1) { // view games
                System.out.println("\n>> Displaying COMPLETED games...");
//                completedController.getGamesInCOMPLETED();
            } else if (subMenuSelection == 2) { // add game
                // search for a game
                gameId = view.promptForInt("Enter game's id: ");
                // add game to completed_game table
                System.out.println("Game with id (" + gameId + ") was added to BACKLOG.");
            } else if (subMenuSelection == 3) { // delete game

            } else if (subMenuSelection == 0) { // exit to main menu
                showSubMenu = false;
            }
        }
    }

}
