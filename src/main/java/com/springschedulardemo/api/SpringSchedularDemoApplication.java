package com.springschedulardemo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.springschedulardemo")
public class SpringSchedularDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedularDemoApplication.class, args);
	}

}
