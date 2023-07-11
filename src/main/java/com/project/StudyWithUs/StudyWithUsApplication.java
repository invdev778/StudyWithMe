package com.project.StudyWithUs;

import com.project.StudyWithUs.common.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class StudyWithUsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyWithUsApplication.class, args);
	}

	@Bean
	public WebConfig webConfig() {
		return new WebConfig() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
