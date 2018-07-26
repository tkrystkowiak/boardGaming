package com.capgemini.UserProfileAndRanking.repositories;

import com.capgemini.UserProfileAndRanking.enitities.User;

public interface UserDao {

	public void addUser(User user);

	public User findUserByName(String firstName, String lastName);

	public User findUserByID(long iD);

	public void editUser(User user);

}
