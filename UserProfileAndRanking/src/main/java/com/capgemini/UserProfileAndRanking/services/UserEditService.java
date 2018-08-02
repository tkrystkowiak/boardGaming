package com.capgemini.UserProfileAndRanking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@Service
public interface UserEditService {

	public UserTO showProfile(long id) throws NoSuchUserException;

	public void editProfile(UserTO userTO) throws NoSuchUserException;

	public List<UserTO> showProfileByParams(String firstname, String lastname, String email) throws NoSuchUserException;

}
