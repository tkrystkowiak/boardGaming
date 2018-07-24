package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.Match;
import com.capgemini.UserProfileAndRanking.repositories.MatchDao;

public class MatchDaoImpl implements MatchDao {

	private List<Match> matches = new ArrayList<Match>();

	@Override
	public void add(Match match) {
		matches.add(match);
	}

}
