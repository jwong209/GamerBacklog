package com.techelevator;

import com.techelevator.dao.CollectionGameDao;
import com.techelevator.dao.JdbcCollectionGameDao;
import com.techelevator.model.Game;
import com.techelevator.model.Genre;
import com.techelevator.model.Platform;
import com.techelevator.service.CollectionService;
import com.techelevator.service.GameService;
import com.techelevator.service.GenreService;
import com.techelevator.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
