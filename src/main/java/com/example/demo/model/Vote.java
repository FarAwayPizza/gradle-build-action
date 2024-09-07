package com.example.demo.model;

import java.time.Instant;

public class Vote {

    private String username;
    private int pollId;
    private String option;
    private Instant publishedAt;

    // Default constructor (necessary for JSON binding)
    public Vote() {}

    // Constructor with all fields
    public Vote(String username, int pollId, String option, Instant publishedAt) {
        this.username = username;
        this.pollId = pollId;
        this.option = option;
        this.publishedAt = publishedAt;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
