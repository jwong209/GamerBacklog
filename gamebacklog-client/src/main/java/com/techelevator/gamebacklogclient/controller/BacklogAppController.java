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
        collectionController = new CollectionController(view, collectionService, platformService,genreService, gameService);
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
                    int gameId = 0;
                    if (menuSelection == 1) {               // 1) View all games user owns
                        collectionController.getGamesInCollection();
                    } else if (menuSelection == 2) {        // 2) Add game to collection
                        collectionController.searchForGame();
                        System.out.println("gameId: " + gameId);
                        gameId = view.promptForInt("Enter game's id: ");
                        collectionController.addGameToCollection(gameId);
                        System.out.println("Game with id (" + gameId + ") was added to COLLECTION.");

                    } else if (menuSelection == 3) {        // 3) View all games in backlog
                        backlogController.getGamesInBacklog();
                    } else if (menuSelection == 4) {       // 4)  Add game from collection to backlog
                        System.out.println("\n>> Displaying games from COLLECTION...");
                        collectionController.getGamesInCollection();

                        System.out.println("current gameId: " + gameId); // testing here
                        gameId = view.promptForInt("Enter game's id: ");

                        backlogController.addGameToBacklog(gameId);
                        System.out.println("Game with id (" + gameId + ") was added to BACKLOG.");

                    } else if (menuSelection == 0) {      // 0) Exit program
                        System.out.println("Exiting program...");
                        break;
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

        // Use the service to handle communication with the server
        currentUser = authService.login(credentials);

        // Check for successful login (user is not null) AND admin user role (also known as an authority)
        // Note that the view is also used to give feedback to the user
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

}
