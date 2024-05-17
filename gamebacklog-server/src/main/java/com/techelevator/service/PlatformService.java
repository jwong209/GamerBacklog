package com.techelevator.service;


import com.techelevator.model.ApiResponseGenre;
import com.techelevator.model.ApiResponsePlatform;
import com.techelevator.model.Genre;
import com.techelevator.model.Platform;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PlatformService {

    private RestTemplate restTemplate = new RestTemplate();
    public String API_BASE_URL = "https://api.rawg.io/api/platforms";
    public final String RAWG_API_KEY = System.getenv("RAWG_API_KEY");

    public List<Platform> getPlatforms() {
        String adjustedUrl = API_BASE_URL + "?key=" + RAWG_API_KEY;
        ApiResponsePlatform apiResponse = null;

        apiResponse = restTemplate.getForObject(adjustedUrl, ApiResponsePlatform.class);
        List<Platform> platforms = apiResponse.getResults();

        return platforms;
    }

}
