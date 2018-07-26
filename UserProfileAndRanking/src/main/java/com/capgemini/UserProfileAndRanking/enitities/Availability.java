package com.capgemini.UserProfileAndRanking.enitities;

public class Availability {

	private long userID;
	private Hour beginning;
	private Hour ending;
	private Status status;
	private String comment;

	public Availability(long userID, Hour beginningHour, Hour finishHour) {
		this.userID = userID;
		this.beginning = beginningHour;
		this.ending = finishHour;
		this.status = Status.VALID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public Hour getBeginningHour() {
		return beginning;
	}

	public void setBeginningHour(Hour beginningHour) {
		this.beginning = beginningHour;
	}

	public Hour getFinishHour() {
		return ending;
	}

	public void setFinishHour(Hour finishHour) {
		this.ending = finishHour;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
