package com.capgemini.UserProfileAndRanking.enitities;

public class Game {

	private long GameID;
	private String name;
	private String description;
	private int MaxNumberOfPlayers;
	private int MinNumberOfPlayers;

	public Game(String name, String description) {
		this.GameID = GameIdGenerator.getID();
		this.name = name;
		this.description = description;
	}

	public long getGameID() {
		return GameID;
	}

	public int getMinNumberOfPlayers() {
		return MinNumberOfPlayers;
	}

	public void setMinNumberOfPlayers(int minNumberOfPlayers) {
		MinNumberOfPlayers = minNumberOfPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxNumberOfPlayers() {
		return MaxNumberOfPlayers;
	}

	public void setMaxNumberOfPlayers(int MaxNumberOfPlayers) {
		this.MaxNumberOfPlayers = MaxNumberOfPlayers;
	}

}
