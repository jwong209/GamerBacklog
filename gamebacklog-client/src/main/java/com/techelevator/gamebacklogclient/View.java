package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.model.UserCredentials;

import java.util.List;
import java.util.Scanner;

public class View {

    private final String FOREGROUND_DEFAULT = (char) 27 + "[39m";
    private final String FOREGROUND_RED = (char) 27 + "[31m";
    private final String FOREGROUND_GREEN = (char) 27 + "[32m";
    private final String FOREGROUND_BLUE = (char) 27 + "[34m";

    private static Scanner input = new Scanner(System.in);

    public View() {
        View.input = new Scanner(System.in);
    }

    public void printMessage(String message) {

    }

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

    public int displayMainMenu() {
        System.out.println("\n[ Main Menu ]");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. View games in COLLECTION");
        System.out.println("2. Add game to COLLECTION");
        System.out.println("3. View games in BACKLOG");
        System.out.println("4. Add game from COLLECTION to BACKLOG");
        System.out.println("0. Exit");
        System.out.print("Please enter a number: ");

        int menuSelection = Integer.parseInt(input.nextLine());
        return menuSelection;
    }

    public void displayGamesList(List<Game> gamesList) {
        int idSize = 5;
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
        System.out.println("--------------------------------------------------------------------------------------------------------");

        for (Platform platform: platformList) {
            System.out.printf("%-" + idSize + "d%-" + nameSize + "s%-" + startSize + "d%-" + endSize + "d\n",
                    platform.getId(),
                    platform.getName(),
                    platform.getYearStart(),
                    platform.getYearEnd()
            );
        }
    }

    public String promptForTitle() {
//        System.out.println("\n[ Search by Title ]");
        System.out.println("-----------------------------------------------------");
        System.out.print("Enter title: ");
        String title = input.nextLine();
        return title;
    }

}
