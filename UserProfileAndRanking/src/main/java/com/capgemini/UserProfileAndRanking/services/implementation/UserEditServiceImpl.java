package com.capgemini.UserProfileAndRanking.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;
import com.capgemini.UserProfileAndRanking.services.UserEditService;
import com.capgemini.UserProfileAndRanking.transferobjects.UserMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@Service
public class UserEditServiceImpl implements UserEditService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserTO showProfile(long id) throws NoSuchUserException {
		User user = userDao.findUserByID(id);
		return UserMapper.mapEntityOnTO(user);

	}

	@Override
	public void editProfile(UserTO userTO) throws NoSuchUserException {
		userDao.editUser(userMapper.mapTOonEntity(userTO));
	}

	@Override
	public List<UserTO> showProfileByParams(String firstName, String lastName, String email) {
		List<User> users = userDao.findUsersByParams(firstName, lastName, email);
		List<UserTO> mappedUsers = new ArrayList<>();
		users.forEach(user -> mappedUsers.add(UserMapper.mapEntityOnTO(user)));
		return mappedUsers;
	}

}
