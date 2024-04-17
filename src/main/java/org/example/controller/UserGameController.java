package org.example.controller;

import org.example.View;
import org.example.dao.BacklogEntryDao;
import org.example.dao.UserGameDao;
import org.example.model.Game;

import java.util.List;

public class UserGameController {

    private UserGameDao userGameDao;
    private View view;
    private GameController gameController;

    public UserGameController(UserGameDao userGameDao, View view, GameController gameController) {
        this.userGameDao = userGameDao;
        this.view = view;
        this.gameController = gameController;
    }

    public void addGameToUserGame(int userId, int gameId) {
        userGameDao.linkUserGame(userId, gameId);
    }

    public List<Game> getAllGamesByUserId(int userId) {
        return userGameDao.getAllGamesByUserId(userId);
    }

    public void searchGameAddToCollection(int currentUserId) {
        // Display prompts for search criteria
        String platform = view.promptForPlatform();
        String genre = view.promptForGenre();
        String rating = view.promptForRating();
        String title = view.promptForTitle();

        //  Search game by criteria
        List<Game> games = gameController.searchGamesByPlatformGenreRatingTitle(platform, genre, rating, title);
        System.out.println("Search found " + games.size() + " results.");

        // Paginate search results for user selection
        view.displayPaginatedGames(games);

        int selectedGameIndex = view.promptForGameSelection();
        Game selectedGame = games.get(selectedGameIndex - 1);

        System.out.println(selectedGame);

        int selectedGameId = selectedGame.getGameId();
        addGameToUserGame(currentUserId, selectedGameId);
    }

}
