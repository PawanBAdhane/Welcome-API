package com.nsm.WelcomeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("src/main/java/com/nsm/WelcomeAPI")
public class WelcomeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeApiApplication.class, args);
	}

}
