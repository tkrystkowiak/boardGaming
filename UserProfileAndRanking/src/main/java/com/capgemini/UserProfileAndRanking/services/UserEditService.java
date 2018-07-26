package com.capgemini.UserProfileAndRanking.services;

import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@Service
public interface UserEditService {

	public UserTO showProfile(long id);

	public void editProfile(UserTO userTO);

}
