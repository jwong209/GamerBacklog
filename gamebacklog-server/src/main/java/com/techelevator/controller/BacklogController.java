package com.techelevator.controller;

import com.techelevator.dao.BacklogGameDao;
import com.techelevator.exception.BacklogServiceException;
import com.techelevator.exception.CollectionServiceException;
import com.techelevator.exception.DaoException;
import com.techelevator.model.BacklogGame;
import com.techelevator.model.Game;
import com.techelevator.service.BacklogService;
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
@RequestMapping( path = "/backlogs" )
public class BacklogController {

    private final BacklogGameDao backlogGameDao;
    private final BacklogService backlogService;
    private final GameService gameService;

    public BacklogController(BacklogGameDao backlogGameDao, BacklogService backlogService, GameService gameService) {
        this.backlogGameDao = backlogGameDao;
        this.backlogService = backlogService;
        this.gameService = gameService;
    }

    @RequestMapping(path = "/user/id", method = RequestMethod.GET)
    public int getBacklogId(Principal principal) {
        try {
            return backlogService.getBacklogIdByUserId(principal);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Game> getGamesInBacklog(Principal principal) {
        List<Game> games = new ArrayList<>();

        try {
            List<Integer> gameIds = backlogService.getGameIdsInBacklog(principal);

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
    public void addGameToBacklog(@RequestBody BacklogGame backlogGame, Principal principal) {
        try {
            backlogService.addGameToBacklog(backlogGame, principal);
        }  catch (AccessDeniedException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        } catch (BacklogServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Backlog not found");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{backlogId}/games/{gameId}", method = RequestMethod.DELETE)
    public void removeGameFromBacklog(@PathVariable int backlogId, @PathVariable int gameId, Principal principal) {
        try {
            boolean updated = backlogService.removeGameFromBacklog(backlogId, gameId, principal);
            if (updated == false) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to delete backlog entry");
            }

        } catch (AccessDeniedException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        } catch (BacklogServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Backlog not found");
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
