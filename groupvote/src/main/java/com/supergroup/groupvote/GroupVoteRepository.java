package com.supergroup.groupvote;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupVoteRepository extends CrudRepository<GroupVote, Integer> {
    List<GroupVote> findByGameGroupID(int gameGroupID);

}
