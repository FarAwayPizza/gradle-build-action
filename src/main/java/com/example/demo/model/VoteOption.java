package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class VoteOption {
    private String caption;
    private int presentationOrder;
    private List<Vote> votes;
    private Long id;  // New field for the ID of the option

    // Constructor
    public VoteOption(String caption, int presentationOrder) {
        this.caption = caption;
        this.presentationOrder = presentationOrder;
        this.votes = new ArrayList<>(); // Initialize votes list
    }

    // Getter for votes
    public List<Vote> getVotes() {
        return votes;
    }

    // Method to add a vote
    public void addVote(Vote vote) {
        this.votes.add(vote);
    }

    // Getter and Setter for caption
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    // Getter and Setter for presentationOrder
    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

    // New Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
