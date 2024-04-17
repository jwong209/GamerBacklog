package org.example;

import org.example.model.Game;

import java.util.List;
import java.util.Scanner;

public class View {

    private static Scanner scanner;

    public View(){ View.scanner = new Scanner(System.in);}   // making private prevents Main from access

    public static Scanner getScanner(){
        if(View.scanner == null){
            new View();
        }
        return View.scanner;
    }

    public int displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. View games in collection");
        System.out.println("2. Add game to collection");
        System.out.println("3. View games in backlog");
        System.out.println("4. Add game from collection to backlog");
        System.out.println("0. Exit");
        System.out.print("Please enter a number: ");

        int menuSelection = Integer.parseInt(scanner.nextLine());
        return menuSelection;
    }

    public String promptForUsername() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        return username;
    }

    public String promptForPassword() {
        System.out.print("Enter password: ");
        String username = scanner.nextLine();
        return username;
    }

    public String promptForPlatform() {
        System.out.println("\n[Platform selection choices]");
        System.out.println("-----------------------------------------------------");
        System.out.println("Nintendo | SNES | Nintendo 64 | Nintendo GameCube | Wii | Wii U");
        System.out.println("Game Boy | Game Boy Color | Game Boy Advance | Nintendo DS | Nintendo 3DS");
        System.out.println("Sega Master System | Dreamcast |");
        System.out.println("Sega Game Gear");
        System.out.println("Windows PC | PC DOS | Mac | Linux | Android | iOS | OnLive Game System | Arcade | Amiga | AmigaCD32 | 3DO Interactive Multiplayer");
        System.out.println("Playstation | Playstation 2 | Playstation 3 | Playstation 4 | Playstation 5");
        System.out.println("Playstation Portable | Playstation Vita");
        System.out.println("Xbox | Xbox 360 | Xbox One | Xbox Series");
        System.out.print("Enter a platform: ");
        String platform = scanner.nextLine();
        return platform;
    }

    public String promptForGenre() {
        System.out.println("\n[Genre selection choices]");
        System.out.println("-----------------------------------------------------");
        System.out.println("Adventure | Fighting | Puzzle | Shooter | Platform | Sport | Brawler | Indie | Strategy | Visual Novel | Point-and-Click | Simulator | Racing | Tactical");
        System.out.print("Enter a genre: ");
        String genre = scanner.nextLine();
        return genre;
    }

    public String promptForRating() {
        System.out.println("\n[Rating selection]");
        System.out.println("-----------------------------------------------------");
        System.out.println("Lowest (1) - Highest (5)");
        System.out.print("Enter a rating between 1 and 5: ");
        String rating = scanner.nextLine();
        return rating;
    }

    public String promptForTitle() {
        System.out.print("Enter title of the game: ");
        String title = scanner.nextLine();
        return title;
    }

    public int promptForGameSelection() {
        System.out.print("Enter number of game: ");
        int gameSelection = Integer.parseInt(scanner.nextLine());
        return gameSelection;
    }

    public String promptForProgress() {
        System.out.print("Enter progress: ");
        String input = scanner.nextLine();
        return input;
    }

    public int promptForPriority() {
        System.out.print("Enter priority [Lowest (1) - Highest (5)]: ");
        int priority =  Integer.parseInt(scanner.nextLine());
        return priority;
    }

    public void displayPaginatedGames(List<Game> games) {
        int currentPage = 0;
        int pageSize = 20;  // amount per display to console

        while (true) {
            int startIndex = currentPage * pageSize;
            int endIndex = Math.min(startIndex + pageSize, games.size());

            for (int i = startIndex; i < endIndex; i++) {
                System.out.println((i + 1) + ". " + games.get(i));
            }

            if (endIndex < games.size()) {
                System.out.print("Enter 'n' for next page, 'p' for previous page, 's' to stop at current page: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("n")) {
                    currentPage++;
                } else if (input.equalsIgnoreCase("p")) {
                    currentPage = Math.max(0, currentPage - 1);
                } else if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Invalid input: Please enter 'n', 'p', or 'q'.");
                }
            } else {
                System.out.println("No more games to display.");
                break;
            }
        }
    }

}
