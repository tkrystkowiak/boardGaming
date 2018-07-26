package com.capgemini.UserProfileAndRanking.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Match;

@Repository
public interface MatchDao {

	public void add(Match match);

	public void creatAndAdd(List<Long> participants);

	public List<Match> getAllMatches();

}
