package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.UserProfileAndRanking.enitities.Stats;
import com.capgemini.UserProfileAndRanking.repositories.StatsDao;

public class StatsDaoImpl implements StatsDao {

	Map<Integer,Stats> statMap = new HashMap<Integer,Stats>();
	
	
}
