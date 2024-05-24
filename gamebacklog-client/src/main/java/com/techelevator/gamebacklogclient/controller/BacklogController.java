package com.techelevator.gamebacklogclient.controller;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.BacklogGame;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.service.BacklogService;

import java.util.List;

public class BacklogController {

    private View view;
    private BacklogService backlogService;

    public BacklogController(View view, BacklogService backlogService) {
        this.view = view;
        this.backlogService = backlogService;
    }

    public void getGamesInBacklog() {
        List<Game> userBacklog = backlogService.getGamesInBacklog();
        System.out.println("\n>> " + userBacklog.size() + " game(s) in BACKLOG.");
        view.displayGamesList(userBacklog);
    }

    public void addGameToBacklog(int gameId, int priority, String progress) {
        int backlogId = backlogService.getBacklogId();
        System.out.println("Backlog id: " + backlogId);

        BacklogGame backlogGame = new BacklogGame(backlogId, gameId, priority, progress);

        backlogService.addGameToBacklog(backlogGame);
    }

}
