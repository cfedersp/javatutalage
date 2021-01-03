package org.cjf.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class DemoConfig {
	
	@Bean
	public ObjectMapper createJsonMapper() {
		ObjectMapper ignoreNullMapper = new ObjectMapper();
		ignoreNullMapper.setSerializationInclusion(Include.NON_NULL);
		return ignoreNullMapper;
	}
}