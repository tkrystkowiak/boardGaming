package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.UserProfileAndRanking.enitities.Stats;
import com.capgemini.UserProfileAndRanking.repositories.implementation.StatsDaoImpl;
import com.capgemini.UserProfileAndRanking.services.implementation.StatViewingServiceImpl;
import com.capgemini.UserProfileAndRanking.transferobjects.StatsMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.StatsTO;
import com.capgemini.UserProfileAndRanking.utils.Level;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatViewingServiceTest {

	@Autowired
	StatViewingServiceImpl statViewService;

	@Autowired
	StatsDaoImpl statsDao;

	@Autowired
	StatsMapper statsMapper;

	@Test
	public void shouldReturnSingleStatsObject() {
		statsDao.addStats(new Stats(Level.PEASANT, 10, 1000, 1));
		statsDao.addStats(new Stats(Level.IMPERATOR, 1000, 1, 2));
		StatsTO actual = statViewService.showStatistics(2);
		assertEquals(Level.IMPERATOR, actual.getLevel());
		assertEquals(1000, actual.getPoints());
	}

}
