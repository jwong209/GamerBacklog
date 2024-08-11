package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Platform {

    private int id;
    private String name;
    @JsonProperty("year_start")
    private int yearStart;
    @JsonProperty("year_end")
    private int yearEnd;

    public Platform() {
    }

    public Platform(int id, String name, int yearStart, int yearEnd) {
        this.id = id;
        this.name = name;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }
}
