package com.supergroup.groupvote;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/{groupId}")
    public List<GroupVote> read(@PathVariable int groupId){
        return this.repository.findByGroupId(groupId);
    }

    @PatchMapping("/upvote")
    public GroupVote upvote(@RequestBody GroupVote input){
        GroupVote gv = this.repository.findById(input.getId()).get();
        gv.setGameVotes(gv.getGameVotes() + 1);
        return this.repository.save(gv);
    }

    @PatchMapping("/downvote")
    public GroupVote downvote(@RequestBody GroupVote input){
        GroupVote gv = this.repository.findById(input.getId()).get();
        gv.setGameVotes(gv.getGameVotes() - 1);
        return this.repository.save(gv);
    }

}
