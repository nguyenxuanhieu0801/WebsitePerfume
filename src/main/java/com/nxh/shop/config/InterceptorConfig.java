package com.nxh.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nxh.shop.interceptor.AdminAuthenticationInterceptor;
import com.nxh.shop.interceptor.ClientAuthenticationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired 
	private AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	
	@Autowired 
	private ClientAuthenticationInterceptor clientAuthenticationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationInterceptor)
		  		.addPathPatterns("/admin/**")
		  		.excludePathPatterns("/login", "/register");
		
		registry.addInterceptor(clientAuthenticationInterceptor)
  		.addPathPatterns("/user/profile", "/user/order");
	}
}
