package com.techelevator.model;

public class RawgEntity {

    private int id;
    private String slug;
    private String name;

    public RawgEntity() {
    }

    public RawgEntity(int id, String slug, String name) {
        this.id = id;
        this.slug = slug;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
