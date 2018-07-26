package com.capgemini.UserProfileAndRanking.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityDao;
import com.capgemini.UserProfileAndRanking.repositories.MatchDao;
import com.capgemini.UserProfileAndRanking.repositories.UserDao;
import com.capgemini.UserProfileAndRanking.services.PlayabilityManagingService;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityTO;
import com.capgemini.UserProfileAndRanking.transferobjects.UserMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@Service
public class PlayabilityManagingServiceImpl implements PlayabilityManagingService {

	@Autowired
	AvailabilityDao avDao;

	@Autowired
	UserDao userDao;

	@Autowired
	AvailabilityMapper avMapper;

	@Autowired
	MatchDao matchDao;

	@Override
	public void addAvailabilityHours(AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avDao.addAvailability(av);
	}

	@Override
	public void deleteAvailabilityPeriod(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avDao.deleteAvailability(userId, av);
	}

	@Override
	public void editAvailabilityHours(AvailabilityTO avTO, AvailabilityTO oldAvTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		Availability oldAv = avMapper.mapTOonEntity(oldAvTO);
		avDao.editAvailability(av, oldAv);
	}

	@Override
	public List<UserTO> getUsersWithMatchingAvailability(long userId) {
		Set<Long> matchingUsersIds = avDao.getMatchingAvailability(userId);
		List<UserTO> matchingUsers = new ArrayList<UserTO>();
		for (long matchUserId : matchingUsersIds) {
			List<Long> participants = new ArrayList<Long>();
			participants.add(userId);
			participants.add(matchUserId);
			matchDao.creatAndAdd(participants);
			matchingUsers.add(UserMapper.mapEntityOnTO(userDao.findUserByID(matchUserId)));
		}
		return matchingUsers;
	}

}
