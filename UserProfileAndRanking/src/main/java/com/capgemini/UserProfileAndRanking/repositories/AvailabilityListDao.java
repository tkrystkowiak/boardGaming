package com.capgemini.UserProfileAndRanking.repositories;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.AvailabilityList;
import com.capgemini.UserProfileAndRanking.enitities.Hour;
import com.capgemini.UserProfileAndRanking.enitities.User;

public interface AvailabilityListDao {

	public void addList(User user, AvailabilityList avaiList);

	public void addSingle(long userId, Availability av);

	public Availability getSingleByHours(long userId, Hour begin, Hour end);

	public void deleteSingle(long userId, Availability av);

	public void editAvailability(long userId, Availability av);

}
