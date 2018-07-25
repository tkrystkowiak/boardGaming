package com.capgemini.UserProfileAndRanking.repositories.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.AvailabilityList;
import com.capgemini.UserProfileAndRanking.enitities.Hour;
import com.capgemini.UserProfileAndRanking.enitities.Status;
import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.repositories.AvailabilityListDao;

public class AvailabilityListDaoImpl implements AvailabilityListDao {

	Map<Long, AvailabilityList> avMap = new HashMap<Long, AvailabilityList>();

	@Override
	public void addList(User user, AvailabilityList avaiList) {

		avMap.put(user.getId(), avaiList);

	}

	@Override
	public void addSingle(long userId, Availability avai) {
		if (avMap.containsKey(userId)) {
			AvailabilityList modifiedList = avMap.get(userId);
			modifiedList.getAvailabilityList().add(avai);
		} else {
			avMap.put(userId, new AvailabilityList());
			AvailabilityList modifiedList = avMap.get(userId);
			modifiedList.getAvailabilityList().add(avai);
		}
	}

	@Override
	public Availability getSingleByHours(long userID, Hour begin, Hour end) {

		List<AvailabilityList> userAvs = avMap.values().stream().filter(x -> userID == x.getUserID())
				.collect(Collectors.toList());

		AvailabilityList avList = userAvs.get(0);

		List<Availability> filteredAvList = avList.getAvailabilityList().stream()
				.filter(x -> begin == x.getBeginningHour() && end == x.getFinishHour()).collect(Collectors.toList());

		return filteredAvList.get(0);

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

}
