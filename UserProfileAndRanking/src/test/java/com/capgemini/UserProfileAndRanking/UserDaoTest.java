package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.implementation.UserDaoImpl;

public class UserDaoTest {

	@Test
	public void shouldFindAddedUserTest() {
		UserDaoImpl userDao = new UserDaoImpl();
		User expected = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		userDao.addUser(expected);
		User actual = userDao.findUserByID(expected.getId());
		assertEquals(expected, actual);
	}

	@Test
	public void shouldModifyAddedUserTest() {
		UserDaoImpl userDao = new UserDaoImpl();
		User added = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		userDao.addUser(added);
		User expected = new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto");
		expected.setId(added.getId());
		userDao.editUser(expected);
		User actual = userDao.findUserByID(added.getId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
	}

}
