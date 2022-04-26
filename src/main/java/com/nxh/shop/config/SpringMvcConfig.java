package com.nxh.shop.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		exposeDirectory("uploads", registry);
	}
	
	public void exposeDirectory(String directoryName, ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get(directoryName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();
		if(directoryName.startsWith("../")) {
			directoryName = directoryName.replace("../", "");
		}
		registry.addResourceHandler("/" + directoryName + "/**")
			.addResourceLocations("file:/" + uploadPath + "/");
	}
}
