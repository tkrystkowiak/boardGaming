package com.capgemini.UserProfileAndRanking.repositories;

import java.util.Set;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.utils.Hour;

public interface AvailabilityDao {

	public void addAvailability(Availability av);

	public Availability getAvailabilityByHours(long userId, Hour begin, Hour end);

	public void deleteAvailability(long userId, Availability av);

	public void editAvailability(Availability av, Availability oldAv);

	public Set<Long> getMatchingAvailability(long userId);

}
