package com.capgemini.UserProfileAndRanking.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.UserProfileAndRanking.repositories.StatsDao;
import com.capgemini.UserProfileAndRanking.services.StatViewingService;
import com.capgemini.UserProfileAndRanking.transferobjects.StatsMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.StatsTO;

public class StatViewingServiceImpl implements StatViewingService {

	@Autowired
	StatsDao statsDao;

	@Autowired
	StatsMapper statsMapper;

	@Override
	public StatsTO showStatistics(long userId) {

		StatsTO statsTO = statsMapper.mapEntityOnTO(statsDao.getStatsByUserId(userId));
		return statsTO;
	}

}
