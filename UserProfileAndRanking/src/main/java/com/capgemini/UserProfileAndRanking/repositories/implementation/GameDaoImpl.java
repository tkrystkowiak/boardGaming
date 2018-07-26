package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Game;
import com.capgemini.UserProfileAndRanking.repositories.GameDao;

@Repository
public class GameDaoImpl implements GameDao {

	private List<Game> gameList;

	private GameDaoImpl() {
		gameList = new ArrayList<Game>();
	}

	@Override
	public boolean addGame(Game game) {

		if (isGameAlreadyIn(game.getName())) {
			return false;
		}
		gameList.add(game);
		return true;

	}

	@Override
	public Game findGame(String name) {

		Iterator<Game> itr = gameList.iterator();
		while (itr.hasNext()) {
			Game game = itr.next();
			if (game.getName().equals(name)) {
				return game;
			}
		}
		return null;
	}

	private boolean isGameAlreadyIn(String name) {
		Iterator<Game> itr = gameList.iterator();
		while (itr.hasNext()) {
			Game game = itr.next();
			if (game.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Game getGameById(long gameId) {
		Iterator<Game> itr = gameList.iterator();
		while (itr.hasNext()) {
			Game game = itr.next();
			if (game.getGameID() == gameId) {
				return game;
			}
		}
		return null;
	}

	@Override
	public List<Game> getListOfGamesByIds(List<Long> gameIds) {
		List<Game> filteredGames = new ArrayList<Game>();
		gameIds.forEach(gameId -> filteredGames.add(getGameById(gameId)));
		return filteredGames;
	}

	@Override
	public List<Game> getAllGames() {
		return gameList;
	}

}
