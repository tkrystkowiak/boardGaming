package com.capgemini.UserProfileAndRanking.enitities;

public class Availability {

	private Hour beginningHour;
	private Hour finishHour;
	private Status status;
	private String comment;

	public Availability(Hour beginningHour, Hour finishHour) {
		this.beginningHour = beginningHour;
		this.finishHour = finishHour;
		this.status = Status.VALID;
	}

	public Hour getBeginningHour() {
		return beginningHour;
	}

	public void setBeginningHour(Hour beginningHour) {
		this.beginningHour = beginningHour;
	}

	public Hour getFinishHour() {
		return finishHour;
	}

	public void setFinishHour(Hour finishHour) {
		this.finishHour = finishHour;
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
