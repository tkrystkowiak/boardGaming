package com.capgemini.UserProfileAndRanking.repositories;

import java.util.List;

public interface GameCollectionDao {

	public List<Long> getUsersGamesIds(long userId);

	public void removeGame(long userId, long gameId);

	public void addGame(long userId, long gameId);

}
