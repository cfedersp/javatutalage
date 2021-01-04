package org.cjf.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WelcomeResponse {
	private String message;
	private Integer errorCode;
	
}