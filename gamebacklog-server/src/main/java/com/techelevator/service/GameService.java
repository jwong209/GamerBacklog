package com.techelevator.service;

import com.techelevator.model.ApiResponse;
import com.techelevator.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GameService {

    private RestTemplate restTemplate = new RestTemplate();
    public String API_BASE_URL = "https://api.rawg.io/api/games";
    public String apiKey = "";


    public Game getById(@PathVariable int gameId) {
        String url = API_BASE_URL + "/" + gameId + "?key=" + apiKey;
        Game response = restTemplate.getForObject(url, Game.class);
        return response;
    }

    public ApiResponse searchGames(String name, String platforms, String genres, String metacritic) {

        String adjustedUrl = API_BASE_URL + "?key=" + apiKey;
        ApiResponse apiResponse = null;

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

        apiResponse = restTemplate.getForObject(adjustedUrl, ApiResponse.class);
        return apiResponse;
    }
}
