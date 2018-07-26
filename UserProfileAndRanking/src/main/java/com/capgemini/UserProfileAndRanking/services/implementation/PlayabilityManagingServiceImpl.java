package com.capgemini.UserProfileAndRanking.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityDao;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;
import com.capgemini.UserProfileAndRanking.services.PlayabilityManagingService;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityTO;

@Service
public class PlayabilityManagingServiceImpl implements PlayabilityManagingService {

	@Autowired
	AvailabilityDao avDao;

	@Autowired
	UserDao userDao;

	@Autowired
	AvailabilityMapper avMapper;

	@Override
	public void addAvailabilityHours(AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avDao.addAvailability(av);
	}

	@Override
	public void deleteAvailabilityPeriod(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avDao.deleteSingle(userId, av);
	}

	@Override
	public void editAvailabilityHours(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avDao.editAvailability(userId, av);
	}

	@Override
	public List<User> getUsersWithMatchingAvailability(long userId) {
		Set<Long> matchingUsersIds = avDao.getMatchingAvailability(userId);
		List<User> matchingUsers = new ArrayList<User>();
		matchingUsersIds.forEach(uId -> matchingUsers.add(userDao.findUserByID(uId)));
		return matchingUsers;
	}

}
