package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.capgemini.UserProfileAndRanking.repositories.implementation.GameCollectionDaoImpl;

public class GameCollectionDaoTest {

	@Test
	public void isSizeOfUsersGameListCorrectAfterAdding() {
		GameCollectionDaoImpl gameColDao = new GameCollectionDaoImpl();
		gameColDao.addGame(1, 1);
		gameColDao.addGame(1, 2);
		gameColDao.addGame(1, 3);
		List<Long> games = gameColDao.getUsersGamesIds(1);
		assertEquals(3, games.size());
	}

	@Test
	public void isSizeOfUsersGameListCorrectAfterRemoving() {
		GameCollectionDaoImpl gameColDao = new GameCollectionDaoImpl();
		gameColDao.addGame(1, 1);
		gameColDao.addGame(1, 2);
		gameColDao.addGame(1, 3);
		gameColDao.removeGame(1, 2);
		List<Long> games = gameColDao.getUsersGamesIds(1);
		assertEquals(2, games.size());
	}

}
