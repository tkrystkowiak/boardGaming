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
		initialize();
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

	private void initialize() {
		userDB.add(new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto"));
		userDB.add(new User("Luke", "Skywalker", "luke@skywalker.com", "luksky123", "This is Luke's motto"));
		userDB.add(new User("Micheal", "Blomkvist", "micheal@blomkvist.com", "micblo123", "This is Micheal's motto"));
		userDB.add(new User("Van", "Helsing", "van@helsing.com", "vanhel123", "This is Van's motto"));
		userDB.add(new User("Ramzes", "Second", "ramzes@second.com", "ramsec123", "This is Ramsec's motto"));
	}
}
