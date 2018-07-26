package com.capgemini.UserProfileAndRanking.transferobjects;

import org.springframework.stereotype.Component;

import com.capgemini.UserProfileAndRanking.enitities.Stats;

@Component
public class StatsMapper {

	public Stats mapTOonEntity(StatsTO statsTO) {

		Stats stats = new Stats(statsTO.getLevel(), statsTO.getPoints(), statsTO.getRankingPosition(),
				statsTO.getUserID());
		stats.setMatchesHistory(statsTO.getMatchesHistory());
		return stats;

	}

	public StatsTO mapEntityOnTO(Stats stats) {

		StatsTO statsTO = new StatsTO(stats.getLevel(), stats.getPoints(), stats.getRankingPosition(),
				stats.getUserID());
		statsTO.setMatchesHistory(stats.getMatchesHistory());
		return statsTO;

	}

}
