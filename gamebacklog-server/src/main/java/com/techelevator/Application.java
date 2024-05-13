package com.techelevator;

import com.techelevator.model.ApiResponse;
import com.techelevator.model.Game;
import com.techelevator.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GameService gameService = new GameService();
//        Game game = gameService.getById(795632);
//        System.out.println("name: " + game.getName());
//        System.out.println("released: " + game.getReleased());
//        System.out.println("user rating: " + game.getRating());
//        System.out.println("metacritic: " +game.getMetacritic());
//        System.out.println("playtime: " + game.getPlaytime());

        ApiResponse apiResponse = gameService.searchGames("Resident Evil");
        List<Game> games = apiResponse.getGames();
        for (Game game : games) {
            System.out.println(game.getName());
        }

    }

}
