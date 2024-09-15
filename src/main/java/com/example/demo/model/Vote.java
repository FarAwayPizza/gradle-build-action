package com.example.demo.model;

import java.time.Instant;

public class Vote {

    private String username;
    private Long pollId;
    private Long id;
    private String option;
    private Instant publishedAt;


    // Default constructor (necessary for JSON binding)
    public Vote() {}

    // Constructor with all fields
    public Vote(String username, Long pollId, String option, Instant publishedAt) {
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

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
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

    public Long getOptionId() {
        return id;
    }
}
