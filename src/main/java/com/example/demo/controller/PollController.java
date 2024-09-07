package com.example.demo.controller;
import com.example.demo.model.Poll;
import com.example.demo.model.PollManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Poll createPoll(@RequestBody Poll poll) {
        return pollManager.addPoll(poll);
    }

    @PutMapping("/{question}")
    public Poll updatePoll(@PathVariable String question, @RequestBody Poll updatedPoll) {
        return pollManager.addPoll(updatedPoll);
    }
    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable String id) {
        pollManager.deletePoll(Integer.parseInt(id));
    }

}
