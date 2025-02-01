package org.aeh.lab13;

import org.springframework.boot.SpringApplication;

public class TestLab13Application {

	public static void main(String[] args) {
		SpringApplication.from(Lab13Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
