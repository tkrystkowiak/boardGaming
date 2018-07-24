package com.capgemini.UserProfileAndRanking.repositories;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Match;

@Repository
public interface MatchDao {
	
	public void add(Match match);
	

}
