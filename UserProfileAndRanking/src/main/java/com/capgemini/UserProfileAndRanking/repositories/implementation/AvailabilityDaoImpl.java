package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.Hour;
import com.capgemini.UserProfileAndRanking.enitities.Status;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityDao;

public class AvailabilityDaoImpl implements AvailabilityDao {

	List<Availability> avList = new ArrayList<Availability>();

	@Override
	public void addAvailability(Availability avai) {

		avList.add(avai);
	}

	@Override
	public Availability getSingleByHours(long userID, Hour begin, Hour end) {

		List<Availability> userAvs = avList.stream()
				.filter(av -> userID == av.getUserID() && av.getBeginningHour() == begin && av.getFinishHour() == end)
				.collect(Collectors.toList());

		return userAvs.get(0);

	}

	@Override
	public void deleteSingle(long userID, Availability av) {

		Availability avModified = getSingleByHours(userID, av.getBeginningHour(), av.getFinishHour());
		av.setStatus(Status.CANCELLED);
		av.setComment(av.getComment());

	}

	@Override
	public void editAvailability(long userId, Availability av) {
		Availability avModified = getSingleByHours(userId, av.getBeginningHour(), av.getFinishHour());
		avModified.setBeginningHour(av.getBeginningHour());
		avModified.setFinishHour(av.getFinishHour());
	}

	@Override
	public Set<Long> getMatchingAvailability(long userId) {
		Set<Long> matchingUsers = new HashSet<Long>();
		List<Availability> userAvs = avList.stream().filter(x -> userId == x.getUserID()).collect(Collectors.toList());
		for (Availability av : userAvs) {
			for (Availability matchingAv : avList) {
				if (av.getUserID() != matchingAv.getUserID() && isPeriodMatching(av, matchingAv)) {
					matchingUsers.add(matchingAv.getUserID());
				}
			}
		}
		return matchingUsers;
	}

	private boolean isPeriodMatching(Availability first, Availability second) {
		LocalTime firstStartTime = first.getBeginningHour().toLocalTime();
		LocalTime firstEndTime = first.getFinishHour().toLocalTime();
		LocalTime secondStartTime = second.getBeginningHour().toLocalTime();
		LocalTime secondEndTime = second.getFinishHour().toLocalTime();

		if (firstStartTime.isAfter(secondStartTime) && firstEndTime.isBefore(secondEndTime)) {
			return true;
		}
		if (secondStartTime.isAfter(firstStartTime) && secondEndTime.isBefore(firstEndTime)) {
			return true;
		}
		return false;
	}

}
