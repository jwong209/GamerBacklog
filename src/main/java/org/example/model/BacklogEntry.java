package org.example.model;

public class BacklogEntry {

    private int backlogId;
    private int userId;
    private String progress;
    private int priority;

    public BacklogEntry() {
    }

    public BacklogEntry(int backlogId, int userId, String progress, int priority) {
        this.backlogId = backlogId;
        this.userId = userId;
        this.progress = progress;
        this.priority = priority;
    }

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
