package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.UserProfileAndRanking.utils.UserIdGenerator;

public class IDgeneratorTest {

	@Test
	public void shouldGenerateCorrectLongsTest() {
		UserIdGenerator.resetIndex();
		assertEquals(1, UserIdGenerator.getID());
		assertEquals(2, UserIdGenerator.getID());
	}

}
