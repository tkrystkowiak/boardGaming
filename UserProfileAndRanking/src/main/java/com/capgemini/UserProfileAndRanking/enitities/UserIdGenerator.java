package com.capgemini.UserProfileAndRanking.enitities;

import java.util.concurrent.atomic.AtomicLong;

public class UserIdGenerator {

	private  static  AtomicLong id;
	
	public  UserIdGenerator(){
		id = new AtomicLong();
	}
	
	public static long getID(){
		return id.getAndIncrement();
	}
	
}
