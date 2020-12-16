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
<<<<<<< HEAD
    public GroupVote read(@PathVariable Integer id){
=======
    public GroupVote read(@PathVariable Long id){
>>>>>>> efd5ad5a11f30fd2101b5f2fee0faacb4966a306
        return this.repository.findById(id).get();
    }
}