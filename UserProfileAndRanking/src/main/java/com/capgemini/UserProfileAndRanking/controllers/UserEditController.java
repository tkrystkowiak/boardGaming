package com.capgemini.UserProfileAndRanking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.services.UserEditService;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@RestController
public class UserEditController {

	@Autowired
	UserEditService userService;

	@RequestMapping(value = "/userById", method = RequestMethod.GET)
	public UserTO searchUserById(@RequestParam(value = "id", defaultValue = "1") long id) throws NoSuchUserException {
		return userService.showProfile(id);
	}

	@RequestMapping(value = "/userByParams", method = RequestMethod.GET)
	public List<UserTO> searchUserByParams(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "email", required = false) String email) throws NoSuchUserException {
		return userService.showProfileByParams(firstName, lastName, email);
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@RequestBody UserTO user) throws NoSuchUserException {
		userService.editProfile(user);
		return "user edited";
	}

}
