package org.cjf.demo.exception;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
	}
	public InvalidInputException(String badInput, String condition) {
		super(badInput + " matched condition: " + condition);
	}
}
