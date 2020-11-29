package org.cjf.demo.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.cjf.demo.service.MessageService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	@Value("messageProvider.uri")
	private String messageProviderUri;

	public String getMessage() {
		return messageProviderUri;
	}
}
