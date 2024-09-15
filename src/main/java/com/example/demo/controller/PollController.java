package com.example.demo.controller;
import com.example.demo.model.Poll;
import com.example.demo.model.PollManager;
import com.example.demo.model.Vote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/polls")
public class PollController {

    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }
    @GetMapping("/{question}")
    public Poll getPoll(@PathVariable String question) {
        return pollManager.getPoll(question);
    }
    @GetMapping
    public List<Poll> getAllPolls() {
        return pollManager.getAllPolls();
    }
    @PostMapping
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        pollManager.addPoll(poll); // Assuming your PollManager has an addPoll method
        return ResponseEntity.ok("Poll created successfully");
    }

    @PutMapping("/{question}")
    public Poll updatePoll(@PathVariable String question, @RequestBody Poll updatedPoll) {
        return pollManager.addPoll(updatedPoll);
    }
    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable String id) {
        pollManager.deletePoll(Integer.parseInt(id));
    }

    @PutMapping("/{pollId}/votes")
    public ResponseEntity<?> updateVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        Poll poll = pollManager.getPollById(pollId);
        if (poll == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Poll not found");
        }
        poll.addVote(vote); // Pass the correct optionId from the vote

        return ResponseEntity.ok("Vote updated successfully");

    }


}
