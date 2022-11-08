package com.chaOreum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/contents_img/**")
				.addResourceLocations("file:///home/ubuntu/chaOreum/images/contents_img/");
		
		registry.addResourceHandler("/contents_img_remove/**")
				.addResourceLocations("file:///home/ubuntu/chaOreum/images/contents_img_remove/");
		
		registry.addResourceHandler("/notice_img/**")
				.addResourceLocations("file:///home/ubuntu/chaOreum/images/notice_img/");
		
		registry.addResourceHandler("/notice_img_remove/**")
				.addResourceLocations("file:///home/ubuntu/chaOreum/images/notice_img_remove/");
		
		registry.addResourceHandler("/post_attachments/**")
				.addResourceLocations("file:///home/ubuntu/chaOreum/images/post_attachments/");
	}
	
}
