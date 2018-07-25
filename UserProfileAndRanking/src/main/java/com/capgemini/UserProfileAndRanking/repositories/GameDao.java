package com.capgemini.UserProfileAndRanking.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Game;

@Repository
public interface GameDao {

	public boolean addGame(Game game);

	public Game findGame(String name);

	public Game getGameById(long gameId);

	public List<Game> getListOfGamesByIds(List<Long> gameIds);

}
