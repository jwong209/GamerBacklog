package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.*;
import com.techelevator.gamebacklogclient.service.AuthenticationService;
import com.techelevator.gamebacklogclient.service.CollectionService;
import com.techelevator.gamebacklogclient.service.GameService;
import com.techelevator.gamebacklogclient.service.PlatformService;
import com.techelevator.gamebacklogclient.util.BasicLogger;

import java.util.List;

public class BacklogAdminController {
    private final AuthenticationService authService;
    private GameService gameService;
    private CollectionService collectionService;
    private CollectionController collectionController;
    private PlatformService platformService;

    private View view;
    private AuthenticatedUser currentUser;  // The currently logged-in user, or null if no login


    public BacklogAdminController(String apiBaseUrl) {
        view = new View();
        authService = new AuthenticationService(apiBaseUrl);
        gameService = new GameService(apiBaseUrl);
        collectionService = new CollectionService(apiBaseUrl);
        platformService = new PlatformService(apiBaseUrl);
        collectionController = new CollectionController(view, collectionService, platformService, gameService);
    }

    /**
     * The run() method starts the program flow by displaying the main program menu,
     * and responding to the user's selection.
     */
    public void run() {

        try {
            boolean finished = false;

            while (!finished) {
                if (currentUser == null) {
                    handleLogin();
                } else {
                // Main menu display
                    int menuSelection = view.displayMainMenu();
                // 1) View all games user owns (from user_game table)
                    if (menuSelection == 1) {
                        collectionController.getGamesInCollection();
                // 2) Add game to collection (user_game)
                    } else if (menuSelection == 2) {
                        collectionController.searchAndAddGameToCollection();
                // 3) View all games in user's backlog
                    } else if (menuSelection == 3) {
//                    List<Game> userBacklog = gameBacklogController.getAllGamesInBacklogByUserId(currentUserId);
//                    System.out.println("\n>> Found " + userBacklog.size() + " game(s) in BACKLOG");
//                    view.displayPaginatedGames(userBacklog);
                // 4)  Add game from collection to backlog
                    } else if (menuSelection == 4) {
                        // Get gameId from selected game in user's collection; create temporary list to paginate; use that selected Game object and retrieve the gameId which accurately mirrors the number for game_id in the database
                        System.out.println("\n>> Displaying games from COLLECTION...");
//                    List<Game> userCollection = userGameController.getAllGamesByUserId(currentUserId);
//                    view.displayPaginatedGames(userCollection);

//                    int selectedGameIndex = view.promptForGameSelection();
//                    Game selectedGame = userCollection.get(selectedGameIndex - 1);

//                    System.out.println("Selected game: " + selectedGame);
//                    int gameId = selectedGame.getGameId();

                    // Prompt for extra parameters to construct BacklogEntry object
//                    String progress = view.promptForProgress();
//                    int priority = view.promptForPriority();

                    // create backlog entry
//                    BacklogEntry newBacklogEntry = backlogEntryController.createBacklogEntry(currentUserId, progress, priority);
//                    int newBacklogId = newBacklogEntry.getBacklogId();

                    // updates game_backlog
//                    gameBacklogController.linkGameBacklog(gameId, newBacklogId);
//                    Game gameAddedToBacklog = gameController.getGameById(gameId);
//                    System.out.println(">> Game added to BACKLOG: " + gameAddedToBacklog);
                // 0) Exit program
                    } else if (menuSelection == 0) {
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
        }

    }

}
