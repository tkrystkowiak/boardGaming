package com.capgemini.UserProfileAndRanking.services;

import com.capgemini.UserProfileAndRanking.transferobjects.StatsTO;

public interface StatViewingService {

	public StatsTO showStatistics(long userId);

}
