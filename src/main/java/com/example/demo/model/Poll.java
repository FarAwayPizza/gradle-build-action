package com.example.demo.model;

import java.time.Instant;
import java.util.List;

public class Poll {
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private List<VoteOption> options;

    public Poll() {}

    public Poll(String question, Instant publishedAt, Instant validUntil, List<VoteOption> options) {
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public void addVote(Vote vote) {
        // Get the option ID from the vote
        Long optionId = vote.getOptionId();

        // Loop through the options to find the correct one by optionId
        for (VoteOption option : options) {
            if (option.getId().equals(optionId)) { // Assuming VoteOption has an id field
                option.addVote(vote); // Add the vote to the correct option
                return;  // Stop the loop once the correct option is found
            }
        }

        // Handle case where optionId is not found
        throw new IllegalArgumentException("Option ID not found: " + optionId);
    }

}
