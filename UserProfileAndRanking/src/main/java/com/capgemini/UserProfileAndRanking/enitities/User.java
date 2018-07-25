package com.capgemini.UserProfileAndRanking.enitities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifemotto;
	private List<Game> gameList;

	public User() {
	}

	public User(String firstName, String lastName, String email, String password, String lifemotto) {
		this.id = UserIdGenerator.getID();
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

	public void addGame(Game game) {
		this.gameList.add(game);
	}

}
