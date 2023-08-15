package org.objectworld.docker.hello;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloApplication {
	private static String ipAddress = null;
	
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			ipAddress = ip.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/hello")
	public String hello() throws UnknownHostException {
		return "Hello ObjectWorld! I'm " + ipAddress + ".\n";
	}
}
