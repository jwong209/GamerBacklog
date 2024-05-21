package com.techelevator.gamebacklogclient.service;

import com.techelevator.gamebacklogclient.View;
import com.techelevator.gamebacklogclient.model.Backlog;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class BacklogService {

    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public BacklogService(String apiBaseUrl) {
        API_BASE_URL = apiBaseUrl;
    }

    /**
     * This method is used by the controller to update the authToken following the user login.
     *
     * @param authToken - credential token for the currently logged-in user.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getBacklogId() {
        String url = API_BASE_URL + "/backlogs/current-backlog-id";
        ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.GET, makeAuthEntity(), Integer.class);
        return response.getBody();
    }

    public List<Game> getGamesInBacklog() {
        try {
            String url = API_BASE_URL + "/backlogs/current-games";
            ResponseEntity<Game[]> response = restTemplate.exchange(url, HttpMethod.GET, makeAuthEntity(), Game[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public void addGameToBacklog(int backlogId, int gameId) {
        try {
            Backlog newBacklog = new Backlog();
            newBacklog.setBacklogId(backlogId);
            newBacklog.setGameId(gameId);

            HttpEntity<Backlog> entity = makeBacklogEntity(newBacklog);
            String url = API_BASE_URL + "/backlogs/" + backlogId + "/games/" + gameId;

            restTemplate.postForObject(url, entity, Void.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
    }

    /**
     * Helper method to create the HTTP Entity that bundles the collection data and the auth information together
     * to send to the server REST API.
     *
     * This is used when the request needs to have a body containing the data, for example a POST or PUT.
     *
     * @param backlog the tag information
     * @return HttpEntity containing the tag data and auth information
     */
    private HttpEntity<Backlog> makeBacklogEntity(Backlog backlog) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(backlog, headers);
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
