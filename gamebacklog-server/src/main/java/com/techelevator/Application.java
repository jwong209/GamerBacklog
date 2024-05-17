package com.techelevator;

import com.techelevator.model.Game;
import com.techelevator.model.Genre;
import com.techelevator.model.Platform;
import com.techelevator.service.GameService;
import com.techelevator.service.GenreService;
import com.techelevator.service.PlatformService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GameService gameService = new GameService();
        GenreService genreService = new GenreService();
        PlatformService platformService = new PlatformService();

//        Game game = gameService.getById(795632);
//        System.out.println("name: " + game.getName());
//        System.out.println("released: " + game.getReleased());
//        System.out.println("user rating: " + game.getRating());
//        System.out.println("metacritic: " + game.getMetacritic());
//        System.out.println("playtime: " + game.getPlaytime());

        List<Game> games = gameService.searchGames("Elden Ring", "", "", "90");
        System.out.println("\nGames List count: " + games.size());

        for (Game game : games) {
                System.out.println("id: " + game.getId() + ", title: " + game.getName() + ", metacritic: " + game.getMetacritic() + ", playtime: " + game.getPlaytime());

        }

        List<Genre> genres = genreService.getGenres();
        System.out.println("\nGenre count: " + genres.size());

        for (Genre genre: genres) {
            System.out.println("id: " + genre.getId() + ", name: " + genre.getName());
        }

        List<Platform> platforms = platformService.getPlatforms();
        System.out.println("\nPlatform count: " + platforms.size());

        for (Platform platform: platforms) {
            System.out.println("id: " + platform.getId() + ", name: " + platform.getName() + ", yearstart: " + platform.getYearStart() + ", yearend: " + platform.getYearEnd());
        }

    }

}
