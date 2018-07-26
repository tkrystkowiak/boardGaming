package com.capgemini.UserProfileAndRanking.enitities;

import java.util.concurrent.atomic.AtomicLong;

public class UserIdGenerator {

	private static AtomicLong id = new AtomicLong(1);

	public static long getID() {
		return id.getAndIncrement();
	}

}
