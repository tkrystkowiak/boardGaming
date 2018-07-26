package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.UserProfileAndRanking.enitities.Availability;
import com.capgemini.UserProfileAndRanking.enitities.Hour;
import com.capgemini.UserProfileAndRanking.enitities.Status;
import com.capgemini.UserProfileAndRanking.repositories.implementation.AvailabilityDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailabilityDaoTest {

	@Autowired
	AvailabilityDaoImpl avDAO;

	private Availability sampleAv;

	@Before
	public void initialize() {
		sampleAv = new Availability(1, Hour.H15_00, Hour.H17_30);
		avDAO.addAvailability(sampleAv);
		avDAO.addAvailability(new Availability(1, Hour.H20_00, Hour.H22_00));
		avDAO.addAvailability(new Availability(2, Hour.H16_00, Hour.H17_00));
		avDAO.addAvailability(new Availability(3, Hour.H15_00, Hour.H17_00));
		avDAO.addAvailability(new Availability(4, Hour.H19_30, Hour.H20_00));
	}

	@Test
	public void shouldAddCorrectlyTest() {
		Availability expected = new Availability(4, Hour.H02_00, Hour.H03_00);
		avDAO.addAvailability(expected);
		Availability actual = avDAO.getAvailabilityByHours(4, Hour.H02_00, Hour.H03_00);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnCorrectAvailabilityTest() {
		Availability actual = avDAO.getAvailabilityByHours(1, Hour.H15_00, Hour.H17_30);
		assertEquals(sampleAv.getUserID(), actual.getUserID());
		assertEquals(sampleAv.getBeginningHour(), actual.getBeginningHour());
		assertEquals(sampleAv.getFinishHour(), actual.getFinishHour());
		assertEquals(sampleAv.getStatus(), actual.getStatus());

	}

	@Test
	public void shouldDeleteAvailabiltyTest() {
		Availability toDelete = new Availability(3, Hour.H15_00, Hour.H17_00);
		toDelete.setComment("sorry");
		avDAO.deleteAvailability(3, toDelete);
		Availability deleted = avDAO.getAvailabilityByHours(3, Hour.H15_00, Hour.H17_00);
		assertEquals("sorry", deleted.getComment());
		assertEquals(Status.CANCELLED, deleted.getStatus());
	}

	@Test
	public void shouldReturnEditedAvailabilityTest() {
		Availability oldAv = new Availability(4, Hour.H19_30, Hour.H20_00);
		Availability av = new Availability(4, Hour.H19_30, Hour.H20_30);
		avDAO.editAvailability(av, oldAv);
		assertTrue(avDAO.getAvailabilityByHours(4, Hour.H19_30, Hour.H20_30) != null);
	}

	@Test
	public void shouldReturnListOfUserIdsWithMatchingAvailabilitiesTest() {
		Set<Long> actual = avDAO.getMatchingAvailability(2);
		assertEquals(1, actual.size());

	}

}
