package com.capgemini.UserProfileAndRanking.transferobjects;

import org.springframework.stereotype.Component;

import com.capgemini.UserProfileAndRanking.enitities.User;

@Component
public class UserMapper {

	public static User mapTOonEntity(UserTO userTO) {

		User user = new User();
		user.setId(userTO.getId());
		user.setFirstName(userTO.getFirstName());
		user.setLastName(userTO.getLastName());
		user.setEmail(userTO.getEmail());
		user.setLifemotto(userTO.getLifemotto());
		user.setGameList(userTO.getGameList());

		return user;

	}

	public static UserTO mapEntityOnTO(User user) {

		UserTO userTO = new UserTO();
		userTO.setId(user.getId());
		userTO.setFirstName(user.getFirstName());
		userTO.setLastName(user.getLastName());
		userTO.setEmail(user.getEmail());
		userTO.setLifemotto(user.getLifemotto());
		userTO.setGameList(user.getGameList());

		return userTO;

	}

}
