package com.capgemini.UserProfileAndRanking.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.User;

@Repository
public interface UserDao {
	
	public User findUserByName(String firstName,String lastName);
	
	public User findUserByID(int ID);
	
	public void EditUser(User user);
	
}
