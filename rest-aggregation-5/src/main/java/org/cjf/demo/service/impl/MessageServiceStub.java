package org.cjf.demo.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.cjf.demo.service.MessageService;

@Slf4j
@Component("messageServiceStub")
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "feature.message", name="provider", havingValue="stub")
public class MessageServiceStub implements MessageService {
	
	@Value("${stub.message}")
	private String message;

	public String getMessage() {
		return message;
	}
}
