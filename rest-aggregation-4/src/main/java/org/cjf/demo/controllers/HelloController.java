package org.cjf.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.cjf.demo.models.WelcomeResponse;

// Visit this url in a webbrowser to see the output:
// http://localhost:8080/
@RestController
public class HelloController {

	@Value("${demo.welcomeMsg}") // Spring expression language: gets value from a property or environment variable
	private String welcomeMsg;
	
	@RequestMapping("/")
	public WelcomeResponse index() {
		return new WelcomeResponse(welcomeMsg, null);
	}

}