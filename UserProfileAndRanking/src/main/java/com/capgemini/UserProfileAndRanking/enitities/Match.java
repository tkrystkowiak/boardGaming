package com.capgemini.UserProfileAndRanking.enitities;

import java.util.Date;
import java.util.List;

public class Match {
	
	private List<User> participants;
	private Game gamePlayed;
	private User winner;
	private Date dateOfMatch;
	
	public List<User> getParticipants() {
		return participants;
	}
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
	public Game getGamePlayed() {
		return gamePlayed;
	}
	public void setGamePlayed(Game gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	public User getWinner() {
		return winner;
	}
	public void setWinner(User winner) {
		this.winner = winner;
	}
	public Date getDateOfMatch() {
		return dateOfMatch;
	}
	public void setDateOfMatch(Date dateOfMatch) {
		this.dateOfMatch = dateOfMatch;
	}
	
	
}
