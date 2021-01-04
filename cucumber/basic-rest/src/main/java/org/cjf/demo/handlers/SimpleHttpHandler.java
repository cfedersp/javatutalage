package org.cjf.demo.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.cjf.demo.models.WelcomeResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class SimpleHttpHandler implements HttpHandler {
	ObjectMapper mapper = new ObjectMapper();
	
	@SuppressWarnings("restriction") // not all JREs include com.sun.net
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		System.out.println("Handling request");
		OutputStream outputStream = httpExchange.getResponseBody();
		if ("GET".equals(httpExchange.getRequestMethod())) {
			System.out.println("Returning greeting");
			WelcomeResponse greeting = new WelcomeResponse("Rock on", null);
			String responseBody = mapper.writeValueAsString(greeting); // Dont write directly to the OutputStream - we need the length
			Headers responseHeaders = httpExchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "application/json");
			httpExchange.sendResponseHeaders(200, responseBody.length());
			outputStream.write(responseBody.getBytes(Charset.forName("UTF-8")));
			outputStream.flush();
		}
        outputStream.close();
	}
}
