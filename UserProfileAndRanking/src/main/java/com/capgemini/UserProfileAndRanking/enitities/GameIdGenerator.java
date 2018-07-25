package com.capgemini.UserProfileAndRanking.enitities;

import java.util.concurrent.atomic.AtomicLong;

public class GameIdGenerator {

	private static AtomicLong id;

	public GameIdGenerator() {
		id = new AtomicLong();
	}

	public static long getID() {
		return id.getAndIncrement();
	}

}
