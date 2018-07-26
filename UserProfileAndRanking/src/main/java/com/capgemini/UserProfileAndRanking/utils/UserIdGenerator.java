package com.capgemini.UserProfileAndRanking.utils;

import java.util.concurrent.atomic.AtomicLong;

public class UserIdGenerator {

	private static AtomicLong id = new AtomicLong(1);

	public static long getID() {
		return id.getAndIncrement();
	}

	public static void resetIndex() {
		id = new AtomicLong(1);
	}

}
