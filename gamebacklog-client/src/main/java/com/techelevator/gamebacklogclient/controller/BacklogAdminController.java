package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.model.*;
import com.techelevator.gamebacklogclient.service.AuthenticationService;
import com.techelevator.gamebacklogclient.service.CollectionService;
import com.techelevator.gamebacklogclient.service.GameService;

public class BacklogAdminController {
    private final AuthenticationService authService;

    private GameService gameService;

    private CollectionService collectionService;

    private AuthenticatedUser currentUser;


    public BacklogAdminController(String apiBaseUrl) {
        authService = new AuthenticationService(apiBaseUrl);
        gameService = new GameService(apiBaseUrl);
        collectionService = new CollectionService(apiBaseUrl);
    }

    /**
     * The run() method starts the program flow by displaying the main program menu,
     * and responding to the user's selection.
     */
    public void run() {

    //login
        handleLogin();
    //get collection id
        int collectionId = 2;

        Collection newCollection = new Collection(collectionId, 5);
        collectionService.addGameToCollection(newCollection);

    }

    public void handleLogin() {
        // Use the view to handle user interactions
        UserCredentials credentials = new UserCredentials("steveRogers", "password"); //for testing
        // Use the service to handle communication with the server
        currentUser = authService.login(credentials);

        // Check for successful login (user is not null) AND admin user role (also known as an authority)
        // Note that the view is also used to give feedback to the user
        if (currentUser == null) {
//            view.displayErrorMessage("Login failed.");
            System.out.println("Login failed.");
        } else {
//            view.displaySuccessMessage("Login successful.");
            System.out.println("Login success");
            String token = currentUser.getToken();
            gameService.setAuthToken(token);
            collectionService.setAuthToken(token);
        }

    }

}
