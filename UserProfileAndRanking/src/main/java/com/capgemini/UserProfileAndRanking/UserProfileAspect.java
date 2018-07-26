package com.capgemini.UserProfileAndRanking;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserProfileAspect {

	private static final Logger LOGGER = Logger.getLogger("AspectLogging");

	@Before("execution(*com.capgemini.UserProfileAndRanking..*(..))")
	public void loggingMethodArguments(JoinPoint joinPoint) {

		Object[] arguments = joinPoint.getArgs();
		for (Object arg : arguments) {
			LOGGER.info("Method took argument " + arg);
		}
	}

	@Pointcut("execution(*com.capgemini.UserProfileAndRanking..*(..))")
	public void methods() {
	}

	@Around("methods()")
	public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		long methodStartTime = System.currentTimeMillis();
		Object output = pjp.proceed();
		long executionTime = System.currentTimeMillis() - methodStartTime;
		LOGGER.info("Method executed in " + executionTime + " milliseconds.");
		return output;
	}

}
