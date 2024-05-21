package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.Collection;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.Genre;
import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.service.CollectionService;
import com.techelevator.gamebacklogclient.service.GameService;
import com.techelevator.gamebacklogclient.service.GenreService;
import com.techelevator.gamebacklogclient.service.PlatformService;

import java.util.Arrays;
import java.util.List;

public class CollectionController {

    private View view;
    private CollectionService collectionService;
    private PlatformService platformService;
    private GenreService genreService;
    private GameService gameService;

    public CollectionController(View view, CollectionService collectionService, PlatformService platformService, GenreService genreService, GameService gameService) {
        this.view = view;
        this.collectionService = collectionService;
        this.platformService = platformService;
        this.genreService = genreService;
        this.gameService = gameService;
    }

    public void getGamesInCollection() {
        List<Game> userCollection = collectionService.getGamesInCollection();
        System.out.println("\n>> " + userCollection.size() + " game(s) in COLLECTION.");
        view.displayGamesList(userCollection);
    }

    public void searchForGame() {
    // Title prompt
        String name = view.promptForString("Enter a title: ");

    // Platform selection
        Platform[] platformsArray = platformService.getPlatforms();
        List<Platform> platformList = Arrays.asList(platformsArray);
        System.out.println("\nPlatform list size: " + platformList.size());
        view.displayPlatformList(platformList);

        String platforms = view.promptForString("Enter number of platform: ");

    // Genre selection
        Genre[] genresArray = genreService.getGenres();
        List<Genre> genreList = Arrays.asList(genresArray);
        System.out.println("\nGenre list size: " + genreList.size());
        view.displayGenreList(genreList);

        String genres = view.promptForString("Enter number of genre: ");

    // Metacritic prompt
        String metacritic = view.promptForString("Enter metacritic score: ");

    // User name, platforms, genres, metacritic to do game search on external API, display games list
        Game[] gamesArray = gameService.searchGames(name, platforms, genres, metacritic);
        List<Game> gameList = Arrays.asList(gamesArray);
        view.displayGamesList(gameList);
    }

    public void addGameToCollection(int gameId) {
        int collectionId = collectionService.getCollectionId();
        System.out.println("Collection id: " + collectionId);

        collectionService.addGameToCollection(collectionId, gameId);
    }

}
