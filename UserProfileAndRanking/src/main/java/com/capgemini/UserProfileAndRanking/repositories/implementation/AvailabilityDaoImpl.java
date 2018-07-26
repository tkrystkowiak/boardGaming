package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.Hour;
import com.capgemini.UserProfileAndRanking.enitities.Status;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityDao;

@Repository
public class AvailabilityDaoImpl implements AvailabilityDao {

	List<Availability> avList = new ArrayList<Availability>();

	@Override
	public void addAvailability(Availability av) {

		avList.add(av);
	}

	@Override
	public Availability getAvailabilityByHours(long userID, Hour begin, Hour end) {

		List<Availability> userAvs = avList.stream()
				.filter(av -> userID == av.getUserID() && av.getBeginningHour() == begin && av.getFinishHour() == end)
				.collect(Collectors.toList());
		if (!userAvs.isEmpty()) {
			return userAvs.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void deleteAvailability(long userID, Availability av) {

		Availability avModified = getAvailabilityByHours(userID, av.getBeginningHour(), av.getFinishHour());
		avModified.setStatus(Status.CANCELLED);
		avModified.setComment(av.getComment());

	}

	@Override
	public void editAvailability(Availability av, Availability oldAv) {
		Availability avModified = getAvailabilityByHours(oldAv.getUserID(), oldAv.getBeginningHour(),
				oldAv.getFinishHour());
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

		if (firstStartTime.isAfter(secondStartTime.minusMinutes(30))
				&& firstStartTime.isBefore(secondEndTime.minusMinutes(30))) {
			if (firstEndTime.isAfter(secondEndTime.minusMinutes(30))
					&& firstEndTime.isBefore(secondEndTime.plusMinutes(30))) {
				return true;
			}
		}

		return false;
	}

}
