package com.techelevator.gamebacklogclient.service;

import com.techelevator.gamebacklogclient.model.Platform;
import com.techelevator.gamebacklogclient.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PlatformService {

    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public PlatformService(String apiBaseUrl) {
        API_BASE_URL = apiBaseUrl;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Platform[] getPlatforms() {
        try {
            ResponseEntity<Platform[]> response = restTemplate.exchange(API_BASE_URL + "/platforms", HttpMethod.GET, makeAuthEntity(), Platform[].class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }


}
