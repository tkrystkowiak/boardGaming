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

	public UserTO showProfile(long id) {
		User user = userDao.findUserByID(id);
		return UserMapper.mapEntityOnTO(user);

	}

	public void editProfile(UserTO userTO) {
		userDao.editUser(userMapper.mapTOonEntity(userTO));
	}

	public void changeFirstName(long ID, String firstName) {

		User editedUser = userDao.findUserByID(ID);
		editedUser.setFirstName(firstName);

	}

	public void changeLastName(long ID, String lastName) {

		User editedUser = userDao.findUserByID(ID);
		editedUser.setLastName(lastName);

	}

	public void changeEmail(long ID, String email) {

		User editedUser = userDao.findUserByID(ID);
		editedUser.setEmail(email);

	}

	public void changeLifemotto(long ID, String lifemotto) {

		User editedUser = userDao.findUserByID(ID);
		editedUser.setLifemotto(lifemotto);

	}

	public void changePassword(long ID, String password) {

		User editedUser = userDao.findUserByID(ID);
		editedUser.setPassword(password);

	}

}
