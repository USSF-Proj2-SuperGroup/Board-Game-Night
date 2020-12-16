package com.supergroup.groupvote;

import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/upvote")
    public GroupVote patch(@RequestBody GroupVote input){
        GroupVote gv = this.repository.findById(input.getId()).get();
        gv.setGameVotes(gv.getGameVotes() + 1);
        return this.repository.save(gv);
    }
}
