package com.capgemini.UserProfileAndRanking.services;

import java.util.List;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.transferobjects.AvailabilityTO;

public interface PlayabilityManagingService {

	public void addAvailabilityHours(AvailabilityTO avTO);

	public void deleteAvailabilityPeriod(long userId, AvailabilityTO avTO);

	public void editAvailabilityHours(long userId, AvailabilityTO avTO);

	public List<User> getUsersWithMatchingAvailability(long userId);

}
