package com.sana.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sana.s1.interceptor.WriterInterceptor;

@Configuration
public class WriterInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private WriterInterceptor writerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(writerInterceptor)
				.addPathPatterns("/qna/update");
	}
}