package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.repositories.implementation.UserDaoImpl;
import com.capgemini.UserProfileAndRanking.services.implementation.UserEditServiceImpl;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEditServiceTest {

	@Autowired
	private UserEditServiceImpl uService;

	@Autowired
	private UserDaoImpl userDao;

	User Albert;
	User Indiana;
	UserTO Ramzes;

	@Before
	public void initializeUsers() {
		Albert = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		Indiana = new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto");
		Ramzes = new UserTO(1, "Ramzes", "Second", "ramzes@second.com", "ramsec123", "This is Ramsec's motto");
	}

	@Test
	public void showProfileTest() throws NoSuchUserException {
		userDao.addUser(Albert);
		userDao.addUser(Indiana);
		UserTO actual = uService.showProfile(2);
		assertEquals("Indiana", actual.getFirstName());
	}

	@Test
	public void showProfileAfterUserEditTest() throws NoSuchUserException {
		uService.editProfile(Ramzes);
		UserTO actual = uService.showProfile(1);
		assertEquals("Ramzes", actual.getFirstName());
		assertEquals("Second", actual.getLastName());
	}

}
