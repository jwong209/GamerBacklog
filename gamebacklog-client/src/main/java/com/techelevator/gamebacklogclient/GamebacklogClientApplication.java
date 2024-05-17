package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamebacklogClientApplication {

	private static final String API_BASE_URL = "http://localhost:8080/";


	public static void main(String[] args) {
		SpringApplication.run(GamebacklogClientApplication.class, args);

		GameService gameService = new GameService(API_BASE_URL);
//		Game game = gameService.getGameById(795632);
//		System.out.println("id: " + game.getId() + ", name: " + game.getName());

		Game[] games = gameService.searchGames("Jedi Survivor", "187", "", "80");
		for (Game game: games) {
			System.out.println("id: " + game.getId() + ", name: " + game.getName() + ", metacritic: " + game.getMetacritic());
		}


	}


}
