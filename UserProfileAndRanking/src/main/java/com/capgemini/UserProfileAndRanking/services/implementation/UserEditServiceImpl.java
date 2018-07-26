package com.capgemini.UserProfileAndRanking.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.User;
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
	public UserTO showProfile(long id) {
		User user = userDao.findUserByID(id);
		return UserMapper.mapEntityOnTO(user);

	}

	@Override
	public void editProfile(UserTO userTO) {
		userDao.editUser(userMapper.mapTOonEntity(userTO));
	}

}
