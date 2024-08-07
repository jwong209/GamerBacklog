package com.techelevator.model;

public class GameScreenshot {
    private int id;
    private String image;
    private int width;
    private int height;

    public GameScreenshot() {
    }

    public GameScreenshot(int id, String url, int width, int height) {
        this.id = id;
        this.image = url;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
