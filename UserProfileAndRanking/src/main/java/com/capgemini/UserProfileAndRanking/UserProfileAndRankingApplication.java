package com.capgemini.UserProfileAndRanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.UserProfileAndRanking.enitities.User;

@SpringBootApplication
public class UserProfileAndRankingApplication {
	
	@Autowired
	User uB;
	
	public static void main(String[] args) {
		SpringApplication.run(UserProfileAndRankingApplication.class, args);
		
	}
}
