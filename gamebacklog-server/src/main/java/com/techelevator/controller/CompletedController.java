package com.techelevator.controller;


import com.techelevator.exception.DaoException;
import com.techelevator.model.CompletedGame;
import com.techelevator.model.Game;
import com.techelevator.service.CompletedService;
import com.techelevator.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/completed" )
public class CompletedController {

    private final CompletedService completedService;
    private final GameService gameService;

    public CompletedController(CompletedService completedService, GameService gameService) {
        this.completedService = completedService;
        this.gameService = gameService;
    }

    @RequestMapping(path = "/current-games", method = RequestMethod.GET)
    public List<Game> getGamesInCompleted(Principal principal) {
        List<Game> games = new ArrayList<>();

        try {
            List<Integer> gameIds = completedService.getGameIdsInCompleted(principal);

            for (int id : gameIds) {
                Game game = gameService.getById(id);
                games.add(game);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return games;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/current", method = RequestMethod.POST)
    public void addGameToCompleted(@RequestBody CompletedGame completedGame, Principal principal) {
        try {
            completedService.addGameToCompleted(completedGame, principal);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/current/games/id", method = RequestMethod.DELETE)
    public void removeGameFromCompleted(@RequestBody CompletedGame completedGame, Principal principal) {
//        boolean updated = completedService.removeGameFromCompleted(completedGame, principal);
    }

}
