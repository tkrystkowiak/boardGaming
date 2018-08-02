package com.capgemini.UserProfileAndRanking.repositories;

import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;

public interface UserDao {

	public void addUser(User user);

	public List<User> findUsersByParams(String firstName, String lastName, String emails);

	public User findUserByID(long iD) throws NoSuchUserException;

	public void editUser(User user) throws NoSuchUserException;

}
