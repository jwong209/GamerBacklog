package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponsePlatform {

    private int count;

    @JsonProperty("results")
    private List<Platform> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Platform> getResults() {
        return results;
    }

    public void setResults(List<Platform> results) {
        this.results = results;
    }
}
