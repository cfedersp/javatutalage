package org.cjf.demo;

import org.cjf.demo.handlers.SimpleHttpHandler;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DemoApplication {

	@SuppressWarnings("restriction")
	public static void main(String[] args) throws IOException {
		System.out.println("Starting Basic Server");
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
		server.createContext("/simplegreeting", (HttpHandler) new SimpleHttpHandler());
		server.setExecutor(threadPoolExecutor);
		server.start();
		System.out.println(" Server started on port 8001");
	}
}
