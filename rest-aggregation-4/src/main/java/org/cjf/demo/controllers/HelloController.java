package org.cjf.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.cjf.demo.models.WelcomeResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.cjf.demo.service.MessageService;
import java.io.IOException;

// Visit this url in a webbrowser to see the output:
// http://localhost:8080/
@RestController
@RequiredArgsConstructor
public class HelloController {
	private final MessageService msgService;

	@RequestMapping("/")
	public WelcomeResponse index() throws IOException {
		return new WelcomeResponse(msgService.getMessage(), null);
	}

}
