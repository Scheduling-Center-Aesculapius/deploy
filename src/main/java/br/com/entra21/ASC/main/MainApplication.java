package br.com.entra21.ASC.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MainApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		System.out.println("Hello World");
	}


}
