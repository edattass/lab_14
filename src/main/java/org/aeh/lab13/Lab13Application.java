package org.aeh.lab13;

import org.aeh.lab13.model.User;
import org.aeh.lab13.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab13Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab13Application.class, args);
	}

	@Bean
	public CommandLineRunner demoUsers(UserService userService) {
		return args -> {
			addUserIfNotExists(userService, "eda", "eda@mail.com", "password1");
			addUserIfNotExists(userService, "admin", "admin@mail.com", "admin123");
			addUserIfNotExists(userService, "eva", "eva@mail.com", "evapass");
		};
	}

	private void addUserIfNotExists(UserService userService, String username, String email, String password) {
		if (userService.findByUsername(username).isEmpty()) {
			userService.createUser(username, email, password);
			System.out.println("✅ User created: " + username);
		} else {
			System.out.println("⚠️ User already exists: " + username);
		}
	}
}

