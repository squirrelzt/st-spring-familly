package com.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(StDruidApplication.class, args);
	}

}
