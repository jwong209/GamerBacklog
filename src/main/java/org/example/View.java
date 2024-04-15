package org.example;

import org.example.model.Game;

import java.util.List;
import java.util.Scanner;

public class View {

    private static Scanner scanner;

    public View(){
        View.scanner = new Scanner(System.in);
    }

    public static Scanner getScanner(){
        if(View.scanner == null){
            new View();
        }
        return View.scanner;
    }

    public String promptForTitle() {
        System.out.println("Enter title of the game: ");
        return scanner.nextLine();
    }

    public String promptForRating() {
        System.out.println("Enter rating of the game (1, 2, 3, 4, 5) : ");
        return scanner.nextLine();
    }

    public String promptForPlatform() {
        System.out.println("Enter a platform: ");
        return scanner.nextLine();
    }

    public String promptForGenre() {
        System.out.println("Enter a genre: ");
        return scanner.nextLine();
    }

    public int promptForGameSelection() {
        System.out.println("Enter number of game: ");
        int selection = scanner.nextInt();
        return selection;
    }

    public void displayPaginatedGames(List<Game> games) {
        int currentPage = 0;
        int pageSize = 20;  // amount per display to console

        while (true) {
            int startIndex = currentPage * pageSize;  // won't reveal until page 1
            int endIndex = Math.min(startIndex + pageSize, games.size());

            for (int i = startIndex; i < endIndex; i++) {
                System.out.println((i + 1) + ". " + games.get(i));
            }

            if (endIndex < games.size()) {
                System.out.println("Enter 'n' for next page, 'p' for previous page, 'q' to quit: ");

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("n")) {
                    currentPage++;
                } else if (input.equalsIgnoreCase("p")) {
                    currentPage = Math.max(0, currentPage -1);
                } else if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Invalid input: Please enter 'n', 'p', or 'q'.");
                }
            } else {
                System.out.println("No games to display.");
                break;
            }
        }
    }

}
