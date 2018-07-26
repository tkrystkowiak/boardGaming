package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.GameCollection;
import com.capgemini.UserProfileAndRanking.repositories.GameCollectionDao;

@Repository
public class GameCollectionDaoImpl implements GameCollectionDao {

	private List<GameCollection> userGameList = new ArrayList<GameCollection>();

	@Override
	public List<Long> getUsersGamesIds(long userId) {

		List<Long> gameIds = new ArrayList<Long>();

		List<GameCollection> filtered = userGameList.stream().filter(x -> x.getUserId() == userId)
				.collect(Collectors.toList());

		filtered.forEach(userGameMap -> gameIds.add(userGameMap.getGameId()));

		return gameIds;
	}

	@Override
	public void removeGame(long userId, long gameId) {

		Iterator<GameCollection> itr = userGameList.iterator();
		while (itr.hasNext()) {
			if (itr.next().getUserId() == userId && itr.next().getGameId() == gameId) {
				itr.remove();
				break;
			}
		}
	}

	@Override
	public void addGame(long userId, long gameId) {

		userGameList.add(new GameCollection(userId, gameId));

	}

}
