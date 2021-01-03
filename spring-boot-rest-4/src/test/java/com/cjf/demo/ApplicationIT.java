package com.cjf.demo;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.cjf.demo.DemoApplication;
import org.cjf.demo.config.DemoConfig;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import io.restassured.matcher.ResponseAwareMatcher;

@Slf4j
@SpringBootTest(classes = {DemoApplication.class, DemoConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // this starts an instance of our application
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class ApplicationIT {

	@LocalServerPort
	private int port;
	
	@Test
	public void testServiceIsAvailable() {
		assertNotEquals(0, port);
	}
	
	/**
	 * This is an example of what NOT to do. There is usually no need for JSON to match exactly!
	 * Also, escape chars are a major pain.
	 * Requiring the response to match EXACTLY does not save time in the long run.
	 */
	@Disabled 
	public void testServiceReturnsExactJSON() {
		ExtractableResponse<Response> response = given().get("http://localhost:" + port +"/").then().extract();
		assertTrue(response.asString().equals("{\"message\":\"Greetings from Spring Boot!\"}"));
	}
	
	/**
	 * Another example of what not to do. traditional HttpClient sample. 
	 * This method shows that rest-assured library is much more convenient to use.
	 * In fact, sometimes you see rest-assured not only in test code, but also production code!
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void testServiceReturnsGreetingWithHttpClient() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("http://localhost:" + port +"/");

        // add request headers
        request.addHeader("Accept", "application/json");

        CloseableHttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        assertTrue(responseBody.contains("Greeting")); 
	}
	
	@Test
	public void testServiceReturnsGreeting() {
		ExtractableResponse<Response> response = given().get("http://localhost:" + port +"/").then().extract();
		assertTrue(response.asString().contains("Greeting"));
	}
	
	@Disabled
	public void testServiceReturnsJsonGreeting() {
		given().get("http://localhost:" + port +"/").then().body(".", new ResponseAwareMatcher() {
			@Override
			public Matcher matcher(ResponseBody response) throws Exception {
				// TODO Auto-generated method stub
				return hasKey("message");
			}
       });
	}

}
