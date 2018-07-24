package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.capgemini.UserProfileAndRanking.enitities.Game;
import com.capgemini.UserProfileAndRanking.repositories.GameDao;

public class GameDaoImpl implements GameDao {
	
	private List<Game> gamesDB;
	
	private GameDaoImpl() {
		gamesDB = new ArrayList<Game>();
	}

	@Override
	public boolean addGame(Game game) {
		
		if(isGameAlreadyIn(game.getName())){
			return false;
		}
		gamesDB.add(game);
		return true;
		
	}

	@Override
	public Game findGame(String name) {
		
		Iterator<Game> itr = gamesDB.iterator();
		while(itr.hasNext()){
			Game game = itr.next();
			if(game.getName()==name){
				return game;
			}
		}
		return null;
	}
	
	private boolean isGameAlreadyIn(String name){
		Iterator<Game> itr = gamesDB.iterator();
		while(itr.hasNext()){
			Game game = itr.next();
			if(game.getName()==name){
				return true;
			}
		}
		return false;
	}

}
