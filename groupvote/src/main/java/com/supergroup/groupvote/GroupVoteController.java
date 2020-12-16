package com.supergroup.groupvote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{id}")
    public GroupVote read(@PathVariable Integer id){
        return this.repository.findById(id).get();
    }
}
