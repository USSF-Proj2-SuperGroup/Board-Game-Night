package com.supergroup.groupvote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groupvote")
public class GroupVoteController {
    private final GroupVoteRepository repository;

    public GroupVoteController(GroupVoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<GroupVote> list() {
        return this.repository.findAll();
    }
    @GetMapping("/{gameGroupID}")
    public List<GroupVote> read(@PathVariable int gameGroupID){
        return this.repository.findByGameGroupID(gameGroupID);
    }
}
