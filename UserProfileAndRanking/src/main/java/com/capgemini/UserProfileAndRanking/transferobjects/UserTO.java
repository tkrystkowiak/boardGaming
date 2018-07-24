package com.capgemini.UserProfileAndRanking.transferobjects;

import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.Game;

public class UserTO {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifemotto;
	private List<Game> gameList;

	public UserTO() {
	}

	public UserTO(int id, String firstName, String lastName, String email, String password, String lifemotto) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifemotto = lifemotto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLifemotto() {
		return lifemotto;
	}

	public void setLifemotto(String lifemotto) {
		this.lifemotto = lifemotto;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}

}
