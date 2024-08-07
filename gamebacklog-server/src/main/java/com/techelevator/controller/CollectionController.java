package com.techelevator.controller;


import com.techelevator.dao.CollectionGameDao;
import com.techelevator.exception.BacklogServiceException;
import com.techelevator.exception.CollectionServiceException;
import com.techelevator.exception.DaoException;
import com.techelevator.model.BacklogGame;
import com.techelevator.model.CollectionGame;
import com.techelevator.model.Game;
import com.techelevator.service.CollectionService;
import com.techelevator.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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

    @RequestMapping(path = "/user/id", method = RequestMethod.GET)
    public int getCollectionId(Principal principal) {
        try {
            return collectionService.getCollectionIdByUserId(principal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Game> getGamesInCollection(Principal principal) {
        List<Game> games = new ArrayList<>();

        try {
            List<Integer> gameIds = collectionService.getGameIdsInCollection(principal);

            for (int id: gameIds) {
                Game game = gameService.getById(id);
                games.add(game);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return games;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addGameToCollection(@RequestBody CollectionGame collectionGame, Principal principal) {
        try {
            collectionService.addGameToCollection(collectionGame, principal);
        } catch (AccessDeniedException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        } catch (CollectionServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
        }catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{collectionId}/games/{gameId}", method = RequestMethod.DELETE)
    public void removeGameFromCollection(@PathVariable int collectionId, @PathVariable int gameId, Principal principal) {
        try {
            boolean updated = collectionService.removeGameFromCollection(collectionId, gameId, principal);

            if (updated == false) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to delete collection entry");
            }
        } catch (AccessDeniedException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        } catch (BacklogServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Backlog not found");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/{collectionId}/games/{gameId}", method = RequestMethod.GET)
    public CollectionGame getCollectionGame(@PathVariable int collectionId, @PathVariable int gameId, Principal principal) {
        CollectionGame collectionGame = null;

        try {
            collectionGame = collectionService.getCollectionGame(collectionId, gameId, principal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return collectionGame;
    }

    @RequestMapping(path = "/{collectionId}/games/{gameId}", method = RequestMethod.PUT)
    public CollectionGame updateCollectionGame(@PathVariable int collectionId, @PathVariable int gameId, @Valid @RequestBody CollectionGame modifiedCollectionGame, Principal principal) {
        CollectionGame collectionGame = null;

        try {
            collectionGame = collectionService.updateCollectionGame(modifiedCollectionGame, principal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return collectionGame;
    }
}
