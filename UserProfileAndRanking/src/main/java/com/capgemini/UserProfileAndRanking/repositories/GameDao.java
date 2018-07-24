package com.capgemini.UserProfileAndRanking.repositories;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Game;

@Repository
public interface GameDao {
	
	public boolean addGame(Game game);
	
	public Game findGame(String name);
	
	
}
