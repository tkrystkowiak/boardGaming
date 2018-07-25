package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.Stats;
import com.capgemini.UserProfileAndRanking.repositories.StatsDao;

public class StatsDaoImpl implements StatsDao {

	List<Stats> statlist = new ArrayList<Stats>();

	@Override
	public Stats getStatsByUserId(long userId) {

		Iterator<Stats> itr = statlist.iterator();
		while (itr.hasNext()) {
			Stats stats = itr.next();
			if (stats.getUserID() == userId) {
				return stats;
			}
		}
		return null;

	}

}
