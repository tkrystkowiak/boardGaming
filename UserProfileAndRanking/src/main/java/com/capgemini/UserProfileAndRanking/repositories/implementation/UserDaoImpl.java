package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;

public class UserDaoImpl implements UserDao {

	private List<User> userDB;

	public UserDaoImpl() {
		userDB = new ArrayList<User>();
	}

	@Override
	public User findUserByName(String firstName, String lastName) {
		Iterator<User> itr = userDB.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getFirstName() == firstName || user.getLastName() == lastName) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findUserByID(long id) {
		Iterator<User> itr = userDB.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void EditUser(User user) {

	}

}
