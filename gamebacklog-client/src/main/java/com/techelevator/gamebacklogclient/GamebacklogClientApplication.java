package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.controller.BacklogAdminController;
import com.techelevator.gamebacklogclient.model.AuthenticatedUser;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.model.UserCredentials;
import com.techelevator.gamebacklogclient.service.CollectionService;
import com.techelevator.gamebacklogclient.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamebacklogClientApplication {

	private static final String API_BASE_URL = "http://localhost:8080/";


	public static void main(String[] args) {
		SpringApplication.run(GamebacklogClientApplication.class, args);

		BacklogAdminController controller = new BacklogAdminController(API_BASE_URL);
		controller.run();
	}


}
