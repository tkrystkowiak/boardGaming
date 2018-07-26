package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Match;
import com.capgemini.UserProfileAndRanking.repositories.MatchDao;

@Repository
public class MatchDaoImpl implements MatchDao {

	private List<Match> matches = new ArrayList<Match>();

	@Override
	public void add(Match match) {
		matches.add(match);
	}

	@Override
	public void creatAndAdd(List<Long> participants) {
		add(new Match(participants));

	}

	@Override
	public List<Match> getAllMatches() {

		return matches;
	}

}
