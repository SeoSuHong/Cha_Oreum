package com.chaOreum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ChaOreumApplication extends SpringBootServletInitializer {
	//war 파일 배포를 위한 소스
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ChaOreumApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ChaOreumApplication.class, args);
	}

}
