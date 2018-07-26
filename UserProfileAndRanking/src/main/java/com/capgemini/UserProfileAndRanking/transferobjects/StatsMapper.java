package com.capgemini.UserProfileAndRanking.transferobjects;

import org.springframework.stereotype.Component;

import com.capgemini.UserProfileAndRanking.enitities.Stats;

@Component
public class StatsMapper {

	public Stats mapTOonEntity(StatsTO statsTO) {

		Stats stats = new Stats();
		stats.setUserID(statsTO.getUserID());
		stats.setLevel(statsTO.getLevel());
		stats.setRankingPosition(statsTO.getRankingPosition());
		stats.setPoints(statsTO.getPoints());
		stats.setMatchesHistory(statsTO.getMatchesHistory());
		return stats;

	}

	public StatsTO mapEntityOnTO(Stats stats) {

		StatsTO statsTO = new StatsTO();
		statsTO.setUserID(stats.getUserID());
		statsTO.setLevel(stats.getLevel());
		statsTO.setRankingPosition(stats.getRankingPosition());
		statsTO.setPoints(stats.getPoints());
		statsTO.setMatchesHistory(stats.getMatchesHistory());
		return statsTO;

	}

}
