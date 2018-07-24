package com.capgemini.UserProfileAndRanking.enitities;

import java.util.List;

public class AvailabilityList {

	private long userID;
	private List<Availability> availabilityList;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public List<Availability> getAvailabilityList() {
		return availabilityList;
	}

	public void setAvailabilityList(List<Availability> availabilityList) {
		this.availabilityList = availabilityList;
	}

}
