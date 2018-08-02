package com.capgemini.UserProfileAndRanking;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.UserProfileAndRanking.controllers.UserEditController;
import com.capgemini.UserProfileAndRanking.transferobjects.UserTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserProfileAndRankingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEditControllerTest {

	@Autowired
	private UserEditController userEditController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void showUserByIdTest() {
		// given
		String targetUrl = "http://localhost:8080/userById?id=2";

		// when
		ResponseEntity<UserTO> response = restTemplate.getForEntity(targetUrl, UserTO.class);

		// then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Indiana", response.getBody().getFirstName());
		assertEquals("Jones", response.getBody().getLastName());
		assertEquals("indiana@jones.com", response.getBody().getEmail());
	}

	@Test
	public void showUserByParamsTest() {
		// given
		String targetUrl = "http://localhost:8080/userByParams?firstName=Albert&lastName=Einstein&email=albert@email.com";

		// when
		ResponseEntity<List<UserTO>> response = restTemplate.exchange(targetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserTO>>() {
				});
		List<UserTO> users = response.getBody();
		UserTO user = users.get(0);

		// then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Albert", user.getFirstName());
		assertEquals("Einstein", user.getLastName());
		assertEquals("albert@email.com", user.getEmail());
	}

	@Test
	public void editUserTest() {
		// given
		JSONObject request = new JSONObject();
		request.put("id", 3);
		request.put("firstName", "Ramzes");
		request.put("lastName", "theSecond");
		request.put("email", "ramzes@email.com");
		request.put("lifemotto", "life is great");
		String targetUrl = "http://localhost:8080/editUser";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		// when
		ResponseEntity<String> response = restTemplate.postForEntity(targetUrl, entity, String.class);

		// then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("user edited", response.getBody());

	}

}
