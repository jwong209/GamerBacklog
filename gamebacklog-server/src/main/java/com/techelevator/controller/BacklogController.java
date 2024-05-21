package com.techelevator.controller;

import com.techelevator.dao.BacklogGameDao;
import com.techelevator.model.Game;
import com.techelevator.service.BacklogService;
import com.techelevator.service.GameService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
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

    @RequestMapping(path = "/current-backlog-id", method = RequestMethod.GET)
    public int getBacklogId(Principal principal) {
        return backlogService.getBacklogIdByUserId(principal);
    }

    @RequestMapping(path = "/current-games", method = RequestMethod.GET)
    public List<Game> getGamesInBacklog(Principal principal) {
        List<Game> games = new ArrayList<>();
        List<Integer> gameIds = backlogService.getGameIdsInBacklog(principal);

        for (int id: gameIds) {
            Game game = gameService.getById(id);
            games.add(game);
        }

        return games;
    }

    @RequestMapping(path = "/{backlogId}/games/{gameId}", method = RequestMethod.POST)
    public void addGameToBacklog(@PathVariable int backlogId, @PathVariable int gameId) {
        backlogGameDao.linkBacklogGame(backlogId, gameId);
    }


}
