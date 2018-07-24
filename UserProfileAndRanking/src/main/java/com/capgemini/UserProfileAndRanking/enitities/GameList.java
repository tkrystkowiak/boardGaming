package com.capgemini.UserProfileAndRanking.enitities;

import java.util.List;

public class GameList {
	
	private int userID;
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	private List<Game> games;
	
	public void addGame(Game game){
		games.add(game);
	}
	
}


