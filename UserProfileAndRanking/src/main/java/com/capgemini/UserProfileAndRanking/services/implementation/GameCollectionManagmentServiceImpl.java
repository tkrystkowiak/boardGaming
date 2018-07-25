package com.capgemini.UserProfileAndRanking.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.Game;
import com.capgemini.UserProfileAndRanking.repositories.GameCollectionDao;
import com.capgemini.UserProfileAndRanking.repositories.GameDao;
import com.capgemini.UserProfileAndRanking.services.GameCollectionManagmentService;
import com.capgemini.UserProfileAndRanking.transferobjects.GameMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.GameTO;

@Service
public class GameCollectionManagmentServiceImpl implements GameCollectionManagmentService {

	@Autowired
	GameCollectionDao gameCollectionDao;

	@Autowired
	GameDao gameDao;

	@Autowired
	GameMapper gameMapper;

	@Override
	public List<GameTO> showGamesCollection(long userId) {
		List<Long> gameIds = gameCollectionDao.getUsersGamesIds(userId);
		List<Game> games = gameDao.getListOfGamesByIds(gameIds);
		List<GameTO> mappedGames = new ArrayList<GameTO>();
		games.forEach(game -> mappedGames.add(gameMapper.mapEntityOnTO(game)));
		return mappedGames;
	}

	@Override
	public void removeGame(long userId, long gameId) {
		gameCollectionDao.removeGame(userId, gameId);
	}

	@Override
	public void addGameFromList(long userId, long gameId) {
		gameCollectionDao.addGame(userId, gameId);
	}

	@Override
	public void addNewGame(long userId, GameTO gameTO) {
		Game game = gameMapper.mapTOonEntity(gameTO);
		gameDao.addGame(game);
		gameCollectionDao.addGame(userId, game.getGameID());

	}

}
