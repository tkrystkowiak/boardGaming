package com.capgemini.UserProfileAndRanking.utils;

import java.util.concurrent.atomic.AtomicLong;

public class GameIdGenerator {

	private static AtomicLong id = new AtomicLong();

	public static long getID() {
		return id.getAndIncrement();
	}

}
