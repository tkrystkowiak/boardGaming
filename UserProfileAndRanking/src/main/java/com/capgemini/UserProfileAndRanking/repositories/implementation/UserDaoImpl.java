package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	private List<User> userDB = new ArrayList<User>();

	public UserDaoImpl() {
		User Albert = new User("Albert", "Einstein", "albert@email.com", "password", "life is great");
		User Indiana = new User("Indiana", "Jones", "indiana@jones.com", "indjon123", "This is Indiana's motto");
		User Albert2 = new User("Albert", "Tolkien", "tolkien@email.com", "passhaslo", "life is not that great");
		userDB.add(Albert);
		userDB.add(Indiana);
		userDB.add(Albert2);
	}

	@Override
	public void addUser(User user) {
		userDB.add(user);
	}

	@Override
	public List<User> findUsersByParams(String firstName, String lastName, String email) {
		return filterByEmail(filterByLastName(filterByFirstName(userDB, firstName), lastName), email);
	}

	@Override
	public User findUserByID(long id) throws NoSuchUserException {
		Iterator<User> itr = userDB.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				return user;
			}
		}
		throw new NoSuchUserException();
	}

	@Override
	public void editUser(User user) throws NoSuchUserException {
		User modifiedUser = findUserByID(user.getId());
		Iterator<User> itr = userDB.iterator();
		for (int i = 0; i < userDB.size(); i++) {
			if (userDB.get(i).getId() == user.getId()) {
				userDB.set(i, user);
				break;
			}
		}
	}

	private List<User> filterByFirstName(List<User> users, String firstName) {
		if (firstName == null) {
			return users;
		}
		List<User> filteredUsers = users.stream().filter(user -> user.getFirstName().equals(firstName))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	private List<User> filterByLastName(List<User> users, String lastName) {
		if (lastName == null) {
			return users;
		}
		List<User> filteredUsers = users.stream().filter(user -> user.getLastName().equals(lastName))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	private List<User> filterByEmail(List<User> users, String email) {
		if (email == null) {
			return users;
		}
		List<User> filteredUsers = users.stream().filter(user -> user.getEmail().equals(email))
				.collect(Collectors.toList());
		return filteredUsers;
	}

}
