package com.capgemini.UserProfileAndRanking.transferobjects;

import org.springframework.stereotype.Component;

import com.capgemini.UserProfileAndRanking.enitities.Availability;

@Component
public class AvailabilityMapper {

	public Availability mapTOonEntity(AvailabilityTO avTO) {

		Availability av = new Availability(avTO.getUserID(), avTO.getBeginningHour(), avTO.getFinishHour());
		av.setComment(avTO.getComment());
		av.setStatus(avTO.getStatus());
		return av;

	}

	public AvailabilityTO mapEntityOnTO(Availability av) {

		AvailabilityTO avTO = new AvailabilityTO(av.getUserID(), av.getBeginningHour(), av.getFinishHour());
		avTO.setComment(av.getComment());
		avTO.setStatus(av.getStatus());
		return avTO;

	}

}
