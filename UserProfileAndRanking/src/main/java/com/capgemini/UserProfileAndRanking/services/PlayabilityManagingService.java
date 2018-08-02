package com.capgemini.UserProfileAndRanking.services;

import java.util.List;

import com.capgemini.UserProfileAndRanking.exceptions.NoSuchUserException;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityTO;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

public interface PlayabilityManagingService {

	public void addAvailabilityHours(AvailabilityTO avTO);

	public void deleteAvailabilityPeriod(long userId, AvailabilityTO avTO);

	public void editAvailabilityHours(AvailabilityTO avTO, AvailabilityTO oldAvTO);

	public List<UserTO> getUsersWithMatchingAvailability(long userId) throws NoSuchUserException;

}
