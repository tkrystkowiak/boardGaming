package com.capgemini.UserProfileAndRanking.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityListDao;
import com.capgemini.UserProfileAndRanking.services.PlayabilityManagingService;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityMapper;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityTO;

@Service
public class PlayabilityManagingServiceImpl implements PlayabilityManagingService {

	@Autowired
	AvailabilityListDao avListDao;

	@Autowired
	AvailabilityMapper avMapper;

	@Override
	public void addAvailabilityHours(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avListDao.addSingle(userId, av);
	}

	@Override
	public void deleteAvailabilityPeriod(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avListDao.deleteSingle(userId, av);
	}

	@Override
	public void editAvailabilityHours(long userId, AvailabilityTO avTO) {
		Availability av = avMapper.mapTOonEntity(avTO);
		avListDao.editAvailability(userId, av);
	}

	@Override
	public List<User> getUsersWithMatchingAvailability(long userId) {
		return null;
	}

}
