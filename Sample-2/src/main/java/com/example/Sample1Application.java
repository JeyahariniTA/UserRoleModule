package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.Config;

@SpringBootApplication
public class Sample1Application {

	@Autowired
	private Config config;

	public static void main(String[] args) {
		SpringApplication.run(Sample1Application.class, args);
	}

	public void run(String... strings) {
		System.out.println(config);
	}
}
