package com.cjf.demo.cucumber;

import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.*;

import java.io.IOException;

import org.cjf.demo.DemoApplication;
import org.hamcrest.Matcher;

public class StepDefinitions {

	@Before
	public void startApp() throws IOException {
		DemoApplication.main(null);
	}
	
	@Given("Request greeting")
	public void requestGreeting() {
		
	}
	
	@Then("Response field {string} contains {string}")
	public void assertResponse(String fieldName, String expectedContent) {
		given().get("http://localhost:8001/simplegreeting").then().body(".", new ResponseAwareMatcher() {
			@Override
			public Matcher matcher(ResponseBody response) throws Exception {
				// TODO Auto-generated method stub
				return hasKey(fieldName);
			}
       });
	}
}
