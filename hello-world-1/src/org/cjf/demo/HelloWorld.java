package org.cjf.demo;

public class HelloWorld {
	public static void main(String[] args) {
		StringBuilder message = new StringBuilder();
		message.append("Hello");
		if(args.length > 0) {
			message.append(", ");
			message.append(args[0]);
		} else {
			message.append(", World!");
		}
		System.out.println(message.toString());
	}
}
