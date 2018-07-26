package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.UserProfileAndRanking.enitities.User;
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
	User Luke;
	User Micheal;
	User Van;
	UserTO Ramzes;

	@Before
	public void initializeUsers() {
		Albert = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		Indiana = new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto");
		Luke = new User("Luke", "Skywalker", "luke@skywalker.com", "luksky123", "This is Luke's motto");
		Micheal = new User("Micheal", "Blomkvist", "micheal@blomkvist.com", "micblo123", "This is Micheal's motto");
		Van = new User("Van", "Helsing", "van@helsing.com", "vanhel123", "This is Van's motto");
		Ramzes = new UserTO(1, "Ramzes", "Second", "ramzes@second.com", "ramsec123", "This is Ramsec's motto");
	}

	@Test
	public void showProfileTest() {
		userDao.addUser(Albert);
		userDao.addUser(Indiana);
		UserTO actual = uService.showProfile(2);
		assertEquals("Indiana", actual.getFirstName());
	}

	@Test
	public void showProfileAfterUserEditTest() {
		uService.editProfile(Ramzes);
		UserTO actual = uService.showProfile(1);
		assertEquals("Ramzes", actual.getFirstName());
		assertEquals("Second", actual.getLastName());
	}

}
