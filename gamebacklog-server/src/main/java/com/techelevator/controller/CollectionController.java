package com.techelevator.controller;


import com.techelevator.dao.CollectionGameDao;
import com.techelevator.model.Game;
import com.techelevator.service.CollectionService;
import com.techelevator.service.GameService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/collections")
public class CollectionController {

    private final CollectionGameDao collectionGameDao;
    private final CollectionService collectionService;
    private final GameService gameService;

    public CollectionController(CollectionGameDao collectionGameDao, CollectionService collectionService, GameService gameService) {
        this.collectionGameDao = collectionGameDao;
        this.collectionService = collectionService;
        this.gameService = gameService;
    }

    @RequestMapping(path = "/current-collection-id", method = RequestMethod.GET)
    public int getCollectionId(Principal principal) {
        return collectionService.getCollectionIdByUserId(principal);
    }

    @RequestMapping(path = "/current-games", method = RequestMethod.GET)
    public List<Game> getGamesInCollection(Principal principal) {
        List<Game> games = new ArrayList<>();
        List<Integer> gameIds = collectionService.getGameIdsInCollection(principal);

        for (int id: gameIds) {
            Game game = gameService.getById(id);
            games.add(game);
        }

        return games;
    }

    @RequestMapping(path = "/{collectionId}/games/{gameId}", method = RequestMethod.POST)
    public void addGameToCollection(@PathVariable int collectionId, @PathVariable int gameId) {
        collectionGameDao.linkCollectionGame(collectionId, gameId);
    }


}
