package com.example.demo.controller;

import com.example.demo.model.PollManager;
import com.example.demo.model.Vote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final PollManager pollManager;

    // Constructor-based injection
    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        // Instead of creating a new Vote object, use the one provided by the request
        return pollManager.addVote(vote);  // Assuming pollManager has an addVote method
    }

    @GetMapping("/{id}")
    public Vote getVote(@PathVariable String id) {
        // Logic to retrieve vote by id
        Vote vote = pollManager.getVote(id);  // Fetch the vote using the id
        if (vote == null) {
            // Handle case when vote is not found (optional)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote not found");
        }
        return vote;  // Return the retrieved vote
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        // Assuming you have a method in PollManager to retrieve all votes
        return new ArrayList<>(pollManager.getAllVotes());
    }


    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable String id) {
        // Logic to delete a vote
    }
    @PutMapping
    public Vote updateVote(@RequestBody Vote updatedVote) {
        // Logic to update the vote
        return pollManager.updateVote(updatedVote);  // Make sure PollManager has updateVote method
    }
}