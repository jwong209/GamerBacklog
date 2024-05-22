package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.Genre;
import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.model.UserCredentials;

import java.util.List;
import java.util.Scanner;

public class View {

    private static Scanner input = new Scanner(System.in);

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
        System.out.println("0. Exit");
    }

    public void displayCollectionMenu() {
        System.out.println("\n[ COLLECTION Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View all games in COLLECTION");
        System.out.println("2. Search GAME LIBRARY and add a game to COLLECTION");
        System.out.println("0. Exit");
    }

    public void displayBacklogMenu() {
        System.out.println("\n[ BACKLOG Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View all games in BACKLOG");
        System.out.println("2. Browse COLLECTION and add game to BACKLOG");
        System.out.println("0. Exit");
    }

    public void displayGamesList(List<Game> gamesList) {
        int idSize = 10;
        int titleSize = 40;
        int releaseSize = 14;
        int ratingSize = 15;
        int metacriticSize = 12;
        int playtimeSize = 9;

        System.out.printf("%-" + idSize + "s%-" + titleSize + "s%-" + releaseSize + "s%-" + ratingSize + "s%-" + metacriticSize + "s%-" + playtimeSize + "s\n", "ID", "TITLE", "RELEASE DATE", "USER SCORE", "METACRITIC", "PLAYTIME");
        System.out.println("--------------------------------------------------------------------------------------------------------");

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
