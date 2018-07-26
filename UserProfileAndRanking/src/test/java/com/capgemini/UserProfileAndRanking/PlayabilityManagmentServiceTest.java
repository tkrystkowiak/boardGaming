package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.Match;
import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.implementation.AvailabilityDaoImpl;
import com.capgemini.UserProfileAndRanking.repositories.implementation.MatchDaoImpl;
import com.capgemini.UserProfileAndRanking.repositories.implementation.UserDaoImpl;
import com.capgemini.UserProfileAndRanking.services.implementation.PlayabilityManagingServiceImpl;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;
import com.capgemini.UserProfileAndRanking.utils.Hour;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlayabilityManagmentServiceTest {

	@Autowired
	PlayabilityManagingServiceImpl playManagmentService;

	@Autowired
	AvailabilityDaoImpl avDAO;

	@Autowired
	UserDaoImpl userDao;

	@Autowired
	MatchDaoImpl matchDao;

	@Before
	public void initialize() {
		User albert = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		albert.setId(2);
		userDao.addUser(albert);
		User indiana = new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto");
		indiana.setId(4);
		userDao.addUser(indiana);
		avDAO.addAvailability(new Availability(1, Hour.H20_00, Hour.H22_00));
		avDAO.addAvailability(new Availability(2, Hour.H20_00, Hour.H22_00));
		avDAO.addAvailability(new Availability(3, Hour.H15_00, Hour.H17_00));
		avDAO.addAvailability(new Availability(4, Hour.H20_00, Hour.H22_00));
	}

	@Test
	public void shouldReturnListOfMatchingUsersTest() {

		List<UserTO> actual = playManagmentService.getUsersWithMatchingAvailability(1);
		assertEquals(2, actual.size());
	}

	@Test
	public void shouldCreateNewMatchesTest() {

		playManagmentService.getUsersWithMatchingAvailability(1);
		List<Match> actual = matchDao.getAllMatches();
		assertEquals(2, actual.size());
	}

}
