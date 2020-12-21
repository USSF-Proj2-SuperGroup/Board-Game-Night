package com.supergroup.groupvote;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface GroupVoteRepository extends CrudRepository<GroupVote, Long> {
//    List<GroupVote> findByGameGroupId(int gg);
    List<GroupVote> findByGroupId(int groupId);

}
