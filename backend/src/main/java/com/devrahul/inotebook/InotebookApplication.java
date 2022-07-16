package com.devrahul.inotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
@EntityScan
@Configuration
@SpringBootApplication
public class InotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(InotebookApplication.class, args);
	}

}
