package com.springschedulardemo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConversionConfig {
	
	@Bean
	@Scope(value = "singleton")
	public Map<String,Double> conversionId()
	{
		return new HashMap<>();
	}
	

}
