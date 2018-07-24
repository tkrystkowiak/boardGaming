package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.UserProfileAndRanking.enitities.GameList;
import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.GameListDao;

public class GameListDaoImpl implements GameListDao {
	
	private Map<Integer,GameList> gameListMap = new HashMap<Integer,GameList>();

	@Override
	public GameList getUserGameList(User user) {
		
		return gameListMap.get(user.getId());
		
	}

}
