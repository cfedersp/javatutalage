package org.cjf.demo.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.cjf.demo.service.MessageService;
import org.cjf.demo.models.WelcomeMsg;
import java.lang.RuntimeException;

@Slf4j
@Component("messageServiceStub")
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "feature.message", name="provider", havingValue="V1")
public class MessageServiceImpl implements MessageService {
	
	@Value("${messageProvider.uri}")
	private String messageProviderUri;

	private RestTemplate restTemplate;

	public String getMessage() {
		ResponseEntity<WelcomeMsg> responseMsg = restTemplate.getForEntity(messageProviderUri, WelcomeMsg.class);
		if(responseMsg.getBody().getError() != null) {
			throw new RuntimeException(responseMsg.getBody().getError());
		}
		return responseMsg.getBody().getMessage();
	}

}
