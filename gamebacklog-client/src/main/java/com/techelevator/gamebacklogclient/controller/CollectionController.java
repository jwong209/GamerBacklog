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

    public CollectionController(View view, CollectionService collectionService) {
        this.view = view;
        this.collectionService = collectionService;
    }

    public void getGamesInCollection() {
        List<Game> userCollection = collectionService.getGamesInCollection();
        System.out.println("\n>> " + userCollection.size() + " game(s) in COLLECTION.");
        view.displayGamesList(userCollection);
    }

    public void addGameToCollection(int gameId) {
        int collectionId = collectionService.getCollectionId();
        System.out.println("Collection id: " + collectionId);

        collectionService.addGameToCollection(collectionId, gameId);
    }

}
