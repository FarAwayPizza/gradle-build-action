package com.example.demo.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PollManager {

    // Maps to manage users, polls, and votes
    private Map<String, User> users = new HashMap<>();
    private Map<String, Poll> polls = new HashMap<>();
    private Map<String, Vote> votes = new HashMap<>();  // New map to manage votes

    // Methods to manage Users
    public User addUser(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // Methods to manage Polls
    public Poll addPoll(Poll poll) {
        polls.put(poll.getQuestion(), poll);
        return poll;
    }

    public Poll getPoll(String question) {
        return polls.get(question);
    }

    public List<Poll> getAllPolls() {
        return new ArrayList<>(polls.values());
    }

    // Methods to manage Votes

    // Add a vote
    public Vote addVote(Vote vote) {
        // Find the poll by ID from the vote object
        Poll poll = getPollById(vote.getPollId());
        if (poll != null) {
            // Assuming Poll has a method to add votes
            poll.addVote(vote); // Adapt this line to fit your data structure
        } else {
            throw new IllegalArgumentException("Poll not found for ID: " + vote.getPollId());
        }
        return vote;
    }



    // Update an existing vote
    public Vote updateVote(Vote updatedVote) {
        String voteKey = generateVoteKey(updatedVote.getUsername(), Math.toIntExact(updatedVote.getPollId()));
        votes.put(voteKey, updatedVote);  // Update the vote in the votes map
        return updatedVote;
    }

    // Get a vote by id (or unique key)
    public Vote getVote(String id) {
        return votes.get(id);  // Assuming id is the unique key (username_pollId)
    }

    public List<Vote> getAllVotes() {
        return new ArrayList<>(votes.values());  // Return all votes
    }

    // Helper method to generate a unique key for each vote based on username and pollId
    private String generateVoteKey(String username, int pollId) {
        return username + "_" + pollId;  // Create a unique key using username and pollId
    }

    public void deletePoll(int pollId) {
        System.out.println("Deleting poll with ID: " + pollId);

        // Remove the poll from the polls map
        Poll removedPoll = polls.remove(String.valueOf(pollId));  // Assuming the key is stored as a String
        if (removedPoll == null) {
            System.out.println("Poll not found.");
        } else {
            System.out.println("Poll removed: " + removedPoll);
        }

        // Optionally, remove all associated votes for the poll
        int initialVoteCount = votes.size();
        votes.entrySet().removeIf(entry -> entry.getValue().getPollId() == pollId);
        int finalVoteCount = votes.size();

        System.out.println("Removed " + (initialVoteCount - finalVoteCount) + " associated votes.");
    }

    public Poll getPollById(Long pollId) {
        // Assuming you have a map or list of polls where the poll ID is used as a key
        return polls.get(pollId); // Adapt this line based on how you store the polls
    }

}
