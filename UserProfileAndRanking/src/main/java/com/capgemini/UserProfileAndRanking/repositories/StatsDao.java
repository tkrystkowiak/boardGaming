package com.capgemini.UserProfileAndRanking.repositories;

import com.capgemini.UserProfileAndRanking.enitities.Stats;

public interface StatsDao {

	public Stats getStatsByUserId(long userId);

}
