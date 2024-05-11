package service;

import com.techelevator.model.Game;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Component
public class GameService {
    private RestTemplate restTemplate = new RestTemplate();
    public String API_BASE_URL = "https://api.rawg.io/api/games";
    public String apiKey = "2f0c16d9b65a4c3989230cf9e37c6dee";

    public Game getById(@PathVariable int id) {
        Game response = restTemplate.getForObject(API_BASE_URL + "/" + id + "?key=" + apiKey, Game.class);
        return response;
    }


}
