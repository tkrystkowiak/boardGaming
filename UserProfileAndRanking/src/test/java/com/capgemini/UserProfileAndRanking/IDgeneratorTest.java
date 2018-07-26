package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.UserProfileAndRanking.enitities.UserIdGenerator;

public class IDgeneratorTest {

	@Test
	public void shouldGenerateCorrectLongsTest() {
		assertEquals(1, UserIdGenerator.getID());
		assertEquals(2, UserIdGenerator.getID());
	}

}
