package com.Rohan.Project.SpringMondoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMondoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMondoDbApplication.class, args);
		System.out.println("Mongo Db restapi application working sucessfully");
	}

}
