package com.capgemini.UserProfileAndRanking.enitities;

import java.util.Date;
import java.util.List;

public class Match {

	private List<Long> participants;
	private Game gamePlayed;
	private long winner;
	private Date dateOfMatch;

	public Match(List<Long> participants) {
		this.participants = participants;
	}

	public List<Long> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Long> participants) {
		this.participants = participants;
	}

	public Game getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(Game gamePlayed) {
		this.gamePlayed = gamePlayed;
	}

	public long getWinner() {
		return winner;
	}

	public void setWinner(long winner) {
		this.winner = winner;
	}

	public Date getDateOfMatch() {
		return dateOfMatch;
	}

	public void setDateOfMatch(Date dateOfMatch) {
		this.dateOfMatch = dateOfMatch;
	}

}
