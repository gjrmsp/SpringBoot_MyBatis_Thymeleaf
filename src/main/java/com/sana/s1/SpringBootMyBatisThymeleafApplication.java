package com.sana.s1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootMyBatisThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisThymeleafApplication.class, args);
	}

}
