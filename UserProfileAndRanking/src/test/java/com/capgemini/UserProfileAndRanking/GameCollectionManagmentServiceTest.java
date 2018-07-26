package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.UserProfileAndRanking.enitities.Game;
import com.capgemini.UserProfileAndRanking.repositories.GameCollectionDao;
import com.capgemini.UserProfileAndRanking.repositories.GameDao;
import com.capgemini.UserProfileAndRanking.services.implementation.GameCollectionManagmentServiceImpl;
import com.capgemini.UserProfileAndRanking.transferobjects.GameMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.GameTO;

@RunWith(MockitoJUnitRunner.class)
public class GameCollectionManagmentServiceTest {

	@InjectMocks
	private GameCollectionManagmentServiceImpl GameColService;

	@Mock
	private GameCollectionDao gameCollectionDao;

	@Mock
	private GameDao gameDao;

	@Mock
	private GameMapper gameMapper;

	@Test
	public void isShowingCorrectGamesTest() {
		List<Long> gameIDs = new ArrayList<Long>();
		gameIDs.add((long) 1);
		gameIDs.add((long) 2);
		List<Game> games = new ArrayList<Game>();
		Game Chess = new Game("Chess", "Chess-description");
		Game Munchkin = new Game("Munchkin", "Munchkin-description");
		GameTO ChessTO = new GameTO("Chess", "Chess-description");
		GameTO MunchkinTO = new GameTO("Munchkin", "Munchkin-description");
		games.add(Chess);
		games.add(Munchkin);
		when(gameCollectionDao.getUsersGamesIds(1)).thenReturn(gameIDs);
		when(gameDao.getListOfGamesByIds(gameIDs)).thenReturn(games);
		when(gameMapper.mapEntityOnTO(Chess)).thenReturn(ChessTO);
		when(gameMapper.mapEntityOnTO(Munchkin)).thenReturn(MunchkinTO);
		List<GameTO> actual = GameColService.showGamesCollection(1);
		assertEquals(2, actual.size());
		assertEquals("Chess", actual.get(0).getName());
		assertEquals("Munchkin", actual.get(1).getName());
	}

	@Test
	public void shouldGetListOfAllGamesTest() {
		List<Game> games = new ArrayList<Game>();
		Game Chess = new Game("Chess", "Chess-description");
		Game Munchkin = new Game("Munchkin", "Munchkin-description");
		GameTO ChessTO = new GameTO("Chess", "Chess-description");
		GameTO MunchkinTO = new GameTO("Munchkin", "Munchkin-description");
		games.add(Chess);
		games.add(Munchkin);
		when(gameDao.getAllGames()).thenReturn(games);
		when(gameMapper.mapEntityOnTO(Chess)).thenReturn(ChessTO);
		when(gameMapper.mapEntityOnTO(Munchkin)).thenReturn(MunchkinTO);
		List<GameTO> actual = GameColService.showAllGames();
		assertEquals(2, actual.size());
		assertEquals("Chess", actual.get(0).getName());
		assertEquals("Munchkin", actual.get(1).getName());
	}

}
