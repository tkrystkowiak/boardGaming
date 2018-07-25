package com.capgemini.UserProfileAndRanking.enitities;

public class GameCollection {

	private long userId;
	private long gameId;

	public GameCollection(long userId, long gameId) {
		super();
		this.userId = userId;
		this.gameId = gameId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

}
