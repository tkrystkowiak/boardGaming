package com.capgemini.UserProfileAndRanking.services;

import java.util.List;

import com.capgemini.UserProfileAndRanking.transferobjects.GameTO;

public interface GameCollectionManagmentService {

	public List<GameTO> showGamesCollection(long userId);

	public void removeGame(long userId, long gameId);

	public void addGameFromList(long userId, long gameId);

	public void addNewGame(long userId, GameTO gameTO);
}
