package com.capgemini.UserProfileAndRanking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.UserProfileAndRanking.enitities.GameList;
import com.capgemini.UserProfileAndRanking.enitities.User;

public interface GameListDao {
	
	public GameList getUserGameList(User user);
	
}
