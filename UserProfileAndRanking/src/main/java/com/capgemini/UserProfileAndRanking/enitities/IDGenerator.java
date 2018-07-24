package com.capgemini.UserProfileAndRanking.enitities;

import java.util.concurrent.atomic.AtomicLong;

public class IDGenerator {

	private  static  AtomicLong id;
	
	public  IDGenerator(){
		id = new AtomicLong();
	}
	
	public static long getID(){
		return id.getAndIncrement();
	}
	
}
