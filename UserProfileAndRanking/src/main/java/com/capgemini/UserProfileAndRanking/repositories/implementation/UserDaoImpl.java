package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;

public class UserDaoImpl implements UserDao {
	
	private List<User> userDB;
	
		public UserDaoImpl(){
			userDB = new ArrayList<User>();
		}

	@Override
	public User findUserByName(String firstName, String lastName) {
		Iterator<User> itr = userDB.iterator();
		while(itr.hasNext()){
			User user = itr.next();
			if(user.getFirstName()==firstName||user.getLastName()==lastName){
				return user;
			}
		}
		return null;
	}

	@Override
	public User findUserByID(int ID) {
		return null;
	}

	@Override
	public void addUser(User user) {
		
		userDB.add(user);
		
	}

	@Override
	public void deleteUser(User user) {
		
		userDB.remove(user);
		
	}
	
	
	

}
