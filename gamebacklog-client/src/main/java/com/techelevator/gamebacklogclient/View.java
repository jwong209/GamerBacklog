package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.Genre;
import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.model.UserCredentials;

import java.util.List;
import java.util.Scanner;

public class View {

    private static Scanner input = new Scanner(System.in);
    private final String FOREGROUND_DEFAULT = (char) 27 + "[39m";
    private final String FOREGROUND_RED = (char) 27 + "[31m";
    private final String FOREGROUND_GREEN = (char) 27 + "[32m";
    private final String FOREGROUND_BLUE = (char) 27 + "[34m";

    public UserCredentials promptForCredentials() {
        System.out.println("Please login.");
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        int response = Integer.parseInt(input.nextLine());
        return response;
    }

    public void displayMainMenu() {
        System.out.println("\n[ Main Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Browse GAME LIBRARY");
        System.out.println("2. Manage COLLECTION");
        System.out.println("3. Manage BACKLOG");
        System.out.println("4. Manage COMPLETED");
        System.out.println("0. Exit program");
    }

    public void displayCollectionMenu() {
        System.out.println(FOREGROUND_GREEN + "\n[ COLLECTION Menu ]" + FOREGROUND_DEFAULT);
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View all games in COLLECTION");
        System.out.println("2. Search GAME LIBRARY and add a game to COLLECTION");
        System.out.println("3. Remove game from COLLECTION");
        System.out.println("0. Back to Main Menu");
    }

    public void displayBacklogMenu() {
        System.out.println("\n[ BACKLOG Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View all games in BACKLOG");
        System.out.println("2. Browse COLLECTION and add game to BACKLOG");
        System.out.println("3. Remove game from BACKLOG");
        System.out.println("0. Back to Main Menu");
    }

    public void displayCompletedMenu() {
        System.out.println("\n[ Completed Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View all COMPLETED games");
        System.out.println("2. Remove game from COMPLETED");
        System.out.println("0. Back to Main Menu");
    }

    public void displayGamesList(List<Game> gamesList) {
        int idSize = 10;
        int titleSize = 60;
        int releaseSize = 14;
        int ratingSize = 15;
        int metacriticSize = 12;
        int playtimeSize = 9;

        System.out.println("");
        System.out.printf("%-" + idSize + "s%-" + titleSize + "s%-" + releaseSize + "s%-" + ratingSize + "s%-" + metacriticSize + "s%-" + playtimeSize + "s\n", "ID", "TITLE", "RELEASE DATE", "USER SCORE", "METACRITIC", "PLAYTIME");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        for (Game game: gamesList) {
            System.out.printf("%-" + idSize + "d%-" + titleSize + "s%-" + releaseSize + "s%-" + ratingSize + ".2f%-" + metacriticSize + "d%-" + playtimeSize + "d\n",
                    game.getId(),
                    game.getName(),
                    game.getReleased(),
                    game.getRating(),
                    game.getMetacritic(),
                    game.getPlaytime()
                    );
        }
    }

    public void displayGameSearchContinue() {
        System.out.println("\n1. Next page");
        System.out.println("2. End search");
    }

    public void displayPlatformList(List<Platform> platformList) {
        int idSize = 5;
        int nameSize = 20;
        int startSize = 10;
        int endSize = 10;

        System.out.printf("%-" + idSize + "s%-" + nameSize + "s%-" + startSize + "s%" + endSize + "s\n",
                "ID", "NAME", "YEAR START", "YEAR END");
        System.out.println("-------------------------------------------------");

        for (Platform platform: platformList) {
            System.out.printf("%-" + idSize + "d%-" + nameSize + "s%-" + startSize + "d%-" + endSize + "d\n",
                    platform.getId(),
                    platform.getName(),
                    platform.getYearStart(),
                    platform.getYearEnd()
            );
        }
    }

    public void displayGenreList(List<Genre> genreList) {
        int idSize = 5;
        int nameSize = 20;

        System.out.printf("%-" + idSize + "s%-" + nameSize + "s\n",
                "ID", "NAME");
        System.out.println("-------------------------------------------------");

        for (Genre genre: genreList) {
            System.out.printf("%-" + idSize + "d%-" + nameSize + "s\n",
                    genre.getId(),
                    genre.getName()
            );
        }
    }

}
