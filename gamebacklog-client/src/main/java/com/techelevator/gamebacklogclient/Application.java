package com.techelevator.gamebacklogclient;

import com.techelevator.gamebacklogclient.controller.BacklogAdminController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final String API_BASE_URL = "http://localhost:8080/";


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		BacklogAdminController controller = new BacklogAdminController(API_BASE_URL);
		controller.run();
	}


}
