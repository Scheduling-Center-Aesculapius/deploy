package br.com.entra21.ASC.main.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebConfig {
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET", "POST", "PUT", "DELETE");

	}
}
