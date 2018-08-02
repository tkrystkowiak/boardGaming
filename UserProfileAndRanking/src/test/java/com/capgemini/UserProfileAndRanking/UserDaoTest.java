package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.repositories.implementation.UserDaoImpl;

public class UserDaoTest {

	@Test
	public void shouldFindAddedUserTest() throws NoSuchUserException {
		UserDaoImpl userDao = new UserDaoImpl();
		User expected = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		userDao.addUser(expected);
		User actual = userDao.findUserByID(expected.getId());
		assertEquals(expected, actual);
	}

	@Test
	public void shouldFindUserByParamsTest() {
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> actual = userDao.findUsersByParams("Albert", "Einstein", "albert@email.com");
		assertEquals("Albert", actual.get(0).getFirstName());
	}

	@Test
	public void shouldModifyAddedUserTest() throws NoSuchUserException {
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
