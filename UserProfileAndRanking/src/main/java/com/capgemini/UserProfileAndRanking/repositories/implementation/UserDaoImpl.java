package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	private List<User> userDB = new ArrayList<User>();

	@Override
	public void addUser(User user) {
		userDB.add(user);
	}

	@Override
	public User findUserByName(String firstName, String lastName) {
		Iterator<User> itr = userDB.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getFirstName().equals(firstName) || user.getLastName().equals(lastName)) {
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
	public void editUser(User user) {
		User modifiedUser = findUserByID(user.getId());
		Iterator<User> itr = userDB.iterator();
		for (int i = 0; i < userDB.size(); i++) {
			if (userDB.get(i).getId() == user.getId()) {
				userDB.set(i, user);
				break;
			}
		}
	}

}
