package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.Genre;
import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.service.CollectionService;
import com.techelevator.gamebacklogclient.service.GameService;
import com.techelevator.gamebacklogclient.service.PlatformService;

import java.util.Arrays;
import java.util.List;

public class CollectionController {

    private View view;
    private CollectionService collectionService;
    private PlatformService platformService;
    private GameService gameService;

    public CollectionController(View view, CollectionService collectionService, PlatformService platformService, GameService gameService) {
        this.view = view;
        this.collectionService = collectionService;
        this.platformService = platformService;
        this.gameService = gameService;
    }

    public void getGamesInCollection() {
        List<Game> userCollection = collectionService.getGamesInCollection();
        System.out.println("\n>> " + userCollection.size() + " game(s) in COLLECTION.");
        view.displayGamesList(userCollection);
    }

    public void searchAndAddGameToCollection() {
    // Search for games
        String name = view.promptForTitle();

    // Platform selection
        Platform[] platformsArray = platformService.getPlatforms();
        List<Platform> platformList = Arrays.asList(platformsArray);
        System.out.println("\nPlatform list size: " + platformList.size());
        view.displayPlatformList(platformList);

    // Make a selection from platforms
        String platforms = "";

    // Display genres

    //  Make selection from genres
        String genres = "";

    // Select a metacritic score
        String metacritic = "";

    // User name, platforms, genres, metacritic to do game search on external API

        Game[] games = gameService.searchGames(name, platforms, genres, metacritic);

    // Display games list from the game search and make selection


    // Use collectionId and gameId to add to database


//        collectionService.addGameToCollection();
    }
}
