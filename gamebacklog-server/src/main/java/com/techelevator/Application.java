package com.techelevator;

import com.techelevator.model.Game;
import com.techelevator.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GameService gameService = new GameService();
        Game game = gameService.getById(1);
        System.out.println(game.getName());

    }

}
