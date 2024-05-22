package com.techelevator.gamebacklogclient.service;

import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public GameService(String url) {
        this.API_BASE_URL = url;
    }

    /**
     * This method is used by the controller to update the authToken following the user login.
     *
     * @param authToken - credential token for the currently logged-in user.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Game getGameById(int gameId) {
        try {
            ResponseEntity<Game> response = restTemplate.exchange(API_BASE_URL + "/games/" + gameId,
                    HttpMethod.GET, makeAuthEntity(), Game.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public List<Game> searchGames(String name, String platforms, String genres, String metacritic, String page) {
        Game[] games = null;
        List<Game> gameList = new ArrayList<>();

        try {
            String query = "?name=" + name + "@platforms=" + platforms + "&genres=" + genres + "&metacritic=" + metacritic + "&page=" + page;
            ResponseEntity<Game[]> response = restTemplate.exchange(API_BASE_URL + "/games" + query, HttpMethod.GET, makeAuthEntity(), Game[].class);
            games = response.getBody();
            gameList = Arrays.asList(games);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return gameList;
    }


    /**
     * Helper method to create the HTTP Entity containing the auth information to send to the server REST API.
     *
     * This is used when the request does not have a body or payload, for example a GET or DELETE.
     *
     * @return HttpEntity containing the auth information (with no request body data).
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
