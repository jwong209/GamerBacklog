package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PlatformWrapper {
    private Platform platform;
    @JsonProperty("released_at")
    private Date releasedAt;

    public PlatformWrapper() {
    }

    public PlatformWrapper(Platform platform, Date releasedAt) {
        this.platform = platform;
        this.releasedAt = releasedAt;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }
}
