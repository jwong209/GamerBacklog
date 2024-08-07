package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponseGameScreenshots {

    private int count;

    @JsonProperty("results")
    private List<GameScreenshot> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GameScreenshot> getResults() {
        return results;
    }

    public void setResults(List<GameScreenshot> results) {
        this.results = results;
    }
}
