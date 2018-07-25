package com.capgemini.UserProfileAndRanking.enitities;

import java.util.List;

public class Stats {

	private Level level;
	private int points;
	private int rankingPosition;
	private List<Match> matchesHistory;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRankingPosition() {
		return rankingPosition;
	}

	public void setRankingPosition(int rankingPosition) {
		this.rankingPosition = rankingPosition;
	}

	public List<Match> getMatchesHistory() {
		return matchesHistory;
	}

	public void setMatchesHistory(List<Match> matchesHistory) {
		this.matchesHistory = matchesHistory;
	}

}
