package com.capgemini.UserProfileAndRanking.repositories;

import java.util.Set;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.Hour;

public interface AvailabilityDao {

	public void addAvailability(Availability av);

	public Availability getSingleByHours(long userId, Hour begin, Hour end);

	public void deleteSingle(long userId, Availability av);

	public void editAvailability(long userId, Availability av);

	public Set<Long> getMatchingAvailability(long userId);

}
