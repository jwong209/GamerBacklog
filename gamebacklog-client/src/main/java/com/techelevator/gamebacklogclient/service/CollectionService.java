package com.techelevator.gamebacklogclient.service;

import com.techelevator.gamebacklogclient.model.Collection;
import com.techelevator.gamebacklogclient.model.Game;
import com.techelevator.gamebacklogclient.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CollectionService {

    private final String API_BASE_URL;

    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public CollectionService(String url) {
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


    public void addGameToCollection(Collection newCollection) {
        try {
            String url = API_BASE_URL + "/collections/" + newCollection.getCollectionId() + "/games/" + newCollection.getGameId();
            HttpEntity<Collection> entity = makeCollectionEntity(newCollection);

            restTemplate.postForObject(url, entity, Collection.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
    }



    /**
     * Helper method to create the HTTP Entity that bundles the collection data and the auth information together
     * to send to the server REST API.
     *
     * This is used when the request needs to have a body containing the collection data, for example a POST or PUT.
     *
     * @param collection the tag information
     * @return HttpEntity containing the tag data and auth information
     */
    private HttpEntity<Collection> makeCollectionEntity(Collection collection) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(collection, headers);
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
