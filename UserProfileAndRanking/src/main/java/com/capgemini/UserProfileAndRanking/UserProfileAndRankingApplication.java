package com.capgemini.UserProfileAndRanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.UserProfileAndRanking.enitities.User;
import com.capgemini.UserProfileAndRanking.services.UserEditService;
import com.capgemini.UserProfileAndRanking.services.implementation.UserEditServiceImpl;

@SpringBootApplication
public class UserProfileAndRankingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserProfileAndRankingApplication.class, args);
		
	}
}
