package com.capgemini.UserProfileAndRanking.repositories;

import com.capgemini.UserProfileAndRanking.enitities.Stats;

public interface StatsDao {

	public void addStats(Stats stats);

	public Stats getStatsByUserId(long userId);

}
