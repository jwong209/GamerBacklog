package com.techelevator.service;

import com.techelevator.model.ApiResponseGame;
import com.techelevator.model.Game;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GameService {

    private RestTemplate restTemplate = new RestTemplate();
    public String API_BASE_URL = "https://api.rawg.io/api/games";
    public final String RAWG_API_KEY = System.getenv("RAWG_API_KEY");


    public GameService() {
    }

    public Game getById(@PathVariable int gameId) {
        String url = API_BASE_URL + "/" + gameId + "?key=" + RAWG_API_KEY;
        Game response = restTemplate.getForObject(url, Game.class);
        return response;
    }

    public List<Game> searchGames(String name, String platforms, String genres, String metacritic) {

        String adjustedUrl = API_BASE_URL + "?key=" + RAWG_API_KEY;
        ApiResponseGame apiResponse = null;

        if(!name.isEmpty()) {
            adjustedUrl += "&search=" + name;
        }
        if (!platforms.isEmpty()) {
            adjustedUrl += "&platforms=" + platforms;
        }
        if (!genres.isEmpty()) {
            adjustedUrl += "&genres=" + genres;
        }
        if (!metacritic.isEmpty()) {
            adjustedUrl += "&metacritic=" + metacritic;
        }

        apiResponse = restTemplate.getForObject(adjustedUrl, ApiResponseGame.class);
        List<Game> games = apiResponse.getResults();

//        ParameterizedTypeReference<List<Game>> gameTypeRef = new ParameterizedTypeReference<List<Game>>() {};
//
//        ResponseEntity<List<Game>> responseEntity = restTemplate.exchange(adjustedUrl, HttpMethod.GET, null, gameTypeRef);
//        List<Game> games = responseEntity.getBody();
//
//        ApiResponse<List<Game>> apiResponse = new ApiResponse<>();
//        apiResponse.setResults(games);

        return games;
    }
}
