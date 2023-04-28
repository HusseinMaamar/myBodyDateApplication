package com.MyBodyDateAppBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MyBodyDateAppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBodyDateAppBackApplication.class, args);
		UUID uuid = UUID.randomUUID();
		String uniqueId = uuid.toString();
		System.out.println("Generated Unique ID: " + uniqueId);
		System.out.println("lisen to 8080");
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		String formattedDate = formatter.format(currentDate);
		System.out.println("Current date and time: " + formattedDate);
	}

}
