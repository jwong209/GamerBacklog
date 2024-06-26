package com.techelevator.controller;


import com.techelevator.exception.DaoException;
import com.techelevator.model.Game;
import com.techelevator.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/games" )
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Game getGameById(@PathVariable int id) {
        try {
            Game game = gameService.getById(id);
            if (game == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
            } else {
                return game;
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Game> searchGames(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String platforms, @RequestParam(defaultValue = "") String genres, @RequestParam(defaultValue = "") String metacritic, @RequestParam(defaultValue = "") String page) {

        try {
            return gameService.searchGames(name, platforms, genres, metacritic, page);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

}
