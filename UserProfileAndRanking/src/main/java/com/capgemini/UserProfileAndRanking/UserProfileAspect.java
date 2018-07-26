package com.capgemini.UserProfileAndRanking;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProfileAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileAspect.class);

	@Before("within(org.capgemini..*)")
	public void methodTimeLoggingBeforeStart() {
		LOGGER.info("methodStarted");
	}

	@After("within(org.capgemini..*)")
	public void methodTimeLoggingAfterStart() {
		LOGGER.info("methodFinished");
	}

}
