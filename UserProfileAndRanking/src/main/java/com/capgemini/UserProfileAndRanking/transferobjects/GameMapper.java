package com.capgemini.UserProfileAndRanking.transferobjects;

import org.springframework.stereotype.Component;

import com.capgemini.UserProfileAndRanking.enitities.Game;

@Component
public class GameMapper {

	public Game mapTOonEntity(GameTO gameTO) {

		Game game = new Game(gameTO.getName(), gameTO.getDescription());
		game.setGameID(gameTO.getGameID());
		game.setMaxNumberOfPlayers(gameTO.getMaxNumberOfPlayers());
		game.setMinNumberOfPlayers(gameTO.getMinNumberOfPlayers());
		return game;

	}

	public GameTO mapEntityOnTO(Game game) {

		GameTO gameTO = new GameTO(game.getName(), game.getDescription());
		gameTO.setGameID(game.getGameID());
		gameTO.setMaxNumberOfPlayers(game.getMaxNumberOfPlayers());
		gameTO.setMinNumberOfPlayers(game.getMinNumberOfPlayers());
		return gameTO;

	}

}
