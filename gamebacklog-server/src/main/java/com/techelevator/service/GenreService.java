package com.techelevator.service;


import com.techelevator.model.ApiResponseGenre;
import com.techelevator.model.Genre;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GenreService {

    private RestTemplate restTemplate = new RestTemplate();
    public String API_BASE_URL = "https://api.rawg.io/api/genres";
    public final String RAWG_API_KEY = System.getenv("RAWG_API_KEY");

    public List<Genre> getGenres() {
        String adjustedUrl = API_BASE_URL + "?key=" + RAWG_API_KEY;
        ApiResponseGenre apiResponse = null;

        apiResponse = restTemplate.getForObject(adjustedUrl, ApiResponseGenre.class);
        List<Genre> genres = apiResponse.getResults();

        return genres;
    }
}
